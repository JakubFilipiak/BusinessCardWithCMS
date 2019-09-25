package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Entity
@Table(name = "contacts")
public class ContactEntity extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
}
