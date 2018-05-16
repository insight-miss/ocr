package com.tianmao.ocr.configurate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket FileUploadApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("File-Api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tianmao.ocr.controller.FileController"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("天猫工商图片识别",//大标题
                "api介绍",//小标题
                "1.1",//版本
                "NO terms of service",
                "me",//作者
                "点击进入网站界面",//链接显示文字
                "localhost:8080/tianmao/index"//"https://www.baidu.com"//"http://10.0.0.35:4200"//网站链接
        );

        return apiInfo;
    }

}
