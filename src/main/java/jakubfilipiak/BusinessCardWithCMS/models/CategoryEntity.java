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
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<CategoryImageEntity> images;
}
