package com.example.javaback.service;


import com.example.javaback.entity.FileEntity;
import com.example.javaback.entity.User;
import com.example.javaback.exception.NotFoundException;
import com.example.javaback.repository.FileRepository;
import com.example.javaback.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.javaback.exception.ResponseMessage.NOT_FOUND_USER;

@Service
@RequiredArgsConstructor
public class FileService {
    private final UserRepository userRepository;
    private final FileRepository fileRepository;

    @Value("${javaback.file-dir}")
    private String fileDir;


    public void uploadFiles(UUID userId, List<MultipartFile> files) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));
        files.forEach(multipartFile -> {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setUser(user);
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
