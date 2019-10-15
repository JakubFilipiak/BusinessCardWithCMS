package jakubfilipiak.BusinessCardWithCMS.controllers;

import jakubfilipiak.BusinessCardWithCMS.models.OfferEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import jakubfilipiak.BusinessCardWithCMS.services.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public ResponseEntity<?> addOffer(@RequestParam String title,
                                      @RequestParam String description,
                                      @RequestParam(required = false) String offerImageAlt,
                                      @RequestParam(required = false) MultipartFile file) {
        Optional<OfferDto> offerDtoOpt = offerService.mapParamsToDto(title, description, offerImageAlt);
        if (offerDtoOpt.isPresent()) {
            System.out.println(offerDtoOpt.get());
            try {
                OfferEntity offerEntity = offerService.addOffer(offerDtoOpt.get(), file);
                OfferDto offerDto = offerService.mapEntityToDto(offerEntity);
                return new ResponseEntity<>(offerDto, HttpStatus.CREATED);
            } catch (IOException|UnknownError e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
