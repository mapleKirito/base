package com.linktones.webview.controller;

import com.linktones.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public String login(@Param("account") String account, @Param("password") String password,
                        Model model,
                        HttpServletResponse response){
        User user =restTemplate.getForObject("http://USERSERVICE/user/login?account="+account+"&password="+password,User.class);
        if(user==null){
            model.addAttribute("error","登陆失败，用户名或密码错误");
            return "login";
        }

        Cookie cookie=new Cookie("token",user.getToken());
        response.addCookie(cookie);

        return "redirect:/";
    }
}
