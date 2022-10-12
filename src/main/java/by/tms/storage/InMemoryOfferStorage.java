package by.tms.storage;

import by.tms.entity.Offer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryOfferStorage implements Storage<Offer, Long> {

    private final List<Offer> offerList = new ArrayList<>();

    private final AtomicLong offerIdGenerator = new AtomicLong(0);
    @Override
    public Offer save(Offer offer) {
        offer.setId(offerIdGenerator.incrementAndGet());
        offerList.add(offer);
        return offer;
    }
    public Offer delete(Offer offer){
        offerList.remove(offer);
        return offer;
    }

    @Override
    public Optional<Offer> findById(Long id) {
        for (Offer offer : offerList) {
            if (offer.getId() == id) {
                return Optional.of(offer);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Offer> getListOfEntity() {
        return offerList;
    }

    @Override
    public Optional<Offer> findEntity(String parameter) {
        return Optional.empty();
    }
}
