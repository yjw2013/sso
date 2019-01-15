package com.sso.test.service;

import com.sso.domain.db.User;
import com.sso.service.UserService;
import com.sso.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        User user = new User();
        user.setUserName("yujiwei");
        user.setPwd("as3853092");
        user.setEmail("774346810@qq.com");
        user.setPhone("18070291816");
        userService.register(user);
    }

}
