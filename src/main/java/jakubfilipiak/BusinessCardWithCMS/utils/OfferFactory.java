package jakubfilipiak.BusinessCardWithCMS.utils;

import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferImageDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 07.10.2019
 */
@Component
public class OfferFactory {

    public OfferDto dtoFromSentData(String title, String description, String offerImageAlt) {
        if (title == null || description == null) return null;
        return OfferDto.builder()
                .title(title)
                .description(description)
                .image(new OfferImageDto(offerImageAlt))
                .build();
    }
}
