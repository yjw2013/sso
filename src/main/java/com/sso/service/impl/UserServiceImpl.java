package com.sso.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sso.dal.UserDao;
import com.sso.domain.db.User;
import com.sso.domain.result.SSOResult;
import com.sso.service.UserService;
import com.sso.service.redis.RedisService;
import com.sso.util.DateTimeUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * 用户单点登录Service
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String TOKEN = "TOKEN_";

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

    public Boolean register(User user) {
        Timestamp nowTime = DateTimeUtil.getNowTime();
        user.setGmtCreate(nowTime);
        user.setGmtModified(nowTime);
        user.setPwd(DigestUtils.md5Hex(user.getPwd()));
        int save = userDao.save(user);
        return save == 1;
    }

    public Boolean updatePwd(User user) {
        SSOResult<Boolean> result = new SSOResult<Boolean>();
        user.setGmtModified(DateTimeUtil.getNowTime());
        int update = userDao.update(user);
        return update == 1;
    }

    public String login(String userName, String pwd) throws JsonProcessingException {
        // 先查询用户是否存在，如果不存在直接return一个null
        User user = userDao.selectByUserName(userName);
        // 用户不存在
        if(null == user) {
            return null;
        }
        // 如果密码不正确
        if(!StringUtils.equals(DigestUtils.md5Hex(pwd), user.getPwd())) {
            return null;
        }
        // 登录成功，将用户信息保存在Redis中
        String token = DigestUtils.md5Hex(userName + System.currentTimeMillis());
        redisService.set(TOKEN + token, MAPPER.writeValueAsString(user), REDIS_TIME);
        return token;
    }

    public User queryUserByToken(String token) throws IOException {
        String key = TOKEN + token;
        // 从缓存中获取用户的数据
        String jsonData = redisService.get(key);
        if(StringUtils.isEmpty(jsonData)) {
            // 登录超时
            return null;
        }
        // 重新设置redis中的生存时间
        redisService.expire(key, REDIS_TIME);
        return MAPPER.readValue(jsonData, User.class);
    }
}
