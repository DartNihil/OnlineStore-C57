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

    public Offer saveOffer(Offer offer) {
        offerStorage.save(offer);
        System.out.println(offer);
        return offer;
    }

    public Offer createOfferWithStoreAndProductCategory(Store store, Product product) {
        Offer offer = new Offer();
        offer.setStore(store);
        offer.setProduct(product);
        return offer;
    }
}
