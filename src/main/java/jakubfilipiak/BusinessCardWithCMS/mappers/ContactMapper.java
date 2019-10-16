package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.ContactEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.ContactDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class ContactMapper implements BaseMapper<ContactEntity, ContactDto> {

    @Override
    public ContactDto toDto(ContactEntity entity) {
        return ContactDto.builder()
                .id(retrieveId(entity))
                .name(retrieveName(entity))
                .surname(retrieveSurname(entity))
                .email(retrieveEmail(entity))
                .phone(retrievePhone(entity))
                .address(retrieveAddress(entity))
                .build();
    }

    @Override
    public ContactEntity toEntity(ContactDto dto) {
        return new ContactEntity.ContactEntityBuilder()
                .id(retrieveId(dto))
                .name(retrieveName(dto))
                .surname(retrieveSurname(dto))
                .email(retrieveEmail(dto))
                .phone(retrievePhone(dto))
                .address(retrieveAddress(dto))
                .build();
    }

    private String retrieveId(ContactEntity entity) {
        return entity.getId().toString();
    }

    private UUID retrieveId(ContactDto dto) {
        String id = dto.getId();
        if (id == null || id.isEmpty()) return UUID.randomUUID();
        else return UUID.fromString(id);
    }

    private String retrieveName(ContactEntity entity) {
        String name = entity.getName();
        if (name == null || name.isEmpty()) return "";
        else return name;
    }

    private String retrieveName(ContactDto dto) {
        String name = dto.getName();
        if (name == null || name.isEmpty()) return "";
        else return name;
    }

    private String retrieveSurname(ContactEntity entity) {
        String surname = entity.getSurname();
        if (surname == null || surname.isEmpty()) return "";
        else return surname;
    }

    private String retrieveSurname(ContactDto dto) {
        String surname = dto.getSurname();
        if (surname == null || surname.isEmpty()) return "";
        else return surname;
    }

    private String retrieveEmail(ContactEntity entity) {
        String email = entity.getEmail();
        if (email == null || email.isEmpty()) return "";
        else return email;
    }

    private String retrieveEmail(ContactDto dto) {
        String email = dto.getEmail();
        if (email == null || email.isEmpty()) return "";
        else return email;
    }

    private String retrievePhone(ContactEntity entity) {
        String phone = entity.getPhone();
        if (phone == null || phone.isEmpty()) return "";
        else return phone;
    }

    private String retrievePhone(ContactDto dto) {
        String phone = dto.getPhone();
        if (phone == null || phone.isEmpty()) return "";
        else return phone;
    }

    private String retrieveAddress(ContactEntity entity) {
        String address = entity.getAddress();
        if (address == null || address.isEmpty()) return "";
        else return address;
    }

    private String retrieveAddress(ContactDto dto) {
        String address = dto.getAddress();
        if (address == null || address.isEmpty()) return "";
        else return address;
    }
}
