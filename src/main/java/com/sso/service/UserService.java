package com.sso.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sso.domain.db.User;
import com.sso.domain.result.SSOResult;

import java.io.IOException;

/**
 * 用户Service接口
 */
public interface UserService {

    /**
     * 注册
     * @param user
     * @return
     */
    Boolean register(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    Boolean updatePwd(User user);

    /**
     * 用户登录
     * @param userName
     * @param pwd
     * @return
     */
    String login(String userName, String pwd) throws JsonProcessingException;

    /**
     * 根据token查询User
     * @param token
     * @return
     */
    User queryUserByToken(String token) throws IOException;

}
