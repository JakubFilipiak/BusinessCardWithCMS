package jakubfilipiak.BusinessCardWithCMS.utils;

import jakubfilipiak.BusinessCardWithCMS.models.dto.AboutDto;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 16.10.2019
 */
@Component
public class AboutFactory {

    public AboutDto dtoFromSentData(String id, String description) {
        if (id == null || description == null) return null;
        return AboutDto.builder()
                .id(id)
                .description(description)
                .build();
    }
}
