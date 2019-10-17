package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Getter
@Entity
@Table(name = "company_images")
public class CompanyImageEntity extends BaseEntity {

    @Column(unique = true, updatable = false)
    private String name;
    private String alt;

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileEntity file;

    private CompanyImageEntity() {}; // for Hibernate

    private CompanyImageEntity(CompanyImageEntityBuilder builder) {
        super(builder);
        this.name = builder.name;
        this.alt = builder.alt;
        this.file = builder.file;
    }

    public static class CompanyImageEntityBuilder extends BaseEntity.Builder<CompanyImageEntityBuilder> {

        private String name;
        private String alt;
        private FileEntity file;

        public CompanyImageEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CompanyImageEntityBuilder alt(String alt) {
            this.alt = alt;
            return this;
        }

        public CompanyImageEntityBuilder file(FileEntity file) {
            this.file = file;
            return this;
        }

        @Override
        public CompanyImageEntity build() {
            return new CompanyImageEntity(this);
        }

        @Override
        protected CompanyImageEntityBuilder self() {
            return this;
        }
    }
}
