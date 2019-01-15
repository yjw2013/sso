package com.sso.dal.impl;

import com.sso.dal.UserDao;
import com.sso.domain.db.User;
import com.sso.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 用户单点登录Dao
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        return userMapper.save(user);
    }

    public int update(User user) {
        return 0;
    }

    public User selectByUserName(String userName) {
        return null;
    }
}
