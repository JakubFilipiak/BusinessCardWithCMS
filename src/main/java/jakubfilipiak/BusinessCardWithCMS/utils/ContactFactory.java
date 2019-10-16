package jakubfilipiak.BusinessCardWithCMS.utils;

import jakubfilipiak.BusinessCardWithCMS.models.dto.ContactDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 16.10.2019
 */
@Component
public class ContactFactory {

    public ContactDto dtoFromSentData(String id,
                                      String name,
                                      String surname,
                                      String email,
                                      String phone,
                                      String address) {
        if (id == null
                || name == null
                || surname == null
                || email == null
                || phone == null
                || address == null)
        return null;
        return ContactDto.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .email(email)
                .phone(phone)
                .address(address)
                .build();
    }
}
