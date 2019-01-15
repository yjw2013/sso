package com.sso.mapper;

import com.sso.domain.db.User;

/**
 * UserMapper
 */
public interface UserMapper {

    int save(User user);

    int update(User user);

    User selectByUserName(String userName);

}
