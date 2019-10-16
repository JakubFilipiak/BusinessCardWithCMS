package jakubfilipiak.BusinessCardWithCMS.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by Jakub Filipiak on 20.09.2019
 */
@Getter
@Builder
@AllArgsConstructor
@ToString
public class AboutDto {

    private String id;
    private String description;
}
