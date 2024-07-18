package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Map;

public class BadRequestException extends CommonException {
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST); // 400대 코드로 고정하겠다.
        //404는 NOT FOUND
    }

    public BadRequestException(Map<String, List<String>> errorMessages) {
        super(null, HttpStatus.BAD_REQUEST);
        setErrorMessages(errorMessages);
    }
}