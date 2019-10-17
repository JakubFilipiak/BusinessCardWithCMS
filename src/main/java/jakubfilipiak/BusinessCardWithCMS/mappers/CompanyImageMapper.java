package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.CompanyImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.CompanyImageDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class CompanyImageMapper implements BaseMapper<CompanyImageEntity, CompanyImageDto> {

    @Override
    public CompanyImageDto toDto(CompanyImageEntity entity) {
        return CompanyImageDto.builder()
                .id(retrieveId(entity))
                .name(retrieveName(entity))
                .alt(retrieveAlt(entity))
                .build();
    }

    @Override
    public CompanyImageEntity toEntity(CompanyImageDto dto) {
        return new CompanyImageEntity.CompanyImageEntityBuilder()
                .id(retrieveId(dto))
                .name(retrieveName(dto))
                .alt(retrieveAlt(dto))
                .build();
    }

    private String retrieveId(CompanyImageEntity entity) {
        return entity.getId().toString();
    }

    private UUID retrieveId(CompanyImageDto dto) {
        String id = dto.getId();
        if (id == null || id.isEmpty()) return UUID.randomUUID();
        else return UUID.fromString(id);
    }

    private String retrieveName(CompanyImageEntity entity) {
        String name = entity.getName();
        if (name == null || name.isEmpty()) return "";
        else return name;
    }

    private String retrieveName(CompanyImageDto dto) {
        String name = dto.getName();
        if (name == null || name.isEmpty()) return "";
        else return name;
    }

    private String retrieveAlt(CompanyImageEntity entity) {
        String alt = entity.getAlt();
        if (alt == null || alt.isEmpty()) return "";
        else return alt;
    }

    private String retrieveAlt(CompanyImageDto dto) {
        String alt = dto.getAlt();
        if (alt == null || alt.isEmpty()) return "";
        else return alt;
    }
}
