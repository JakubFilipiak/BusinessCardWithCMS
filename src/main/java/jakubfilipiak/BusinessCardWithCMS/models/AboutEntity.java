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
@Table(name = "abouts")
public class AboutEntity extends BaseEntity {

    private String description;

    private AboutEntity() {}; // for Hibernate

    private AboutEntity(AboutEntityBuilder builder) {
        super(builder);
        this.description = builder.description;
    }

    public static class AboutEntityBuilder extends BaseEntity.Builder<AboutEntityBuilder> {

        private String description;

        public AboutEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public AboutEntity build() {
            return new AboutEntity(this);
        }

        @Override
        protected AboutEntityBuilder self() {
            return this;
        }
    }
}
