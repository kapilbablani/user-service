package com.user.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(paths()).build();
    }

    private Predicate<String> paths() {
        return or(regex("/api/v1/users"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("User Management API")
                .description("A concrete API to perform user management")
                .termsOfServiceUrl("www.test.com/terms")
                .contact("bablanikapil@gmail.com").license("User License")
                .licenseUrl("bablanikapil@gmail.com").version("1.0").build();
    }
}
