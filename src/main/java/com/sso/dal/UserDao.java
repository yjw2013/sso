package com.sso.dal;

import com.sso.domain.db.User;

/**
 * 单点登录DAO
 */
public interface UserDao {

    int save(User user);

    int update(User user);

    User selectByUserName(String userName);

}
