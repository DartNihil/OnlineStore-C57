package by.tms.dto;

import by.tms.entity.Offer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConvertDTOToObject {
    public Offer convertOfferDTOtoOffer(OfferDTO offerDTO, Offer offer) {
        offer.setDescription(offerDTO.getDescription());
        offer.setPrice(new BigDecimal(offerDTO.getPrice()));
        return offer;
    }
}
