package jakubfilipiak.BusinessCardWithCMS.services;

import jakubfilipiak.BusinessCardWithCMS.mappers.OfferMapper;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import jakubfilipiak.BusinessCardWithCMS.repositories.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Service
public class OfferService {

    private OfferRepository offerRepository;
    private OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
    }

    public List<OfferDto> getOffersDto() {
        return offerRepository.findAll()
                .stream()
                .map(offerMapper::toDto)
                .collect(Collectors.toList());
    }
}
