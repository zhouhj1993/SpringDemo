package com.example.springdemo.api.v1.mapper;

import com.example.springdemo.api.v1.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 为数据库查询配置的映射关系类
 */
@Repository
public interface UserMapper {
    void addUser(String userName,String password,String imoocId,String orderId,String createTime);

    List<UserEntity> findUser(String userName);

}
