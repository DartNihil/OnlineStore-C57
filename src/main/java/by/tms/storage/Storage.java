package by.tms.storage;

import java.util.List;
import java.util.Optional;

public interface Storage<T, E> extends CrudDao<T, E>{
    List<T> getListOfEntity();

    Optional<T> findEntity(String parameter);
}
