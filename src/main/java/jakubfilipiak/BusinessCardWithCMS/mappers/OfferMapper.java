package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.OfferEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class OfferMapper implements BaseMapper<OfferEntity, OfferDto> {

    private static final String VALUE_FOR_NULL_OR_EMPTY_STRING = null;

    @Override
    public OfferDto toDto(OfferEntity entity) {
        return OfferDto.builder()
                .id(retrieveId(entity))
                .title(retrieveTitle(entity))
                .description(retrieveDescription(entity))
                .build();
    }

    @Override
    public OfferEntity toEntity(OfferDto dto) {
        return new OfferEntity.OfferEntityBuilder()
                .id(retrieveId(dto))
                .title(retrieveTitle(dto))
                .description(retrieveDescription(dto))
                .build();
    }

    private String retrieveId(OfferEntity entity) {
        return entity.getId().toString();
    }

    private UUID retrieveId(OfferDto dto) {
        String id = dto.getId();
        if (id == null || id.isEmpty()) return UUID.randomUUID();
        else return UUID.fromString(id);
    }

    private String retrieveTitle(OfferEntity entity) {
        String title = entity.getTitle();
        if (title == null || title.isEmpty()) return  VALUE_FOR_NULL_OR_EMPTY_STRING;
        else return title;
    }

    private String retrieveTitle(OfferDto dto) {
        String title = dto.getTitle();
        if (title == null || title.isEmpty()) return  VALUE_FOR_NULL_OR_EMPTY_STRING;
        else return title;
    }

    private String retrieveDescription(OfferEntity entity) {
        String description = entity.getDescription();
        if (description == null || description.isEmpty()) return  VALUE_FOR_NULL_OR_EMPTY_STRING;
        else return description;
    }

    private String retrieveDescription(OfferDto dto) {
        String description = dto.getDescription();
        if (description == null || description.isEmpty()) return VALUE_FOR_NULL_OR_EMPTY_STRING;
        else return description;
    }
}
