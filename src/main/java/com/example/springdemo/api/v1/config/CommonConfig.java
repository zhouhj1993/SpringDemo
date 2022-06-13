package com.example.springdemo.api.v1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置needLogin拦截器
 */
@Configuration
@EnableWebMvc
public class CommonConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInInterceptor loginInInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInInterceptor);
    }
}
