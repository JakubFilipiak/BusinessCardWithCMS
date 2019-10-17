package jakubfilipiak.BusinessCardWithCMS.utils;

import jakubfilipiak.BusinessCardWithCMS.models.dto.CompanyImageDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 17.10.2019
 */
@Component
public class CompanyImageFactory {

    public CompanyImageDto dtoFromSentData(String id, String name, String alt) {
        if (id == null || name == null || alt == null) return null;
        return CompanyImageDto.builder()
                .id(id)
                .name(name)
                .alt(alt)
                .build();
    }
}
