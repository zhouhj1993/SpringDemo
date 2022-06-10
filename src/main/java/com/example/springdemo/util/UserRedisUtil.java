package com.example.springdemo.util;

import com.example.springdemo.api.v1.entity.UserEntity;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserRedisUtil {

    public static final String BOARDING_PASS = "boarding-pass";

    /**
     * 将用户信息保存到redis
     *
     * @param redisTemplate
     * @param session
     * @param userEntity
     */
    public static void addUser(StringRedisTemplate redisTemplate, HttpSession session, UserEntity userEntity) {
        //用户session写入redis
        redisTemplate.opsForValue().set(getKey(session), JsonUtil.toJsonString(userEntity));

    }

    /**
     * 将用户信息从redis中移除
     *
     * @param template
     * @param session
     */
    public static void removeUser(StringRedisTemplate template, HttpSession session) {
        //session.invalidate();
        //将用户从redis中移除
        template.delete(getKey(session));
    }

    public static Boolean checkUser(StringRedisTemplate template, HttpServletRequest request) {
        String val = template.opsForValue().get(getBoardingPass(request));
        return val != null;
    }

    public static UserEntity getUser(StringRedisTemplate template, HttpServletRequest request) {
        //检测redis中是否含有session id
        String val = template.opsForValue().get(getBoardingPass(request));
        if (val != null) {
            return JsonUtil.fromJson(val, UserEntity.class);
        }
        return null;
    }

    /**
     * 获取redis存储的key
     *
     * @param session
     * @return
     */
    public static String getKey(HttpSession session) {
        return session.getId();
    }

    /**
     * 获取是否登录的凭证
     *
     * @param request
     * @return
     */
    public static String getBoardingPass(HttpServletRequest request) {
        String pass = request.getHeader(BOARDING_PASS);
        return pass != null ? pass : "no-pass";
    }

}
