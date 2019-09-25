package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Entity
@Table(name = "files")
public class FileEntity extends BaseEntity {

    private String name;
    private String originalName;
    private String path;
    private String openInBrowserUrl;
}