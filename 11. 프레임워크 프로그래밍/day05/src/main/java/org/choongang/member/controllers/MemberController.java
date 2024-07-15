package org.choongang.member.controllers;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.entities.Member;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @GetMapping("/join")
    //@ModelAttribute 애노테이션으로 붙임으로 EL식으로 JSP에 'requestJoin'으로 자동속성이 추가됨.
    public String join(@ModelAttribute RequestJoin form) {

        return "member/join";
    }

    @PostMapping("/join") //커맨드객체인 RequestJoin form!
    public String joinPs(@Valid RequestJoin form, Errors errors) {

        //->@Valid 애노테이션을 넣으면 폼을 검증하게 되고 만약 문제가 있으면 에러즈로 값이감.
        // 커맨드 객체 뒤에 에러객체가 정의 돼있어야 객체 안에 검증이 된다.
        //회원 가입 데이터 검증
        joinValidator.validate(form, errors); //이게 주석처리 돼어도 위에 @Valid가 있어서 검증이 된다.

        if (errors.hasErrors()) { //오류가 나게 되면 계속 가입폼양식이 계속 보이도록 | reject,rejectValue가 한번이라도 호출되면 true
            return "member/join";
        }

        joinService.process(form); //회원 가입처리

        return "redirect:/member/login";
    }  //여기서 위에 모든 기능이 다 완료되면 서비스 기능을 구현하면 된다.


    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form, @SessionAttribute(name = "member", required = false) Member member) {
        if (member != null) {
            log.info(member.toString());
        }
        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form, errors);
        if (errors.hasErrors()) {
            //검증 실패시에는 양식을 다시 보여주고 잘 입력을 했을 때는
            //처리를 로그인해줘라
            return "member/login";
        }

        //로그인 처리
        loginService.process(form);
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); //세션 비우기
        return "redirect:/member/login";
    }


     /*  @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }//위에 @Valid 애노테이션이 있으면 initBinder를 통해서 검증을 한다.
*/
}