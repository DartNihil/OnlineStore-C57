package by.tms.service;

import by.tms.dto.OfferWithCountDto;
import by.tms.entity.*;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
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

    public Offer createOfferWithStoreAndProductCategory(Store store, AbstractProduct product) {
        Offer offer = new Offer();
        offer.setStore(store);
        offer.setProduct(product);
        return offer;
    }

    public Optional<Offer> findOfferById(long id) {
        return offerStorage.findById(id);
    }

    public List<Offer> findOffersByStore(Store store) {
        return offerStorage.getListOfEntity().stream().filter(offer -> offer.getStore().equals(store)).toList();
    }

    public Offer deleteOffer(Offer offer) {
        offerStorage.delete(offer);
        return offer;
    }

    public List<OfferWithCountDto> addOfferToCart(long offerId, Customer customer) {

        List<OfferWithCountDto> cart = customer.getCart();
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
            OfferWithCountDto offerComposite = new OfferWithCountDto(offer, 1);
            cart.add(offerComposite);
        }
        return cart;
    }

    public BigDecimal findTotalPriceOffersInCart(List<OfferWithCountDto> cart) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (int i = 0; i < cart.size(); i++) {
            BigDecimal offerCompositePrice = cart.get(i).getOffer().getPrice().multiply(new BigDecimal(cart.get(i).getCount()));
            totalPrice = totalPrice.add(offerCompositePrice);
        }
        return totalPrice;
    }

    public BigDecimal findTotalPriceOfOfferToBuy(OfferWithCountDto offerWithCountInCartDto) {
        BigDecimal totalPrice = new BigDecimal(0);
        totalPrice = offerWithCountInCartDto.getOffer().getPrice().multiply(new BigDecimal(offerWithCountInCartDto.getCount()));
        return totalPrice;
    }

    public List<OfferWithCountDto> deleteOfferFromCart(long offerId, Customer customer) {
        List<OfferWithCountDto> cart = customer.getCart();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getOffer().getId() == offerId) {
                cart.remove(i);
                break;
            }
        }
        return cart;
    }

    public List<OfferWithCountDto> minusOfferCount(long offerId, Customer customer) {
        List<OfferWithCountDto> cart = customer.getCart();
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

    public List<OfferWithCountDto> plusOfferCount(long offerId, Customer customer) {
        List<OfferWithCountDto> cart = customer.getCart();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getOffer().getId() == offerId) {
                int count = cart.get(i).getCount();
                cart.get(i).setCount(count + 1);
                break;
            }
        }
        return cart;
    }

    public OfferWithCountDto findOfferWithCountInCart(long offerId, Customer customer) {
        OfferWithCountDto offerWithCountInCart = new OfferWithCountDto();
        List<OfferWithCountDto> cart = customer.getCart();
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getOffer().getId() == offerId) {
                offerWithCountInCart = cart.get(i);
                break;
            }
        }
        return offerWithCountInCart;
    }

    public Store addPurchaseAlert(PurchaseAlert purchaseAlert) {
        Store store = purchaseAlert.getOffer().getStore();
        store.getAlerts().add(purchaseAlert);
        return store;
    }
    public Customer addCompletedOrderToList(Customer customer, OfferWithCountDto offerWithCountDto) {
        customer.getCompletedOrder().add(offerWithCountDto);
        return customer;
    }
}
