package org.choongang.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("org.choongang")
@Import({DBConfig.class, MessageConfig.class, InterceptorConfig.class, FileConfig.class})
//@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

   // private final JoinValidator joinValidator;


    //모든 컨트롤러에 적용될 수 있는 전역 Validator에 해당
    /*@Override
    public Validator getValidator() {
        return joinValidator;
    }*/

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");

        registry.addViewController("/mypage")
                .setViewName("mypage/index");
    }
/*
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }

 */

    @Bean
    //프로퍼티 파일에 있는 설정을 교체 하겠다. (placeholder=교체)
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        String fileName = "application";
        //환경변수 가져오기
        String profile = System.getenv("spring.profiles.active");
        fileName += StringUtils.hasText(profile) ? "-" + profile:"";

        /**
         * spring.profiles.active=dev
         * -> application-dev
         *
         * spring.profiles.active=prod
         * ->application-prod
         */

        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(new ClassPathResource(fileName + ".properties"));
        return conf;
    }

    @Override
    //아까 날짜를 바꿔주는 JSONFORMAT말고 다른걸 써보자!
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder //자바 - 제이슨 바꿔주는 오브젝매퍼
                .json()
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
                .build();

        //내가 지금 적용한 내용이 반영이 제일 첫번째로 올 수 있게 0번으로 했다.
        converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
    }
}