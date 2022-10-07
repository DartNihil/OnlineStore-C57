package by.tms.service;

import by.tms.entity.Customer;
import by.tms.entity.Store;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    @Qualifier("inMemoryStoreStorage")
    private Storage<Store, Long> storeStorage;

    public Store saveStore(Store store) {
        storeStorage.save(store);
        return store;
    }
    public Optional<Store> findStoreByEmail(String email){
        return storeStorage.findEntity(email);
    }
}
