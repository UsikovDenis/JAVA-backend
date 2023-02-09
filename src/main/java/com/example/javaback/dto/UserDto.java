package com.example.javaback.dto;


import com.example.javaback.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDto {

    private UUID id;
    private String nickName;


//    public UserDto(UUID id, String name) {
//        this.id = id;
//        this.name = name;
//    }

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public static UserDto toDto(User user) {
//        return new UserDto(user.getId(), user.getName());
//    }

}
