package by.tms.service.mapper;

import by.tms.dto.OfferDto;
import by.tms.entity.Offer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class OfferMapper {
    public Offer convertOfferDTOtoOffer(OfferDto offerDTO, Offer offer) {
        offer.setDescription(offerDTO.getDescription());
        offer.setPrice(new BigDecimal(offerDTO.getPrice()));
        return offer;
    }

}
