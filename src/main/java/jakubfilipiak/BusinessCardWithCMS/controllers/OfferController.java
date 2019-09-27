package jakubfilipiak.BusinessCardWithCMS.controllers;

import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import jakubfilipiak.BusinessCardWithCMS.services.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@RestController
@RequestMapping("/api/offer")
public class OfferController {

    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public ResponseEntity<?> getOffers() {
        List<OfferDto> offers = offerService.getOffersDto();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }
}
