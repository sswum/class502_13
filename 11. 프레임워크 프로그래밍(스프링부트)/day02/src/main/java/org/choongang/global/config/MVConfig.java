package org.choongang.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@Configuration
@EnableScheduling //상황에 따라서 달라지는 게 있으면 직접 써서 지정해서 알려줘야 한다.
public class MVConfig implements WebMvcConfigurer {
}
