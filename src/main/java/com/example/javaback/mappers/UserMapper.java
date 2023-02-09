package com.example.javaback.mappers;

import com.example.javaback.dto.UserDto;
import com.example.javaback.entity.User;

import com.example.javaback.mappers.decorators.UserMapperDecorator;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {
    @Mapping(target = "nickName", source = "name")
    @Mapping(target = "files", ignore = true)
    UserDto toDto(User user);

    @Mapping(target = "name", source = "nickName")
    @Mapping(target = "files", ignore = true)
    User toEntity(UserDto userDto);
}
