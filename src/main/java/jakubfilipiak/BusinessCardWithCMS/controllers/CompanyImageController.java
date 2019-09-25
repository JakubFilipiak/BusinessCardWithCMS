package jakubfilipiak.BusinessCardWithCMS.controllers;

import jakubfilipiak.BusinessCardWithCMS.models.dto.CompanyImageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@RestController
@RequestMapping("/api/company-image")
public class CompanyImageController {

    @GetMapping()
    public ResponseEntity<CompanyImageDto> getCompanyImageByName(@RequestParam String name) {
        return null;
    }
}
