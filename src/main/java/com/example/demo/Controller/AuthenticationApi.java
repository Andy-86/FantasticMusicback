package com.example.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.User;
import com.example.demo.server.AuthenticationService;
import com.example.demo.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by andy on 2017/11/20.
 */
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationApi {
    private AuthenticationService authenticationService;
    private UserService userService;

    @Autowired
    public AuthenticationApi(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("")
    public Object login(@RequestParam("name")String name, @RequestParam("password") String password) {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        User userInDataBase = userService.findByName(user.getName());
        JSONObject jsonObject = new JSONObject();
        if (userInDataBase == null) {
            jsonObject.put("message", "用户不存在");
        } else if (!userService.comparePassword(user, userInDataBase)) {
            jsonObject.put("message", "密码不正确");
        } else {
            String token = authenticationService.getToken(userInDataBase);
            jsonObject.put("token", token);
            jsonObject.put("user", userInDataBase);
        }
        return jsonObject;
    }
}
