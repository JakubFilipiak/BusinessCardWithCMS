package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.OfferImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferImageDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class OfferImageMapper implements BaseMapper<OfferImageEntity, OfferImageDto> {

    @Override
    public OfferImageDto toDto(OfferImageEntity entity) {
        return null;
    }

    @Override
    public OfferImageEntity toEntity(OfferImageDto dto) {
        return null;
    }
}
