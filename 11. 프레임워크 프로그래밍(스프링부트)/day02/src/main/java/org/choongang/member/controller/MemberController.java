package org.choongang.member.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
public class MemberController {

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) {
        return "/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors) {
        //잘되면 로그인이 되고 안되면 되면 에러

        return "/login";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}
