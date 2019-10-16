package jakubfilipiak.BusinessCardWithCMS.controllers;

import jakubfilipiak.BusinessCardWithCMS.models.AboutEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.AboutDto;
import jakubfilipiak.BusinessCardWithCMS.services.AboutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@RestController
@RequestMapping("/api/about")
public class AboutController {

    private AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping()
    public ResponseEntity<?> getAbout() {
        List<AboutDto> abouts = aboutService.getAboutsDto();
        return new ResponseEntity<>(abouts, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateAbout(@RequestParam String id,
                                         @RequestParam String description) {
        Optional<AboutDto> aboutDtoOpt = aboutService.mapParamsToDto(id, description);
        if (aboutDtoOpt.isPresent()) {
            System.out.println(aboutDtoOpt.get());
            AboutEntity aboutEntity = aboutService.updateAbout(aboutDtoOpt.get());
            AboutDto aboutDto = aboutService.mapEntityToDto(aboutEntity);
            return new ResponseEntity<>(aboutDto, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
