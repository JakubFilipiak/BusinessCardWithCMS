package jakubfilipiak.BusinessCardWithCMS.services;

import jakubfilipiak.BusinessCardWithCMS.mappers.ContactMapper;
import jakubfilipiak.BusinessCardWithCMS.models.ContactEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.ContactDto;
import jakubfilipiak.BusinessCardWithCMS.repositories.ContactRepository;
import jakubfilipiak.BusinessCardWithCMS.utils.ContactFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Service
public class ContactService {

    private ContactRepository contactRepository;
    private ContactMapper contactMapper;
    private ContactFactory contactFactory;

    public ContactService(ContactRepository contactRepository,
                          ContactMapper contactMapper,
                          ContactFactory contactFactory) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
        this.contactFactory = contactFactory;
    }

    public List<ContactDto> getContactsDto() {
        List<ContactEntity> entities = contactRepository.findAll();
        if (entities.isEmpty()) {
            ContactEntity addedEntity = addEmptyContact();
            entities.add(addedEntity);
            return entities.stream()
                    .map(this::mapEntityToDto)
                    .collect(Collectors.toList());
        }
        if (entities.size() == 1) {
            return entities.stream()
                    .map(this::mapEntityToDto)
                    .collect(Collectors.toList());
        }
        // TODO: what when more than one 'contact'
        return null;
    }

    private ContactEntity addEmptyContact() {
        return contactRepository.save(new ContactEntity.ContactEntityBuilder().build());
    }

    public ContactDto mapEntityToDto(ContactEntity entity) {
        return contactMapper.toDto(entity);
    }

    public Optional<ContactDto> mapParamsToDto(String id,
                                               String name,
                                               String surname,
                                               String email,
                                               String phone,
                                               String address) {
        return Optional.ofNullable(contactFactory.dtoFromSentData(
                id, name, surname, email, phone, address));
    }

    public ContactEntity updateContact(ContactDto contactDto) {
        Optional<ContactEntity> contactEntityOpt = contactRepository.findById(UUID.fromString(contactDto.getId()));
        if (contactEntityOpt.isPresent()) {
            ContactEntity contactEntityToSave = mapDtoToEntity(contactDto);
            return contactRepository.save(contactEntityToSave);
        }
        return null;
    }

    private ContactEntity mapDtoToEntity(ContactDto dto) {
        return contactMapper.toEntity(dto);
    }
}
