package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.FileEntity;
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
        return OfferImageDto.builder()
                .id(retrieveId(entity))
                .path(retrievePath(entity))
                .alt(retrieveAlt(entity))
                .build();
    }

    @Override
    public OfferImageEntity toEntity(OfferImageDto dto) {
        return null;
    }

    private String retrieveId(OfferImageEntity entity) {
        return entity.getId().toString();
    }

    private String retrievePath(OfferImageEntity entity) {
        FileEntity file = entity.getFile();
        if (file == null) return "";
        else {
            String path = file.getPath();
            if (path == null || path.isEmpty()) return "";
            else return path;
        }
    }

    private String retrieveAlt(OfferImageEntity entity) {
        String alt = entity.getAlt();
        if (alt == null || alt.isEmpty()) return "";
        else return alt;
    }
}
