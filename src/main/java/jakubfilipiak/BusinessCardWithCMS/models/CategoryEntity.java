package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

import java.util.List;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
public class CategoryEntity extends BaseEntity {

    private String name;
    private String description;
    private List<CategoryImageEntity> images;
}
