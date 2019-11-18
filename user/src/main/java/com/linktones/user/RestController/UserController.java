package com.linktones.user.RestController;

import com.linktones.entity.User;
import com.linktones.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/token/{token}")
    public User getByToken(@PathVariable("token") String token){
        User user = userService.getByToken(token);
        return user;
    }

    @GetMapping("/login")
    public User login(@RequestParam("account") String account, @RequestParam("password") String password){
        User user=userService.getByAccount_Pwd(account,password);
        return user;
    }
}
