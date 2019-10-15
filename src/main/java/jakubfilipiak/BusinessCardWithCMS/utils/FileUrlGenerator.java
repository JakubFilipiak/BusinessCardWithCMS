package jakubfilipiak.BusinessCardWithCMS.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jakub Filipiak on 15.10.2019
 */
@Component
public class FileUrlGenerator {

    @Value("${custom.domain.name}")
    private String domainName;

    @Value("${custom.file.endpoint.name}")
    private String fileEndpointName;

    public String generate(String fileName) {
        return domainName + fileEndpointName + fileName;
    }
}
