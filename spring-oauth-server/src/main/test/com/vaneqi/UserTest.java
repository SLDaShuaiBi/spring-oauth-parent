package com.vaneqi;

import com.alibaba.fastjson.JSON;
import com.louis.spring.oauth.server.dao.UserDao;
import com.louis.spring.oauth.server.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UserTest {
    
    @Test
    public void MyTest() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
    }

    @Test
    public void user(){
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");
        System.out.println(JSON.toJSON(user));
    }
}
