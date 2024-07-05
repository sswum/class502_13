package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator {

    private MemberMapper mapper;

    public LoginValidator(MemberMapper mapper) {
        this.mapper = mapper;
    }


    @Override //로그인 검증 로그인 발리데이터
    public void check(HttpServletRequest form) {
        String email = form.getParameter("email");
        String password = form.getParameter("password");

        // 필수 항목 검증
        checkRequired(email, new BadRequestException("이메일을 입력하세요"));
        checkRequired(password, new BadRequestException("비밀번호를 입력하세요"));

        // 이메일로 회원이 조회되는 검증
        // 이젠 db조회가 가능해짐
        //아이디가 맞고 비밀번호가 틀리면 비밀번호를 무한 검증 한다.
        String message = "이메일 또는 비밀번호가 일치하지 않습니다.";
        Member member = mapper.get(email);

        checkTrue(member != null, new BadRequestException(message));

        //비밀번호 일치 여부 체크
        boolean isMatched = BCrypt.checkpw(password, member.getPassword());
        checkTrue(isMatched,new BadRequestException(message));
    }
}
