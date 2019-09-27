package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.ContactEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.ContactDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class ContactMapper implements BaseMapper<ContactEntity, ContactDto> {

    @Override
    public ContactDto toDto(ContactEntity entity) {
        return null;
    }

    @Override
    public ContactEntity toEntity(ContactDto dto) {
        return null;
    }
}
