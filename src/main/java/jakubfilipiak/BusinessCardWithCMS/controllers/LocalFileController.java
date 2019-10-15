package jakubfilipiak.BusinessCardWithCMS.controllers;

import jakubfilipiak.BusinessCardWithCMS.services.FileService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Created by Jakub Filipiak on 15.10.2019
 */
@RestController
@RequestMapping("/api/local-file")
public class LocalFileController {

    private FileService fileService;

    public LocalFileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> openFileInBrowser(@PathVariable String name) {
        Optional<File> fileOpt = fileService.getLocalFileByName(name);
        if (fileOpt.isPresent()) {
            File file = fileOpt.get();
            Path path = Paths.get(fileService.createLocalPath(name));
            try {
                String contentType = Files.probeContentType(file.toPath());
                Resource resource = new UrlResource(path.toUri());
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .contentLength(file.length())
                        .body(resource);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
