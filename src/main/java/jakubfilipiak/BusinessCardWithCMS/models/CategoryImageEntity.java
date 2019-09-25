package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

import javax.persistence.*;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Entity
@Table(name = "category_images")
public class CategoryImageEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    private String alt;
    private boolean isMainImageFlag;

    @OneToOne
    @MapsId
    private FileEntity file;
}
