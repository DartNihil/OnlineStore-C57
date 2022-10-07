package by.tms.entity;

public abstract class abstractEntity {
    private long id;

    public abstractEntity() {
    }

    public abstractEntity(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}