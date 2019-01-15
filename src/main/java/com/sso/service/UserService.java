package com.sso.service;

import com.sso.domain.db.User;
import com.sso.domain.result.SSOResult;

/**
 * 用户Service接口
 */
public interface UserService {

    /**
     * 注册
     * @param user
     * @return
     */
    SSOResult<Boolean> register(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    SSOResult<Boolean> updatePwd(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    SSOResult<String> login(User user);

    /**
     * 根据token查询User
     * @param token
     * @return
     */
    SSOResult<User> queryUserByToken(String token);

}
