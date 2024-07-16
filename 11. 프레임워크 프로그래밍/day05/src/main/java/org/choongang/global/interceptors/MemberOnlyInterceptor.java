package org.choongang.global.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class MemberOnlyInterceptor implements HandlerInterceptor {//공통적인 값을 유지하기 위해서 | 많이 쓰는 건 프리핸들!

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //모델앤뷰 값을 반환받고 실행되기 때문에 모델앤뷰가 있다.
        modelAndView.addObject("message","postHanlde!");
        log.info("postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
      //예외가 있지만 null값이 있을수도 있다.
        log.info("afterCompletion()");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("preHandle()");
        HttpSession session = request.getSession(); //세션하나 가져오기
        if (session.getAttribute("member") != null) { //로그인 상태인 경우
            return true; //컨트롤러 빈 메서드 실행
        }
        //로그인 상태가 아니면 로그인 페이지로
        response.sendRedirect(request.getContextPath()+ "/member/login");

        return false; //미로그인 상태

    }

}
