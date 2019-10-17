package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.AboutEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.AboutDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class AboutMapper implements BaseMapper<AboutEntity, AboutDto> {

    private static final String VALUE_FOR_NULL_OR_EMPTY_STRING = null;

    @Override
    public AboutDto toDto(AboutEntity entity) {
        return AboutDto.builder()
                .id(retrieveId(entity))
                .description(retrieveDescription(entity))
                .build();
    }

    @Override
    public AboutEntity toEntity(AboutDto dto) {
        return new AboutEntity.AboutEntityBuilder()
                .id(retrieveId(dto))
                .description(retrieveDescription(dto))
                .build();
    }

    private String retrieveId(AboutEntity entity) {
        return entity.getId().toString();
    }

    private UUID retrieveId(AboutDto dto) {
        String id = dto.getId();
        if (id == null || id.isEmpty()) return UUID.randomUUID();
        else return UUID.fromString(id);
    }

    private String retrieveDescription(AboutEntity entity) {
        String description = entity.getDescription();
        if (description == null || description.isEmpty()) return VALUE_FOR_NULL_OR_EMPTY_STRING;
        else return description;
    }

    private String retrieveDescription(AboutDto dto) {
        String description = dto.getDescription();
        if (description == null || description.isEmpty()) return VALUE_FOR_NULL_OR_EMPTY_STRING;
        else return description;
    }
}
