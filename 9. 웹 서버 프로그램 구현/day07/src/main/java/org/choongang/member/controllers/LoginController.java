package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;

import java.io.IOException;

import static org.choongang.global.MessageUtil.alertError;
import static org.choongang.global.MessageUtil.go;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            LoginService service = MemberServiceProvider.getInstance().loginService();
            service.process(req);

            /* 이메일 기억하기 처리 S */
            String email = req.getParameter("email");
            Cookie cookie = new Cookie("saveEmail", email); // 쿠키를 사용하는 건 좋은 방법이 아님 기능을 배우기 위해 씀
            if (req.getParameter("saveEmail") != null) { //이메일 기억하기 체크 , 얼마나 오래 기억할 지 설정
                //7일간 기억하기
                cookie.setMaxAge(60*60*24*7);
            }   else { //체크 해제 -쿠키 제거
                cookie.setMaxAge(0);
            }
            resp.addCookie(cookie);
            /* 이메일 기억하기 처리 E */


        //요청이 들어오면 부모창이 응답에 나오게끔
            go(req.getContextPath()+"/", "parent", resp);
        } catch (CommonException e) {
            alertError(e,resp); //에러가 뜨면 만들어둔 알러트 에러를 이용해서 메세지 보내줌
        }
    }
}
