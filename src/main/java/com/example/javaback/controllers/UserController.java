package com.example.javaback.controllers;

import com.example.javaback.dto.UserDto;
import com.example.javaback.entity.User;
import com.example.javaback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping
    public List<UserDto> getAll(){ return userService.getAll(); }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") UUID userId){
        return userService.getById(userId);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID userId){
        userService.deleteById(userId);
    }

    @PostMapping
    public UUID createUser(@RequestBody UserDto user){
        user.setId(null);
        return userService.createUser(user);
    }




}
