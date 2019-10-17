package jakubfilipiak.BusinessCardWithCMS.controllers;

import jakubfilipiak.BusinessCardWithCMS.models.CompanyImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.CompanyImageDto;
import jakubfilipiak.BusinessCardWithCMS.services.CompanyImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@RestController
@RequestMapping("/api/company-image")
public class CompanyImageController {

    private CompanyImageService companyImageService;

    public CompanyImageController(CompanyImageService companyImageService) {
        this.companyImageService = companyImageService;
    }

    @GetMapping
    public ResponseEntity<CompanyImageDto> getCompanyImageByName(@RequestParam String name) {
        try {
            CompanyImageDto companyImage = companyImageService.getCompanyImageDtoByName(name);
            return new ResponseEntity<>(companyImage, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCompanyImage(@RequestParam String id,
                                                @RequestParam String name,
                                                @RequestParam String alt,
                                                @RequestParam(required = false) MultipartFile file) {
        Optional<CompanyImageDto> companyImageDtoOpt = companyImageService.mapParamsToDto(id, name, alt);
        if (companyImageDtoOpt.isPresent()) {
            System.out.println(companyImageDtoOpt.get());
            try {
                CompanyImageEntity companyImageEntity = companyImageService.updateCompanyImage(
                        companyImageDtoOpt.get(), file);
                CompanyImageDto companyImageDto = companyImageService.mapEntityToDto(companyImageEntity);
                return new ResponseEntity<>(companyImageDto, HttpStatus.OK);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
