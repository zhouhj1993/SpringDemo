package com.example.springdemo.api.v1.service;

import com.example.springdemo.api.v1.entity.CategoryEntity;
import com.example.springdemo.api.v1.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryService {

    @Autowired
    private CategoryMapper mCategoryMapper;

    public List<CategoryEntity> categories(int pageIndex, int pageSize) {
        return mCategoryMapper.categories(pageIndex, pageSize);
    }

}
