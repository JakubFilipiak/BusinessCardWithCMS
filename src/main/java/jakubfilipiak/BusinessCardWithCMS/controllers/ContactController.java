package jakubfilipiak.BusinessCardWithCMS.controllers;

import jakubfilipiak.BusinessCardWithCMS.models.ContactEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.ContactDto;
import jakubfilipiak.BusinessCardWithCMS.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public ResponseEntity<?> getContact() {
        List<ContactDto> contacts = contactService.getContactsDto();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateContact(@RequestParam String id,
                                           @RequestParam String name,
                                           @RequestParam String surname,
                                           @RequestParam String email,
                                           @RequestParam String phone,
                                           @RequestParam String address) {
        Optional<ContactDto> contactDtoOpt = contactService.mapParamsToDto(id, name, surname, email, phone, address);
        if (contactDtoOpt.isPresent()) {
            System.out.println(contactDtoOpt.get());
            ContactEntity contactEntity = contactService.updateContact(contactDtoOpt.get());
            ContactDto contactDto = contactService.mapEntityToDto(contactEntity);
            return new ResponseEntity<>(contactDto, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
