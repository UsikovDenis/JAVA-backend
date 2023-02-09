package com.example.javaback.service;


import com.example.javaback.entity.FileEntity;
import com.example.javaback.repository.FileRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;

    @Value("${javaback.file-dir}")
    private String fileDir; /////?????




    public void uploadFiles(List<MultipartFile> files) {
        files.forEach(multipartFile -> {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setPath(fileDir);
            fileEntity.setName(multipartFile.getOriginalFilename());
            save(fileEntity, multipartFile);
            fileRepository.save(fileEntity);
        });
    }

    private void save(FileEntity file, MultipartFile multipartFile) {
        try {
            Path path = Path.of(file.getPath());
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            multipartFile.transferTo(Path.of(file.getAbsolutePath()));
        } catch (IOException e) {
           e.printStackTrace();
        }
    }




}
