package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.CompanyImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.CompanyImageDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class CompanyImageMapper implements BaseMapper<CompanyImageEntity, CompanyImageDto> {

    @Override
    public CompanyImageDto toDto(CompanyImageEntity entity) {
        return null;
    }

    @Override
    public CompanyImageEntity toEntity(CompanyImageDto dto) {
        return null;
    }
}
