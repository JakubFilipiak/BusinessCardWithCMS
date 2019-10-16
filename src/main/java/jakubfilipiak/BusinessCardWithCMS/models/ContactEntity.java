package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Getter
@Entity
@Table(name = "contacts")
public class ContactEntity extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;

    private ContactEntity() {}; // for Hibernate

    private ContactEntity(ContactEntityBuilder builder) {
        super(builder);
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public static class ContactEntityBuilder extends BaseEntity.Builder<ContactEntityBuilder> {

        private String name;
        private String surname;
        private String email;
        private String phone;
        private String address;

        public ContactEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ContactEntityBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public ContactEntityBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ContactEntityBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public ContactEntityBuilder address(String address) {
            this.address = address;
            return this;
        }

        @Override
        public ContactEntity build() {
            return new ContactEntity(this);
        }

        @Override
        protected ContactEntityBuilder self() {
            return this;
        }
    }
}
