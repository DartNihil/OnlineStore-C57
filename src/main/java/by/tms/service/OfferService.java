package by.tms.service;

import by.tms.composite.OfferComposite;
import by.tms.entity.*;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class OfferService {
    @Autowired
    @Qualifier("inMemoryOfferStorage")
    private Storage<Offer, Long> offerStorage;

    public Offer saveOffer(Offer offer) {
        offerStorage.save(offer);
        return offer;
    }

    public Offer createOfferWithStoreAndProductCategory(Store store, Product product) {
        Offer offer = new Offer();
        offer.setStore(store);
        offer.setProduct(product);
        return offer;
    }
    public Optional<Offer> findOfferById(long id) {
        return offerStorage.findById(id);
    }

    public List<OfferComposite> addOfferToCart(long offerId, Customer customer) {

        List<OfferComposite> cart = customer.getCart();
        boolean isOfferInCart = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getOffer().getId() == offerId) {
                isOfferInCart = true;
                int count = cart.get(i).getCount();
                cart.get(i).setCount(count + 1);
                break;
            }
        }
        if (!isOfferInCart) {
            Optional<Offer> offerInBase = findOfferById(offerId);
            Offer offer = null;
            if (offerInBase.isPresent()) {
                offer = offerInBase.get();
            }
            OfferComposite offerComposite = new OfferComposite(offer, 1);
            cart.add(offerComposite);
        }
        return cart;
    }

    public BigDecimal findTotalPriceOffersInCart(List<OfferComposite> cart) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (int i = 0; i < cart.size(); i++) {
            BigDecimal offerCompositePrice = cart.get(i).getOffer().getPrice().multiply(new BigDecimal(cart.get(i).getCount()));
            totalPrice = totalPrice.add(offerCompositePrice);
        }
        return totalPrice;
    }

    public List<OfferComposite> deleteOfferFromCart(long offerId, Customer customer) {
        List<OfferComposite> cart = customer.getCart();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getOffer().getId() == offerId) {
                cart.remove(i);
                break;
            }
        }
        return cart;
    }

    public List<OfferComposite> minusOfferCount(long offerId, Customer customer) {
        List<OfferComposite> cart = customer.getCart();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getOffer().getId() == offerId) {
                int count = cart.get(i).getCount();
                if (count > 1) {
                    cart.get(i).setCount(count - 1);
                }
                break;
            }
        }
        return cart;
    }

    public List<OfferComposite> plusOfferCount(long offerId, Customer customer) {
        List<OfferComposite> cart = customer.getCart();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getOffer().getId() == offerId) {
                int count = cart.get(i).getCount();
                cart.get(i).setCount(count + 1);
                break;
            }
        }
        return cart;
    }
}
