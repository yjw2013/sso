package com.sso.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sso.dal.UserDao;
import com.sso.domain.db.User;
import com.sso.domain.result.SSOResult;
import com.sso.service.UserService;
import com.sso.service.redis.RedisService;
import com.sso.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * 用户单点登录Service
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisService redisService;

    /**
     * Jackson操作
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 缓存token过期时间 半个小时
     */
    private static final Integer REDIS_TIME = 60 * 30;

    public UserServiceImpl() {
        System.out.println("-------");
    }

    public SSOResult<Boolean> register(User user) {
        SSOResult<Boolean> result = new SSOResult<Boolean>();
        // 初始化处理
        Timestamp nowTime = DateTimeUtil.getNowTime();
        user.setGmtCreate(nowTime);
        user.setGmtModified(nowTime);
        return null;
    }

    public SSOResult<Boolean> updatePwd(User user) {
        return null;
    }

    public SSOResult<String> login(User user) {
        return null;
    }

    public SSOResult<User> queryUserByToken(String token) {
        return null;
    }
}
