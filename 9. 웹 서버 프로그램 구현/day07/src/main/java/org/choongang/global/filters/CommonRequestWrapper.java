package org.choongang.global.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;

public class CommonRequestWrapper extends HttpServletRequestWrapper {
    public CommonRequestWrapper(ServletRequest req) {
        super((HttpServletRequest) req); //형 변환
        //공통 기능 부여
        HttpServletRequest request=(HttpServletRequest)req;
        /* 로그인 상태, 로그인 회원 정보 전역 유지 */
        //서버쪽에서 2차가공해서 만든 정보 setAttribute를 사용해서 속성을 변경하겠당!

        boolean isLogin = MemberUtil.isLogin(request);
        Member member = MemberUtil.getMember(request);

        //전역에 유지할 내용을 넣음
        request.setAttribute("isLogin",isLogin);
        request.setAttribute("loggedMember",member);
    }
}
