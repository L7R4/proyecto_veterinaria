package Templates;


import java.util.Comparator;

public class EntityComparator implements Comparator<Entity> {
    @Override
    public int compare(Entity e1, Entity e2) {
        int typeComparison = e1.getType().compareTo(e2.getType());
        if (typeComparison != 0) {
            return typeComparison;
        }
        return e1.getId().compareTo(e2.getId());
    }
}