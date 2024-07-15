package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends CommonException {
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST); // 400대 코드로 고정하겠다.
    }
}