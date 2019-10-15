package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Getter
@ToString
@Entity
@Table(name = "offer_images")
public class OfferImageEntity extends BaseEntity {

    private String alt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileEntity file;

    private OfferImageEntity() {} // for Hibernate

    private OfferImageEntity(BaseEntity.Builder<?> builder) {
        super(builder);
        OfferImageEntityBuilder offerImageEntityBuilder = (OfferImageEntityBuilder) builder;
        this.alt = offerImageEntityBuilder.alt;
        this.file = offerImageEntityBuilder.file;
    }

    public static class OfferImageEntityBuilder extends BaseEntity.Builder<OfferImageEntityBuilder> {

        private String alt;
        private FileEntity file;

        public OfferImageEntityBuilder alt(String alt) {
            this.alt = alt;
            return this;
        }

        public OfferImageEntityBuilder file(FileEntity file) {
            this.file = file;
            return this;
        }

        @Override
        public OfferImageEntity build() {
            return new OfferImageEntity(this);
        }

        @Override
        protected OfferImageEntityBuilder self() {
            return this;
        }
    }
}
