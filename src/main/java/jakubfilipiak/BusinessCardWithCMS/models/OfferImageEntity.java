package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Getter
@Entity
@Table(name = "offer_images")
public class OfferImageEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = false)
    private OfferEntity offer;

    private String alt;

    @OneToOne
    @MapsId
    private FileEntity file;
}
