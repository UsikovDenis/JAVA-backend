package com.example.javaback.controllers;


import com.example.javaback.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/file")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class FileController {
    private  final FileService fileService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void uploadFiles(@RequestParam List<MultipartFile> files){
        fileService.uploadFiles(files);
    }


}
