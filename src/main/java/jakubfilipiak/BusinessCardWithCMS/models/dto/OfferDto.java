package jakubfilipiak.BusinessCardWithCMS.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Jakub Filipiak on 20.09.2019
 */
@Getter
@Builder
@ToString
public class OfferDto {

    private String id;
    private String title;
    private String description;
    @Setter
    private OfferImageDto image;
}
