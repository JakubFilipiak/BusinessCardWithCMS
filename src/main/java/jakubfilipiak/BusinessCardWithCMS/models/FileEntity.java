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
@Table(name = "files")
public class FileEntity extends BaseEntity {

    private String name;
    private String originalName;

    private FileEntity() {} // for Hibernate

    private FileEntity(FileEntityBuilder builder) {
        super(builder);
        this.name = builder.name;
        this.originalName = builder.originalName;
    }

    public static class FileEntityBuilder extends BaseEntity.Builder<FileEntityBuilder> {

        private String name;
        private String originalName;

        public FileEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FileEntityBuilder originalName(String originalName) {
            this.originalName = originalName;
            return this;
        }

        @Override
        public FileEntity build() {
            return new FileEntity(this);
        }

        @Override
        protected FileEntityBuilder self() {
            return this;
        }
    }
}
