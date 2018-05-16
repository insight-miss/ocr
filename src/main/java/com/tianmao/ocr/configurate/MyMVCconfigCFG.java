package com.tianmao.ocr.configurate;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCconfigCFG implements WebMvcConfigurer {
    private final static String URI_CORS_STARTWITH = "/**";

    /*添加可跨域访问*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(URI_CORS_STARTWITH);
    }

//    /**/
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/fileupload").setViewName("file/fileupload");
//    }
}