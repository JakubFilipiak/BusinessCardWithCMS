package jakubfilipiak.BusinessCardWithCMS.models.dto;

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
public class ContactDto {

    private String id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
}
