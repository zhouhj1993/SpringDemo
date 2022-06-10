package com.example.springdemo.api.v1.controller;

import com.example.springdemo.api.v1.config.NeedLogin;
import com.example.springdemo.api.v1.entity.Result;
import com.example.springdemo.api.v1.entity.UserEntity;
import com.example.springdemo.api.v1.service.UserService;
import com.example.springdemo.util.DateUtil;
import com.example.springdemo.util.UserRedisUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Api(tags = {"Account"})
public class UserController {

    @Autowired
    private UserService mUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @ApiOperation(value = "注册")
    @PostMapping(value = "registration")
    public Result<String> registration(@RequestParam(value = "userName") @ApiParam(value = "账号或手机号") String userName,
                                       @RequestParam(value = "password") @ApiParam("密码") String password,
                                       @RequestParam(value = "imoocId") @ApiParam("慕课网用户id") String imoocId,
                                       @RequestParam(value = "orderId") @ApiParam("慕课网订单号") String orderId) {

        mUserService.addUser(userName, bCryptPasswordEncoder.encode(password), imoocId, orderId, DateUtil.getCurrentDate());

        return Result.success();
    }

    @ApiOperation("登录")
    @GetMapping("login")
    @ResponseBody
    public Result<String> login(@RequestParam(value = "userName") @ApiParam("账号或手机号") String userName,
                                @RequestParam(value = "password") @ApiParam("密码") String password,
                                HttpServletRequest request) {
        List<UserEntity> list = mUserService.findUser(userName);
        if (list == null || list.isEmpty()) {
            return Result.failure("账号不存在");
        }
        UserEntity userEntity = null;
        for (UserEntity entity : list) {
            //判断密码是否正确
            if (bCryptPasswordEncoder.matches(password, entity.getPwd())) {
                userEntity = entity;
                break;
            }
        }
        if (userEntity == null) {
            return Result.failure("密码错误");
        } else if ("1".equals(userEntity.getForbid())) {
            return Result.failure("用户被禁用");
        }
        UserRedisUtil.addUser(redisTemplate, request.getSession(), userEntity);
        return Result.success(UserRedisUtil.getKey(request.getSession()), "登录成功");
    }

    @ApiOperation(value = "登出")
    @GetMapping(value = "logout")
    @NeedLogin
    public Result<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserRedisUtil.removeUser(redisTemplate, session);
        return Result.success();
    }
}
