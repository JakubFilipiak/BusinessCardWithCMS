package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Entity
@Table(name = "abouts")
public class AboutEntity extends BaseEntity {

    private String description;

    private AboutEntity(BaseEntity.Builder<?> builder) {
        super(builder);
    }
}
