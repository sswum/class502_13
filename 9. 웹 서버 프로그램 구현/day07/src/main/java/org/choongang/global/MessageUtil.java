package org.choongang.global;

import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageUtil {
    public static void alertError(Exception e, HttpServletResponse resp) throws
            IOException {
        resp.setContentType("text/html; charset=UTF-8");
        if (e instanceof CommonException commonException) {
            //CommonException commonException = (CommonException) e;
            resp.setStatus(commonException.getStatus());
        }
            PrintWriter out = resp.getWriter();
            out.printf("<script>alert('%s'); </script>", e.getMessage());

    }

    public static void go(String url, String target, HttpServletResponse resp) throws
            IOException {
        //창의 이동을 위해 만든 메소드
        target = target == null || target.isBlank() ? "self" : target;
        //매개변수가 들어오면 이동을 할 수 있도록 해준다
       resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out= resp.getWriter();
        /**
         * location.href : 주소 이동 시 이동기록이 남는다. 뒤로가기 버튼을 누른 경우
         * POST 처리가 중복 된다.
         * POST 처리 시 이동할 때는 기록을 남기지 않는 이동 방식 location.replace(..)
         */
        out.printf("<script>%s.location.replace('%s'); </script>",target, url);
    }

    public static void go(String url, HttpServletResponse resp) throws IOException {
        go(url, "self", resp);
    }

}
