package org.choongang.member.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/member/logout")
public class Logoutcontroller extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //세션은 개인데이터가 담겨져 있기 때문에 비워줘야한다.
        HttpSession session= req.getSession();
        session.invalidate(); // invalidate로 세션 비우기! (로그아웃)

        resp.sendRedirect(req.getContextPath()+"/member/login");
    }
}
