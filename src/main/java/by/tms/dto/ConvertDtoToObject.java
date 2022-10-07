package by.tms.dto;

import by.tms.entity.Offer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConvertDtoToObject {
    public Offer convertOfferDTOtoOffer(OfferDto offerDTO, Offer offer) {
        offer.setDescription(offerDTO.getDescription());
        offer.setPrice(new BigDecimal(offerDTO.getPrice()));
        return offer;
    }
}
