package by.tms.entity;

public abstract class AbstractEntity {
    private long id;

    public AbstractEntity() {
    }

    public AbstractEntity(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}