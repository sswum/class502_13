package board.controllers;

import board.entities.BoardData;
import board.services.BoardInfoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

//*는 아이디에 따라서 다르게 나오기 하기 위해서 삽입
@WebServlet("/board/list/*")
public class BoardListController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //protected => public으로 변경 그래야 접근 가능

        BoardInfoService service = new BoardInfoService();
        List<BoardData> items = service.getList(); //이 목록 데이터를 출력하기 위해 리스트써서 만듦

        req.setAttribute("items", items);
        //속성 통해서 view로 넘겨준다.


        //액션태그에 page와 같은 용도임. 버퍼의치환 ! 주소를 표기해준것
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/board/list.jsp");
        rd.forward(req, resp);


    }
}
