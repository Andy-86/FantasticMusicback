package com.example.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.CurrentUser;
import com.example.demo.annotation.LoginRequired;
import com.example.demo.model.User;
import com.example.demo.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by andy on 2017/11/20.
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
    private UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public Object add(@RequestParam("name")String name, @RequestParam("password") String password) {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        if (userService.findByName(user.getName()) != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "用户名已被使用");
            return jsonObject;
        }
        return userService.add(user);
    }
    @LoginRequired
    @GetMapping("/test")
    public Object testLogin(@CurrentUser User user) {
        return user;
    }
}

