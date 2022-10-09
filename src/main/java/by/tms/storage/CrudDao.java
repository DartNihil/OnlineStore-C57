package by.tms.storage;

import java.util.Optional;

public interface CrudDao<T, ID> {
    T save(T entity);

    Optional<T> findById(ID id);
    T delete(T entity);
}