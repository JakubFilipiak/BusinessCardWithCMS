package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
public class CategoryImageEntity extends BaseEntity {

    private String alt;
    private boolean isMainImageFlag;
    private FileEntity file;
}
