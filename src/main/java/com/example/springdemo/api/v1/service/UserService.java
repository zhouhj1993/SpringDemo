package com.example.springdemo.api.v1.service;

import com.example.springdemo.api.v1.entity.UserEntity;
import com.example.springdemo.api.v1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {
    @Autowired
    private UserMapper mUserMapper;

    public void addUser(String userName, String password, String imoocId, String orderId, String createTime) {
        mUserMapper.addUser(userName, password, imoocId, orderId, createTime);
    }

    public List<UserEntity> findUser(String userName) {
        return mUserMapper.findUser(userName);
    }
}
