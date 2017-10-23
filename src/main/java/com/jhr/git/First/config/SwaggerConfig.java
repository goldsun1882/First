package com.jhr.git.First.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        ApiInfo apiInfo = new ApiInfo("sample of springboot", "sample of springboot", null, null, null, null, null);
        return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/user/.*")).build()
                .apiInfo(apiInfo).useDefaultResponseMessages(false);
    }
}
