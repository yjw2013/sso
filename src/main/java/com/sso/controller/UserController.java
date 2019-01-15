package com.sso.controller;

import com.sso.domain.db.User;
import com.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        return null;
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updatePwd(@RequestBody User user) {

        return null;
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
    public Object login(User user, HttpServletRequest request, HttpServletResponse response) {

        return null;
    }

    /**
     * 根据token验证用户是否登录
     * @param token
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Object queryUserByToken(@RequestParam("token") String token) {

        return null;
    }

}
