package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.OfferEntity;
import jakubfilipiak.BusinessCardWithCMS.models.OfferImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferImageDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                .images(retrieveImages(entity))
                .build();
    }

    @Override
    public OfferEntity toEntity(OfferDto dto) {
        return null;
    }

    private String retrieveId(OfferEntity entity) {
        return entity.getId().toString();
    }

    private String retrieveTitle(OfferEntity entity) {
        String title = entity.getTitle();
        if (title == null || title.isEmpty()) return  "";
        else return title;
    }

    private String retrieveDescription(OfferEntity entity) {
        String description = entity.getDescription();
        if (description == null || description.isEmpty()) return  "";
        else return description;
    }

    private List<OfferImageDto> retrieveImages(OfferEntity entity) {
        List<OfferImageEntity> images = entity.getImages();
        if (images == null || images.isEmpty()) return new ArrayList<>();
        else return images.stream()
                .map(imageMapper::toDto)
                .collect(Collectors.toList());
    }
}
