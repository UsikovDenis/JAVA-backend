package com.example.javaback.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {
    public static final String NOT_FOUND_USER = "Такого пользователя нет";

}
