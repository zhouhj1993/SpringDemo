package com.example.springdemo.api.v1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "商品类别")
public class CategoryEntity {

    @ApiModelProperty(value = "商品类别ID")
    private Integer categroyId;
    @ApiModelProperty(value = "类别名称")
    private String categoryName;
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    public CategoryEntity(Integer categroyId, String categoryName, String createTime) {
        this.categroyId = categroyId;
        this.categoryName = categoryName;
        this.createTime = createTime;
    }

    public Integer getCategroyId() {
        return categroyId;
    }

    public void setCategroyId(Integer categroyId) {
        this.categroyId = categroyId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
