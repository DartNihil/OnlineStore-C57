package by.tms.storage;

import java.util.Optional;

public interface CrudDao<T, E> {
    T save(T entity);

    Optional<T> findById(E id);
}
