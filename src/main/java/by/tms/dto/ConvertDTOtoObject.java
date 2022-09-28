package by.tms.dto;

import by.tms.entity.Offer;
import org.springframework.stereotype.Component;

@Component
public class ConvertDTOtoObject {
    public Offer convertOfferDTOtoOffer(OfferDTO offerDTO, Offer offer) {
        offer.setDescription(offerDTO.getDescription());
        offer.setPrice(offerDTO.getPrice());
        return offer;
    }
}
