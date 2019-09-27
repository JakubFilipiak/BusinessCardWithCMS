package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.OfferEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class OfferMapper implements BaseMapper<OfferEntity, OfferDto> {

    private OfferImageMapper imageMapper;

    public OfferMapper(OfferImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public OfferDto toDto(OfferEntity entity) {
        return null;
    }

    @Override
    public OfferEntity toEntity(OfferDto dto) {
        return null;
    }
}
