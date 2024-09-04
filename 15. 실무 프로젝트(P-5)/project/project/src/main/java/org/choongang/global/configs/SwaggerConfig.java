package org.choongang.global.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info=@Info(title="API 명세", description = "설명....", contact = @Contact(name="Sumin Jeon", email="l5450won@naver.com"), version="v1"))
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("API 명세 v1")
                .pathsToMatch("/api/v1/**")  // v1이하의 주소는 다 API명세 만들어짐
                .build();
    }
}