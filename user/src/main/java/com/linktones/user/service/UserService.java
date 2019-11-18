package com.linktones.user.service;

import com.linktones.entity.User;

public interface UserService {
    //根据token查询登录状态
    public User getByToken(String token);

    public User getByAccount_Pwd(String account,String password);
}
