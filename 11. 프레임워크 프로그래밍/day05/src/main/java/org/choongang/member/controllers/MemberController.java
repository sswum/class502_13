package org.choongang.member.controllers;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.entities.Member;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

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
/*
    @GetMapping("/list")
    public String list(@Valid @ModelAttribute MemberSearch search, Errors errors) {
        //검증을 해야하니까 @Valid를 넣고 여러 애노테이션 넣을 수 있따. @Valid넣었으니 에러즈 에러즈
        log.info(search.toString());
        boolean result = false;
        if (!result) {
            throw new BadRequestException("예외 발생!!!");
        }
        return "member/list";
    }

 */

    @GetMapping("/list")
    public String list2(Model model) {

        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("<h1>사용자01</h1>")
                .regDt(LocalDateTime.now())
                .build();
                //회원 데이터는 연습하기 위해서 넣어봄.
        model.addAttribute("member", member);
        //모델이라는명으로 속성명을 넣었다.



        List<Member> items = IntStream.rangeClosed(1,10)
                .mapToObj(i-> Member.builder()
                        .email("user"+i+"@test.org")
                        .userName("사용자"+i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();
        model.addAttribute("items", items);

        return "member/list2";

    }









    @ResponseBody //반환값을 void 하기 위해서 넣었고 나중에 설명해주신다고 함.
    @GetMapping("/info/{id}")
    //{id} => 바뀔 수 있는 변수 경로의 값 , 패턴만 입력하면 교체 가능한 부분이고 여러개를 쓸 수 있다.
    // 값을 바꾸면 자동적으로 형 변환이 된다.
    public void info(@PathVariable("id") String email, @PathVariable(name = "id2", required = false) String email2) {
        log.info("email:{}, email2:{}", email, email2);
    }

    @ResponseBody
    @GetMapping("/list2")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        .password("12345678")
                        .userName("사용자" + i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();
        return members;
    }
    /*

    @ExceptionHandler(BadRequestException.class)
    public String errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response, Model model) {
        e.printStackTrace();
        log.info("MemberController에서 유입");
        return "error/common";
    }
*/

     /*  @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }//위에 @Valid 애노테이션이 있으면 initBinder를 통해서 검증을 한다.
*/

}
