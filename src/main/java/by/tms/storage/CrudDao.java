package by.tms.storage;

import java.util.Optional;

public interface CrudDao<Entity, Id> {
    Entity save(Entity entity);

    Optional<entity> findById(Id id);
}