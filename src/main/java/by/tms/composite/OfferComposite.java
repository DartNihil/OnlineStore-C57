package by.tms.composite;

import by.tms.entity.Offer;

public class OfferComposite {
    private Offer offer;
    private int count;

    public OfferComposite(Offer offer, int count) {
        this.offer = offer;
        this.count = count;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
