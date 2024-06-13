package order.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //서비스 처리 ...(서블릿 통해서 처리를 해서 뷰로 나옴/1)
        req.setAttribute("message", "처리완료");
        //출력 처리(View) (위에서 처리해서 뷰로 나옴/2)  //변경된 경로를 입력해줌 ▼
        RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/templates/order/order.jsp");
        rd.forward(req,resp);

    }
}
