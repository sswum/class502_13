package org.choongang.member.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    //DM에 있는 걸 가져오려면 멤버매퍼
    private final MemberMapper mapper;
    //세션을 가져오려면 2가지 방법이 있다.
    //리퀘스트로 할수도 있고 세션을 바로 주입해서 쓸 수도 있다.
    private final HttpSession session;
    private final HttpServletResponse response;

    public void process(String email) {
        /**
         * 1. email로 회원 조회
         * 2. 세션에 회원 정보를 유지
         */

        Member member = mapper.get(email);
        if (email == null) {
            return;
        }
        session.setAttribute("member", member);
    }

    public void process(RequestLogin form) {
        process(form.getEmail());

        /* 이메일 기억하기 처리 */
        Cookie cookie = new Cookie("saveEmail", form.getEmail());
        if (form.isSaveEmail()) { //쿠키 등록
            cookie.setMaxAge(60 * 60 * 24 * 7); //7일간 쿠키 유지
        } else { //쿠키 제거
            cookie.setMaxAge(0);
        }
response.addCookie(cookie);

    }
}
