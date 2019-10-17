package jakubfilipiak.BusinessCardWithCMS.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by Jakub Filipiak on 20.09.2019
 */
@Getter
@Builder
@AllArgsConstructor
@ToString
@ApiModel
public class AboutDto {

    @ApiModelProperty
    private String id;
    @ApiModelProperty
    private String description;
}
