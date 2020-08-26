package com.ftq.webpage.controller;

import com.ftq.webpage.pojo.User;
import com.ftq.webpage.result.Result;
import com.ftq.webpage.result.ResultFactory;
import com.ftq.webpage.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = "/api/login")
    public Result login(@RequestBody User requestUser) {
        //对html标签进行转义,防止XSS攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);

        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        } catch (AuthenticationException e) {
            String msg = "账号或密码错误";
            return ResultFactory.buildFailResult(msg);
        }
    }

    @PutMapping(value = "/api/logout")
    @ResponseBody
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String msg = "成功登出";
        return ResultFactory.buildSuccessResult(msg);
    }

    @PostMapping(value = "api/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐，默认长度16位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置Hash算法迭代次数
        int times = 2;
        // 得到Hash后的密码
        String encodedassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedassword);
        userService.add(user);
        return ResultFactory.buildSuccessResult(user);
    }

    @GetMapping(value = "/api/authentication")
    @ResponseBody
    public Result authenticate() {
        String msg =  "身份认证成功";
        return ResultFactory.buildSuccessResult(msg);
    }

}
