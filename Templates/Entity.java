package Templates;

import java.io.Serializable;
import java.util.Objects;

public abstract class Entity implements Serializable, Comparable<Entity> {
    private static final long serialVersionUID = 1L;
    
    protected String id;
    protected EntityType type;

    public Entity(String id, EntityType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id) && type == entity.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(Entity o) {
        return this.id.compareTo(o.id);
    }
}