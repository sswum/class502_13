package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.validators.Validator;

public class LoginService {

    private Validator<HttpServletRequest> validator;

    public LoginService(Validator<HttpServletRequest> validator) {
        this.validator= validator;  //개방폐쇄원칙 - 확장된 부분을 열어놨다
    }

    //로그인 서비스 기능을 처리하도록 메소드 생성
    public void process(HttpServletRequest request) {
//로그인 유효성 검사를 넣음~!
        validator.check(request);
    }
}

