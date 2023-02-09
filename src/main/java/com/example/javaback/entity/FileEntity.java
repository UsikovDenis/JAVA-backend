package com.example.javaback.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "file")
@Getter
@Setter
public class FileEntity {


    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @Column(nullable = false)
    private String path;

    private LocalDateTime createDataFile;

    @PrePersist
    private void create() {
        createDataFile = LocalDateTime.now();
    }

    public String getAbsolutePath() {
        return path + "/"+ name;
    }

}
