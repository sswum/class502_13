package org.choongang.survey.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j //로그 쓸 때 꼭 써야함!애노테이션~
@Controller
@RequestMapping("/survey")
@SessionAttributes("requestSurvey")
public class SurveyController {

    @ModelAttribute
    public RequestSurvey requestSurvey() {
        return new RequestSurvey();
    }

    // 설문조사 형태의 페이지로 한 페이지 두페이지 세페이지 요런식으로
    @GetMapping("/step1")
    //get방식일 땐 모델 어트리뷰트 애노테이션 달기
    public String step1(@ModelAttribute RequestSurvey form) {

        return "survey/step1";
    }

    @PostMapping("/step2")
    public String step2(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2) {

        log.info("form : " + form.toString());
        log.info("form2 : " + form2.toString());

        return "survey/step2";
    }

    @PostMapping("/step3")
                                            //매직폼이다 ,값을 유지하기 위해서 쓰는 것 (예약페이지, 설문지에서 활용)
    public String step3(RequestSurvey form, RequestSurvey form2, SessionStatus status, HttpSession session) {

        log.info("form : " + form.toString());
        log.info("form2 : " + form2.toString());


        status.setComplete(); //세션 비우기 : requestSurvey 세션 비우기;

        System.out.println("세션 비우기 후 :" + session.getAttribute("requestSurvey"));
        return "survey/step3";
    }
}
