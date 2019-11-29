package com.alone.mymall.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.misc.Request;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createResultApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                //为当前包下Controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.alone.mymall.controller"))
                //为有API注解的Controller生成API注解
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@APiOperation注解的方法生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("SwaggerUI演示").description("mall-tiny").contact("macro").version("1.0").build();
    }
}
