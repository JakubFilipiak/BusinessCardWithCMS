package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Getter
@ToString
@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String title;
    private String description;

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_image_id")
    private OfferImageEntity image;

    private OfferEntity() {} // for Hibernate

    private OfferEntity(OfferEntityBuilder builder) {
        super(builder);
        this.title = builder.title;
        this.description = builder.description;
        this.image = builder.image;
    }

    public static class OfferEntityBuilder extends BaseEntity.Builder<OfferEntityBuilder> {

        private String title;
        private String description;
        private OfferImageEntity image;

        public OfferEntityBuilder title(String title) {
            this.title = title;
            return this;
        }

        public OfferEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public OfferEntityBuilder image(OfferImageEntity image) {
            this.image = image;
            return this;
        }

        @Override
        public OfferEntity build() {
            return new OfferEntity(this);
        }

        @Override
        protected OfferEntityBuilder self() {
            return this;
        }
    }
}
