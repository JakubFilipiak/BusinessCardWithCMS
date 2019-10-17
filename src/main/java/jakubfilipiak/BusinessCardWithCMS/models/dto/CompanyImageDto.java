package jakubfilipiak.BusinessCardWithCMS.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * Created by Jakub Filipiak on 20.09.2019
 */
@Getter
@Builder
@AllArgsConstructor
@ToString
@ApiModel
public class CompanyImageDto {

    @ApiModelProperty
    private String id;
    @Setter
    @ApiModelProperty
    private String name;
    @Setter
    @ApiModelProperty
    private String path;
    @ApiModelProperty
    private String alt;
}
