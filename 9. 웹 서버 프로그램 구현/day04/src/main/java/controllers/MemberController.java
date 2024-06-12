package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//따로 xml 쓰지않고도 요렇게 애노테이션 써서 할수도 있음. (세세하게 설정 원하면 xml)
@WebServlet("/member/*")
//서블릿을 만들기 위해서 extends를 사용해서 상속시키기
public class MemberController extends HttpServlet {
    @Override  //컨트롤 + O doGet , doPost 오버라이딩!
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//HttpServletRequest req <- req는 톰캣이 만듦!!

        String mode = getMode(req);
        if (mode.equals("join")) {
            joinForm(req, resp);
        } else if (mode.equals("login")) {
            loginForm(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = getMode(req);
        if (mode.equals("join")) {
            joinProcess(req, resp);
        } else if (mode.equals("login")) {
            loginProcess(req, resp);
        }
    }

    private String getMode(HttpServletRequest req) {
        //join과 login을 따로 분리시키겠다!
        String url = req.getRequestURI(); //getMode가 뒤에 주소를 짤라오는 역할

        //url 전체에서 끝을 바꾸기 쉽게 함수 만드는중!
        //url을 배열로 만들어서 마지막에 /까지 자른다.
        //-1 넣으면 맨끝에가 나온다.

        String[] urls = url.split("/"); //슬래시에서 잘라주겠다.
        String mode = urls.length > 0 ? urls[urls.length - 1] : ""; // 끝에 있는걸 잘라오겠다.

        return mode;
    }

    //회원 가입 양식
    private void joinForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //사용자의 콘텐츠타입이 뭔지 알려줘야 한다. 그래야 한글 안 깨짐
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>회원가입</h1>");
    }

    //로그인 양식
    private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>로그인</h1>");

    }

    //회원 가입처리
    private void joinProcess(HttpServletRequest req, HttpServletResponse resp) {

    }

    //로그인 처리
    private void loginProcess(HttpServletRequest req, HttpServletResponse response) {

    }
}
