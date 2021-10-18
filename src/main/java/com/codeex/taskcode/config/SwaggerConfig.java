package com.codeex.taskcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerEntitiesApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("entities")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.codeex.taskcode.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .version("1.0")
                                .title("A Sample Module - Entities API (CodeEx)")
                                .description("A Documentation entities API v1.0")
                                .build());
    }

}
