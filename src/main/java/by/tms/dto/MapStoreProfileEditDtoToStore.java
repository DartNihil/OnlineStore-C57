package by.tms.dto;

import by.tms.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class MapStoreProfileEditDtoToStore {
    public Store convertStoreProfileEditDtoToStore(StoreProfileEditDto storeProfileEditDTO, Store store) {
        store.setStoreName(storeProfileEditDTO.getStoreName());
        store.setStorePhoneNumber(storeProfileEditDTO.getStorePhoneNumber());
        store.setStoreAddress(storeProfileEditDTO.getStoreAddress());
        store.setStoreOpeningHours(storeProfileEditDTO.getStoreOpeningHours());
        store.setProductCategories(storeProfileEditDTO.getProductCategories());
        store.setPaymentMethods(storeProfileEditDTO.getPaymentMethods());
        store.setDeliveryMethods(storeProfileEditDTO.getDeliveryMethods());
        return store;
    }
}
