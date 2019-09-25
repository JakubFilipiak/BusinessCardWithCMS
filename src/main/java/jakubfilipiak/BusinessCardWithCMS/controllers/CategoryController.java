package jakubfilipiak.BusinessCardWithCMS.controllers;

import jakubfilipiak.BusinessCardWithCMS.models.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @GetMapping
    public ResponseEntity<CategoryDto> getCategories() {
        return null;
    }
}
