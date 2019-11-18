package com.linktones.webview.controller;

import com.linktones.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 首页Controller
 * 根据登陆条件跳转：
 * index--已登陆；login--未登录
 */

@Controller
public class IndexController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String index(HttpSession session,
                        HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    User user =restTemplate.getForObject("http://USERSERVICE/user/token/"+token,User.class);
                    if(user!=null){
                        session.setAttribute("user",user);
                        return "index";
                    }

                }

            }
        }
        return "login";

    }
}
