package com.example.springdemo.api.v1.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户信息")
public class UserEntity {
    @ApiModelProperty(value = "uid")
    private String uid;
    @ApiModelProperty(value = "imooc用户ID")
    private String imoocId;
    @ApiModelProperty(value = "订单ID")
    private String orderId;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String pwd;
    @ApiModelProperty(value = "是否被禁用")
    private String forbid;
    @ApiModelProperty(value = "创建时间")
    private String createTime;


    public UserEntity(String uid, String imoocId, String orderId, String userName, String pwd, String forbid, String createTime) {
        this.uid = uid;
        this.imoocId = imoocId;
        this.orderId = orderId;
        this.userName = userName;
        this.pwd = pwd;
        this.forbid = forbid;
        this.createTime = createTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImoocId() {
        return imoocId;
    }

    public void setImoocId(String imoocId) {
        this.imoocId = imoocId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getForbid() {
        return forbid;
    }

    public void setForbid(String forbid) {
        this.forbid = forbid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
