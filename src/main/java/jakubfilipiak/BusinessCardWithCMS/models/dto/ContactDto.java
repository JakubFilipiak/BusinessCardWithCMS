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
public class ContactDto {

    @ApiModelProperty
    private String id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String surname;
    @ApiModelProperty
    private String email;
    @ApiModelProperty
    private String phone;
    @ApiModelProperty
    private String address;
}
