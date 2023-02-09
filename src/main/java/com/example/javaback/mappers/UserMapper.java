package com.example.javaback.mappers;

import com.example.javaback.dto.UserDto;
import com.example.javaback.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface UserMapper {
    @Mapping(target = "nickName", source = "name")
    UserDto toDto(User user);

    @Mapping(target = "name", source = "nickName")
    User toEntity(UserDto userDto);
}
