package filters;

import jakarta.servlet.*;

import java.io.IOException;

//공통으로 들어오는 필터는 여기서 처리할 수 있도록 클래스 생성
public class CommonFilter implements Filter {
    //implements Filter 할 때 필터는 자카르타 필터 선택해야함

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init()");
        String key1 = filterConfig.getInitParameter("key1");
        String key2 = filterConfig.getInitParameter("key2");
        System.out.printf("key1=%s, key2=%s%n", key1, key2);
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("Common Filter 요청 전"); //

        chain.doFilter(new CommonRequestWrapper(request), response);

//        System.out.println("Common Filter 요청 후");

    }


}
