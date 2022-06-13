package com.example.springdemo.api.v1.controller;

import com.example.springdemo.api.v1.entity.CategoryEntity;
import com.example.springdemo.api.v1.entity.Result;
import com.example.springdemo.api.v1.service.CategoryService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@Api(tags = {"Category"})
public class CategoryController {

    @Autowired
    private CategoryService mCategoryService;

    @ApiOperation("商品类别查询")
    @GetMapping("/categories")
    public Result<List<CategoryEntity>> category(
            @RequestParam(value = "pageIndex", defaultValue = "1") @ApiParam(name = "页码") int pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "10") @ApiParam(name = "查询个数") int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<CategoryEntity> list = mCategoryService.categories(pageIndex, pageSize);
        if (list == null || list.isEmpty()) {
            return Result.failure(list, "没有更多数据");
        } else {
            return Result.success(list);
        }
    }

}
