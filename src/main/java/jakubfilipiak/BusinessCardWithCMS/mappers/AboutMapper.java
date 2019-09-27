package jakubfilipiak.BusinessCardWithCMS.mappers;

import jakubfilipiak.BusinessCardWithCMS.mappers.helpers.BaseMapper;
import jakubfilipiak.BusinessCardWithCMS.models.AboutEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.AboutDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Component
public class AboutMapper implements BaseMapper<AboutEntity, AboutDto> {

    @Override
    public AboutDto toDto(AboutEntity entity) {
        return null;
    }

    @Override
    public AboutEntity toEntity(AboutDto dto) {
        return null;
    }
}
