package com.ftq.webpage.controller;

import com.ftq.webpage.pojo.User;
import com.ftq.webpage.result.Result;
import com.ftq.webpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/login")
    public Result login(@RequestBody User requestUser) {
        //对html标签进行转义,防止XSS攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());

        if (null == user) {
            String msg = "账号密码错误";
            System.out.println(msg);
            return new Result(400);
        } else {
            return new Result(200);
        }
    }

    @CrossOrigin
    @PutMapping(value = "/api/logout")
    @ResponseBody
    public Result logout() {
        System.out.println("成功登出");
        return new Result(200);
    }

}
