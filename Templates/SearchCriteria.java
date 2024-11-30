package Templates;

import java.util.HashMap;
import java.util.Map;

public class SearchCriteria {
    private EntityType type;
    private Map<String, Object> filters;

    public SearchCriteria(EntityType type) {
        this.type = type;
        this.filters = new HashMap<>();
    }

    public void addFilter(String key, Object value) {
        filters.put(key, value);
    }

    public EntityType getType() {
        return type;
    }

    public Map<String, Object> getFilters() {
        return filters;
    }
}