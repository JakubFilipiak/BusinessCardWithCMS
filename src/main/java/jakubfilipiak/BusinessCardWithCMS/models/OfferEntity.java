package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String title;
    private String description;

    @OneToMany(mappedBy = "offer")
    private List<OfferImageEntity> images;
}
