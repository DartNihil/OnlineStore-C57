package by.tms.service;

import by.tms.entity.Offer;
import by.tms.entity.Store;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
}
