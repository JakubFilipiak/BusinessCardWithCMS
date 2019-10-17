package jakubfilipiak.BusinessCardWithCMS.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Jakub Filipiak on 20.09.2019
 */
@ApiModel
public class CategoryImageDto {

    @ApiModelProperty
    private String id;
    @ApiModelProperty
    private String path;
    @ApiModelProperty
    private String alt;
    @ApiModelProperty
    private boolean isMainImageFlag;
}
