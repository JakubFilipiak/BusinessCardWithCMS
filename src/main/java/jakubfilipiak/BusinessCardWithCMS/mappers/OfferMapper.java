package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.OfferEntity;
import jakubfilipiak.BusinessCardWithCMS.models.OfferImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferImageDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
        return OfferDto.builder()
                .id(retrieveId(entity))
                .title(retrieveTitle(entity))
                .description(retrieveDescription(entity))
//                .image(retrieveImage(entity))
                .build();
    }

    @Override
    public OfferEntity toEntity(OfferDto dto) {
        return new OfferEntity.OfferEntityBuilder()
                .id(retrieveId(dto))
                .title(retrieveTitle(dto))
                .description(retrieveDescription(dto))
//                .image(retrieveImage(dto))
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
        if (title == null || title.isEmpty()) return  "";
        else return title;
    }

    private String retrieveTitle(OfferDto dto) {
        String title = dto.getTitle();
        if (title == null || title.isEmpty()) return  null;
        else return title;
    }

    private String retrieveDescription(OfferEntity entity) {
        String description = entity.getDescription();
        if (description == null || description.isEmpty()) return  "";
        else return description;
    }

    private String retrieveDescription(OfferDto dto) {
        String description = dto.getDescription();
        if (description == null || description.isEmpty()) return null;
        else return description;
    }

    private OfferImageDto retrieveImage(OfferEntity entity) {
        OfferImageEntity image = entity.getImage();
        if (image == null) return null;
        else return imageMapper.toDto(image);
    }

    private OfferImageEntity retrieveImage(OfferDto dto) {
        OfferImageDto image = dto.getImage();
        if (image == null) return null;
        else return imageMapper.toEntity(image);
    }
}
