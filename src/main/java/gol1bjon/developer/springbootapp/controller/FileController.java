package gol1bjon.developer.springbootapp.controller;

import gol1bjon.developer.springbootapp.payload.FileDTO;
import gol1bjon.developer.springbootapp.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<FileDTO> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        FileDTO save = fileService.save(multipartFile);
        return ResponseEntity.ok(save);
    }

}
