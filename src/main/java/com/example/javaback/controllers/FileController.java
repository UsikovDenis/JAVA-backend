package com.example.javaback.controllers;


import com.example.javaback.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RequestMapping("/file")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class FileController {
    private  final FileService fileService;


    @PostMapping(path = "/{userId}" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void uploadFiles(@PathVariable UUID userId, @RequestParam List<MultipartFile> files){
        fileService.uploadFiles(userId, files);
    }


}
