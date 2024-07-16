package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice("org.choongang")
public class CommonControllerAdvice {

    @ExceptionHandler(Exception.class)
                                //▼온갖 종류의 예외를 잡을 것임
    public String errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response, Model model) {
        e.printStackTrace();
        log.info("advice 유입");

        //온갖 예외가 들어오면 그중에서 내가 원하는 500 코드 오류를 찾아야 한다.
        HttpStatus status= HttpStatus.INTERNAL_SERVER_ERROR; //500코드
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }
        return "error/common";
    }
}