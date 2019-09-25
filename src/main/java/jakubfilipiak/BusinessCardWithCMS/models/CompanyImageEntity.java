package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Entity
@Table(name = "company_images")
public class CompanyImageEntity extends BaseEntity {

    private String name;
    private String alt;

    @OneToOne
    @MapsId
    private FileEntity file;
}
