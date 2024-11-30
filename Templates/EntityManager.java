package Templates;


import java.io.*;
import java.util.*;

public class EntityManager {
    private static final String FILE_NAME = "entities.data";
    private Map<String, Entity> entities;
    private EntitySearcher searcher;

    public EntityManager() {
        this.entities = new HashMap<>();
        loadEntities();
        this.searcher = new EntitySearcher(this);
    }

    public void create(Entity entity) {
        entities.put(entity.getId(), entity);
        saveEntities();
    }

    public Entity read(String id) {
        Entity entity = entities.get(id);
        if (entity == null) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        return entity;
    }

    public void update(Entity entity) {
        if (!entities.containsKey(entity.getId())) {
            throw new EntityNotFoundException("Entity with id " + entity.getId() + " not found");
        }
        entities.put(entity.getId(), entity);
        saveEntities();
    }

    public void delete(String id) {
        if (!entities.containsKey(id)) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        entities.remove(id);
        saveEntities();
    }

    public List<Entity> getAllEntities() {
        return new ArrayList<>(entities.values());
    }

    public Set<Entity> getUniqueEntities() {
        return new HashSet<>(entities.values());
    }

    public Set<Entity> getSortedEntities() {
        return new TreeSet<>(entities.values());
    }

    public List<Entity> getEntitiesByType(EntityType type) {
        List<Entity> result = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity.getType() == type) {
                result.add(entity);
            }
        }
        return result;
    }

    private void loadEntities() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                entities = (Map<String, Entity>) obj;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing file found. Starting with an empty entity list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveEntities() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(entities);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllEntities() {
        for (Entity entity : entities.values()) {
            System.out.println(entity);
        }
    }

    public List<Entity> search(SearchCriteria criteria) {
        return searcher.search(criteria);
    }

    public Set<Entity> searchUnique(SearchCriteria criteria) {
        return searcher.searchUnique(criteria);
    }

    public Set<Entity> searchSorted(SearchCriteria criteria) {
        return searcher.searchSorted(criteria);
    }

    public List<Entity> searchWithPagination(SearchCriteria criteria, int page, int pageSize) {
        return searcher.searchWithPagination(criteria, page, pageSize);
    }

    public Map<String, List<Entity>> groupSearchResults(SearchCriteria criteria, String groupByField) {
        return searcher.groupSearchResults(criteria, groupByField);
    }

    public List<SearchCriteria> getRecentSearches() {
        return searcher.getRecentSearches();
    }

    public void clearSearchCache() {
        searcher.clearCache();
    }
}