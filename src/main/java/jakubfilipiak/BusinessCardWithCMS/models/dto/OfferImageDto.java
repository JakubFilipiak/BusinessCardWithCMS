package jakubfilipiak.BusinessCardWithCMS.models.dto;

import lombok.*;

/**
 * Created by Jakub Filipiak on 20.09.2019
 */
@Getter
@Builder
@AllArgsConstructor
@ToString
public class OfferImageDto {

    private String id;
    @Setter
    private String path;
    private String alt;

    public OfferImageDto(String alt) {
        this.alt = alt;
    }
}
