package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class CommonConfig {

    public static final String SECRET_PHRASE = "@cc355t4g3";

    public static final String[] IGNORE_MATCHERS = {
            "/swagger-resources/**",
            "/swagger-resources/configuration/**",
            "/swagger-ui.html",
            "/swagger-ui.html/**",
            "/v2/api-docs",
            "/webjars/**",
            "/actuator/**",
            "/mensagem/**",
            "/usuario/forgotPassWord/**",
            "/dir/**",
            "/public/**",
    };

//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(2000000);
//        return multipartResolver;
//    }
}
