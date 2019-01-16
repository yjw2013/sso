package com.sso.controller;

import com.sso.domain.db.User;
import com.sso.domain.result.SSOResult;
import com.sso.service.UserService;
import com.sso.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 单点登录Controller
 */
@Controller
@RequestMapping("/sso")
public class UserController {

    private static final String COOKIE_NAME = "LOGIN_TOKEN";

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody User user) {
        SSOResult<Boolean> result = new SSOResult<Boolean>();
        Boolean register = userService.register(user);
        result.setData(register);
        return result;
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updatePwd(@RequestBody User user) {
        SSOResult<Boolean> result = new SSOResult<Boolean>();
        Boolean aBoolean = userService.updatePwd(user);
        result.setData(aBoolean);
        return result;
    }

    /**
     * 用户登录
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Object login(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SSOResult<Boolean> result = new SSOResult<Boolean>();
        String token = userService.login(user.getUserName(), user.getPwd());
        if(StringUtils.isEmpty(token)) {
            // 登录失败
            result.setData(Boolean.FALSE);
            return result;
        }
        // 登录成功，保存token到Cookie
        CookieUtils.setCookie(request, response, COOKIE_NAME, token);
        result.setData(Boolean.TRUE);
        return result;
    }

    /**
     * 根据token验证用户是否登录
     * @param token
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Object queryUserByToken(@RequestParam("token") String token) throws IOException {
        SSOResult<User> result = new SSOResult<User>();
        User user = userService.queryUserByToken(token);
        result.setData(user);
        return result;
    }

}
