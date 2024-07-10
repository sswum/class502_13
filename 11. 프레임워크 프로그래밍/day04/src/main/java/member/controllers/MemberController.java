package member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//특정 애노테이션을 써서 빈 객체로 관리 되도록 애노테이션 붙임
@Controller
public class MemberController {

    @GetMapping("/member/join")
    public String join(@RequestParam(value = "name", defaultValue = "기본값") String name) {
        System.out.println("name:" + name);
        return "member/join";
    }

    @PostMapping("/member/join")
    public String joinPs(RequestJoin form, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(form);
        return "member/join";
    }
}
//requestparam은 네임값을 지정해주면 그 값이 뒤에 들어간다는 것