package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.CategoryImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.CategoryImageDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class CategoryImageMapper implements BaseMapper<CategoryImageEntity, CategoryImageDto> {

    @Override
    public CategoryImageDto toDto(CategoryImageEntity entity) {
        return null;
    }

    @Override
    public CategoryImageEntity toEntity(CategoryImageDto dto) {
        return null;
    }
}
