package com.vaneqi;

import com.louis.spring.oauth.server.dao.UserDao;
import com.louis.spring.oauth.server.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;




public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void MyTest() {

        User user = userDao.selectByUsername("zhangsan");
        System.out.println(user.getUsername());
    }
}
