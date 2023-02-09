package com.example.javaback.mappers.decorators;

import com.example.javaback.dto.UserDto;
import com.example.javaback.entity.FileEntity;
import com.example.javaback.entity.User;
import com.example.javaback.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class UserMapperDecorator implements UserMapper {

    @Autowired
    private UserMapper delegate;


    @Override
    public UserDto toDto(User user) {
        UserDto userDto = delegate.toDto(user);
        userDto.setFiles(
                user.getFiles().stream()
                        .map(FileEntity::getId)
                        .collect(Collectors.toList())
        );
        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        return delegate.toEntity(userDto);
    }
}
