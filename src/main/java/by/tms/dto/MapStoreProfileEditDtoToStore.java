package by.tms.dto;

import by.tms.entity.Store;

public class MapStoreProfileEditDtoToStore {
    public Store convertStoreProfileEditDTOToStore(StoreProfileEditDto storeProfileEditDTO, Store store) {
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
