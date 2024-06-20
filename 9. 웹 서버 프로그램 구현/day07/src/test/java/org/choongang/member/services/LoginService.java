package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.validators.Validator;
import org.choongang.member.mapper.MemberMapper;

public class LoginService {

    private Validator<HttpServletRequest> validator;
    //회원 정보 조회를 하기 위해서 매퍼 필요 의존성 추가
    private MemberMapper mapper;

    public LoginService(Validator<HttpServletRequest> validator, MemberMapper mapper) {
        this.validator= validator;  //개방폐쇄원칙 - 확장된 부분을 열어놨다
        this.mapper = mapper;
    }

    //로그인 서비스 기능을 처리하도록 메소드 생성
    public void process(HttpServletRequest request) {
//로그인 유효성 검사를 넣음~!
        validator.check(request);
    }
}

