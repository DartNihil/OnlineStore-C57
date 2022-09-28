package by.tms.entity;

public abstract class Entity {
    private long id;

    public Entity() {
    }

    public Entity(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}