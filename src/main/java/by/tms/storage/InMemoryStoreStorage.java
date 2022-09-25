package by.tms.storage;

import by.tms.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryStoreStorage")
public class InMemoryStoreStorage implements Storable<Store, Long> {
    @Autowired
    private List<Store> storeList;
    @Autowired
    private AtomicLong storeIdGenerator;

    @Override
    public Store save(Store store) {
        store.setId(storeIdGenerator.incrementAndGet());
        storeList.add(store);
        return store;
    }

    @Override
    public Optional<Store> findById(Long id) {
        for (Store store : storeList) {
            if (store.getId() == id) {
                return Optional.of(store);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Store> getListOfEntity() {
        return storeList;
    }

    @Override
    public Optional<Store> findEntity(String email) {
        for (Store store : storeList) {
            if (store.getEmail().equals(email)) {
                return Optional.of(store);
            }
        }
        return Optional.empty();
    }
}
