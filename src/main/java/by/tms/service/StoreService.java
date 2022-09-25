package by.tms.service;

import by.tms.entity.Store;
import by.tms.storage.InMemoryStoreStorage;
import by.tms.storage.Storable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    @Qualifier("InMemoryStoreStorage")
    private Storable<Store, Long> storeStorage;

    public Store saveStore(Store store) {
        storeStorage.save(store);
        return store;
    }
}
