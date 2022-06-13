package com.example.springdemo.api.v1.config;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 接口需要预先登录
 */
public @interface NeedLogin {
}
