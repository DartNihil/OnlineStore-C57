package by.tms.entity;

public abstract class Entity {
    long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}
