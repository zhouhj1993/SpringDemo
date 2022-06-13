package com.example.springdemo.api.v1.mapper;

import com.example.springdemo.api.v1.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    List<CategoryEntity> categories(int pageIndex, int pageSize);

}
