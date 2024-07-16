package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

//예외 클래스는 상속 받아서 구현한다.
public class CommonException extends RuntimeException {

    private HttpStatus status;
    //실제로 스프링에서 제공하는 enum 상수를 쓸거당.
    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); //500번대 코드
    }

    public CommonException(String message, HttpStatus status) {

        super(message);
        this.status=status;
    }

    public HttpStatus getStatus() {
        //상수형태인 status를 조회하겠다
        return status;
    }
}
