package com.example.javaback.service;


import com.example.javaback.dto.UserDto;
import com.example.javaback.entity.User;
import com.example.javaback.exception.NotFoundException;
import com.example.javaback.mappers.UserMapper;
import com.example.javaback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.javaback.exception.ResponseMessage.NOT_FOUND_USER;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public List<UserDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getById(UUID id) {
        return userMapper.toDto(findById(id));
    }

    public void deleteById(UUID userId) {
        userRepository.delete(findById(userId));
    }

    public UUID createUser(UserDto userDto) {
        return userRepository.save(userMapper.toEntity(userDto)).getId();
    }


    private User findById(UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));
    }



}
