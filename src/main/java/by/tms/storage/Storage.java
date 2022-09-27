package by.tms.storage;

import java.util.List;
import java.util.Optional;

public interface Storage<Entity, Id> extends CrudDao<Entity, Id>{
    List<Entity> getListOfEntity();

    Optional<Entity> findEntity(String parameter);
}