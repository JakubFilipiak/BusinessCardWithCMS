package jakubfilipiak.BusinessCardWithCMS.models;

import jakubfilipiak.BusinessCardWithCMS.models.helpers.BaseEntity;

import java.util.List;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
public class OfferEntity extends BaseEntity {

    private String title;
    private String description;
    private List<OfferImageEntity> images;
}
