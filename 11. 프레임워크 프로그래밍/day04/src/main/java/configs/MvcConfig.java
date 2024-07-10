package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("member")
@Import(DBConfig.class)
public class MvcConfig implements WebMvcConfigurer { //모든 웹 설정에 대한 것들이 WebMvcConfigurer 인터페이스에 담겨있다.


    @Override  // 주소값에 /(슬래시)가 들어왔을 때 처리하는 역할(정적 경로가 있으면 거기 -> 또 없으면 다른 곳 찾으러 가고)
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override // 반환값에 따라서 출력할 뷰 객체를 찾아주는 역할
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }
}
