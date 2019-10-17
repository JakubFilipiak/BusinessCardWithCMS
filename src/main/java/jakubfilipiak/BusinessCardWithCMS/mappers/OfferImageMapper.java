package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.OfferImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferImageDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class OfferImageMapper implements BaseMapper<OfferImageEntity, OfferImageDto> {

    private static final String VALUE_FOR_NULL_OR_EMPTY_STRING = null;

    @Override
    public OfferImageDto toDto(OfferImageEntity entity) {
        return OfferImageDto.builder()
                .id(retrieveId(entity))
                .alt(retrieveAlt(entity))
                .build();
    }

    @Override
    public OfferImageEntity toEntity(OfferImageDto dto) {
        return new OfferImageEntity.OfferImageEntityBuilder()
                .id(retrieveId(dto))
                .alt(retrieveAlt(dto))
                .build();
    }

    private String retrieveId(OfferImageEntity entity) {
        return entity.getId().toString();
    }

    private UUID retrieveId(OfferImageDto dto) {
        String id = dto.getId();
        if (id == null || id.isEmpty()) return UUID.randomUUID();
        else return UUID.fromString(id);
    }

    private String retrieveAlt(OfferImageEntity entity) {
        String alt = entity.getAlt();
        if (alt == null || alt.isEmpty()) return VALUE_FOR_NULL_OR_EMPTY_STRING;
        else return alt;
    }

    private String retrieveAlt(OfferImageDto dto) {
        String alt = dto.getAlt();
        if (alt == null || alt.isEmpty()) return VALUE_FOR_NULL_OR_EMPTY_STRING;
        else return alt;
    }
}
