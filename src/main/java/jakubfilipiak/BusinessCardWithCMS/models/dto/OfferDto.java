package jakubfilipiak.BusinessCardWithCMS.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class OfferDto {

    @ApiModelProperty
    private String id;
    @ApiModelProperty
    private String title;
    @ApiModelProperty
    private String description;
    @Setter
    @ApiModelProperty
    private OfferImageDto image;
}
