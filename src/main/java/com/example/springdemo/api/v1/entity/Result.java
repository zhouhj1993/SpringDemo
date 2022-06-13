package com.example.springdemo.api.v1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据返回基类
 */
@ApiModel(description = "响应数据")
public class Result<T> {
    @ApiModelProperty(value = "请求是否成功")
    private Boolean success;
    @ApiModelProperty(value = "操作详情")
    private String message;
    @ApiModelProperty(value = "响应数据")
    private T data;

    private Result(T data, Boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }


    public static <T> Result<T> success() {
        return success(null, "请求成功");
    }

    public static <T> Result<T> success(String message) {
        return success(null, message);
    }

    public static <T> Result<T> success(T data) {
        return success(data, "请求成功");
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(data, true, message);
    }

    public static <T> Result<T> failure() {
        return failure(null, "请求失败");
    }

    public static <T> Result<T> failure(String message) {
        return failure(null, message);
    }

    public static <T> Result<T> failure(T data) {
        return failure(data, "请求失败");
    }

    public static <T> Result<T> failure(T data, String message) {
        return new Result<T>(data, false, message);
    }
}
