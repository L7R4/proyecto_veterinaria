package Templates;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManager manager = new EntityManager();

        // Create some sample entities
        Person alice = new Person("1", "Alice", 30);
        Person bob = new Person("2", "Bob", 25);
        Person charlie = new Person("3", "Charlie", 35);

        // Perform CRUD operations
        manager.create(alice);
        manager.create(bob);
        manager.create(charlie);

        System.out.println("All entities:");
        manager.printAllEntities();

        // Update an entity
        alice.setAge(31);
        manager.update(alice);

        // Read an entity
        Person readPerson = (Person) manager.read("1");
        System.out.println("Read person: " + readPerson);

        // Delete an entity
        manager.delete("2");

        System.out.println("Entities after update and delete:");
        manager.printAllEntities();

        // Perform searches
        SearchCriteria ageCriteria = new SearchCriteria(EntityType.PERSON);
        ageCriteria.addFilter("age", 35);

        List<Entity> searchResults = manager.search(ageCriteria);
        System.out.println("Search results for age 35:");
        for (Entity entity : searchResults) {
            System.out.println(entity);
        }

        // Unique search
        Set<Entity> uniqueResults = manager.searchUnique(ageCriteria);
        System.out.println("Unique search results:");
        for (Entity entity : uniqueResults) {
            System.out.println(entity);
        }

        // Sorted search
        Set<Entity> sortedResults = manager.searchSorted(ageCriteria);
        System.out.println("Sorted search results:");
        for (Entity entity : sortedResults) {
            System.out.println(entity);
        }

        // Pagination
        SearchCriteria allPersons = new SearchCriteria(EntityType.PERSON);
        List<Entity> paginatedResults = manager.searchWithPagination(allPersons, 1, 2);
        System.out.println("Paginated results (page 1, size 2):");
        for (Entity entity : paginatedResults) {
            System.out.println(entity);
        }

        // Grouping
        Map<String, List<Entity>> groupedResults = manager.groupSearchResults(allPersons, "age");
        System.out.println("Grouped results by age:");
        for (Map.Entry<String, List<Entity>> entry : groupedResults.entrySet()) {
            System.out.println("Age " + entry.getKey() + ":");
            for (Entity entity : entry.getValue()) {
                System.out.println("  " + entity);
            }
        }

        // Recent searches
        List<SearchCriteria> recentSearches = manager.getRecentSearches();
        System.out.println("Recent searches:");
        for (SearchCriteria criteria : recentSearches) {
            System.out.println(criteria.getType() + ": " + criteria.getFilters());
        }

        // Clear search cache
        manager.clearSearchCache();
        System.out.println("Search cache cleared");
    }
}