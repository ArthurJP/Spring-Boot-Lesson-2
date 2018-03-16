package com.jp.lesson2.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket( DocumentationType.SWAGGER_2 )
                .apiInfo( metaInfo() )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "com.jp.lesson2" ) )
                .paths( PathSelectors.any() )
                .build();
    }

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("这是一个标准的测试")
//                .termsOfServiceUrl("http://blog.didispace.com/")
                .version("1.0")
                .build();
    }
}
