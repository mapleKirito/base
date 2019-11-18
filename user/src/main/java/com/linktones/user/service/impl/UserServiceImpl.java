package com.linktones.user.service.impl;

import com.linktones.entity.User;
import com.linktones.user.mapper.UserMapper;
import com.linktones.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getByToken(String token) {
        User user = userMapper.findByToken(token);
        return user;
    }

    @Override
    public User getByAccount_Pwd(String account, String password) {
        User checkUser=new User();
        checkUser.setAccount(account);
        checkUser.setPassword(password);
        User user=userMapper.getUser(checkUser);
        if(user!=null){
            //创建token，更新user表
            String token= UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmt_last_login(System.currentTimeMillis());
            userMapper.updateToken(user);
        }
        return user;
    }
}
