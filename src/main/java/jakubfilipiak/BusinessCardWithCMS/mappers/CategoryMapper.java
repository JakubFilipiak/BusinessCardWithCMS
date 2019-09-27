package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.CategoryEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.CategoryDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class CategoryMapper implements BaseMapper<CategoryEntity, CategoryDto> {

    private CategoryImageMapper imageMapper;

    public CategoryMapper(CategoryImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public CategoryDto toDto(CategoryEntity entity) {
        return null;
    }

    @Override
    public CategoryEntity toEntity(CategoryDto dto) {
        return null;
    }
}
