package by.tms.service;

import by.tms.entity.*;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OfferService {
    @Autowired
    @Qualifier("inMemoryOfferStorage")
    private Storage<Offer, Long> offerStorage;

    public Offer saveOffer(Offer offer, Store store) {
        offer.setStore(store);
        offerStorage.save(offer);
        System.out.println(offer.getProduct().getClass().toString());
        System.out.println(offer);
        return offer;
    }
    public Offer createOfferWithStoreAndProductCategory(Offer offer, Store store, String productCategory) {
        offer.setStore(store);
        Map<String, Product> productMap = new HashMap<>();
        productMap.put("Smartphone", new Smartphone());
        productMap.put("Notebook", new Notebook());
        productMap.put("ElectronicBook", new ElectronicBook());
        productMap.put("Smartwatch", new Smartwatch());
        productMap.put("Tablet", new Tablet());
        for (String key: productMap.keySet()) {
            if (key.equals(productCategory)) {
                offer.setProduct(productMap.get(key));
            }
        }
        return offer;
    }
}
