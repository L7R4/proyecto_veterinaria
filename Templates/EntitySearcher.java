package Templates;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EntitySearcher {
    private EntityManager entityManager;
    private Map<EntityType, LinkedList<Entity>> entityCache;
    private LinkedList<SearchCriteria> recentSearches;
    private static final int MAX_RECENT_SEARCHES = 10;

    public EntitySearcher(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityCache = new HashMap<>();
        this.recentSearches = new LinkedList<>();
    }

    public List<Entity> search(SearchCriteria criteria) {
        addToRecentSearches(criteria);
        List<Entity> results = new ArrayList<>();

        if (!entityCache.containsKey(criteria.getType())) {
            entityCache.put(criteria.getType(), new LinkedList<>(entityManager.getEntitiesByType(criteria.getType())));
        }

        LinkedList<Entity> entities = entityCache.get(criteria.getType());
        Predicate<Entity> filter = createFilterPredicate(criteria);

        for (Entity entity : entities) {
            if (filter.test(entity)) {
                results.add(entity);
            }
        }

        return results;
    }

    private void addToRecentSearches(SearchCriteria criteria) {
        recentSearches.addFirst(criteria);
        if (recentSearches.size() > MAX_RECENT_SEARCHES) {
            recentSearches.removeLast();
        }
    }

    public Set<Entity> searchUnique(SearchCriteria criteria) {
        return new HashSet<>(search(criteria));
    }

    public Set<Entity> searchSorted(SearchCriteria criteria) {
        return new TreeSet<>(search(criteria));
    }

    public List<Entity> searchWithPagination(SearchCriteria criteria, int page, int pageSize) {
        List<Entity> allResults = search(criteria);
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, allResults.size());
        return allResults.subList(start, end);
    }

    public Map<String, List<Entity>> groupSearchResults(SearchCriteria criteria, String groupByField) {
        List<Entity> results = search(criteria);
        return results.stream().collect(Collectors.groupingBy(entity -> getFieldValue(entity, groupByField)));
    }

    private Predicate<Entity> createFilterPredicate(SearchCriteria criteria) {
        return entity -> criteria.getFilters().entrySet().stream()
                .allMatch(entry -> {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Object entityValue = getFieldValue(entity, key);
                    return value.equals(entityValue);
                });
    }

    private String getFieldValue(Entity entity, String fieldName) {
        try {
            return entity.getClass().getMethod("get" + capitalize(fieldName)).invoke(entity).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error accessing field: " + fieldName, e);
        }
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public List<SearchCriteria> getRecentSearches() {
        return new ArrayList<>(recentSearches);
    }

    public void clearCache() {
        entityCache.clear();
    }
}