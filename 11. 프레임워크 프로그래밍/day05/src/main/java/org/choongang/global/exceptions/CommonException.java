package org.choongang.global.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Setter
@Getter
//예외 클래스는 상속 받아서 구현한다.
public class CommonException extends RuntimeException {

    private HttpStatus status;
    //실제로 스프링에서 제공하는 enum 상수를 쓸거당.
    private Map<String, List<String>> errorMessages;


    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); //500번대 코드
    }

    public CommonException(String message, HttpStatus status) {

        super(message);
        this.status=status;
    }

}
