package org.choongang.global.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
@WebFilter("/*") //요청되는 모든 유입을 필터 처리를 하겠따
public class CommonFilter implements Filter{


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //만든 랩퍼를 필터에 적용 | 모든 요청과 응답에
        chain.doFilter(new CommonRequestWrapper(request),response);
    }
}
