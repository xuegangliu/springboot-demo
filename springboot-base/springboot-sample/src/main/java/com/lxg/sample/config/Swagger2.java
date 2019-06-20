package com.lxg.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2的配置
 * @author 刘雪岗 on 2017/1/3.
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        //  创建Docket的Bean
        return new Docket(DocumentationType.SWAGGER_2)
                //  创建该Api的基本信息（这些基本信息会展现在文档页面中）
                .apiInfo(apiInfo())
                //  返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
                .select()
                //  扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
                .apis(RequestHandlerSelectors.basePackage("com.lxg.servlet"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 文档描述信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot-sample")
                .description("springboot-sample")
                .termsOfServiceUrl("localhost:8082/sample")
                .contact("springboot-sample")
                .version("v0.0.1")
                .build();
    }
}
