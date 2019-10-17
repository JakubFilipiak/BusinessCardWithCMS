package jakubfilipiak.BusinessCardWithCMS.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Jakub Filipiak on 20.09.2019
 */
@ApiModel
public class CategoryDto {

    @ApiModelProperty
    private String id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String description;
    @ApiModelProperty
    private List<CategoryImageDto> images;
}
