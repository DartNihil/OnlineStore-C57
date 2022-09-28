package by.tms.storage;

import java.util.List;
import java.util.Optional;

public interface Storage<T, ID> extends CrudDao<T, ID>{
    List<T> getListOfEntity();

    Optional<T> findEntity(String parameter);
}