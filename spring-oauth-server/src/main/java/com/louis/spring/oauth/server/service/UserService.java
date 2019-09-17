package com.louis.spring.oauth.server.service;

import com.louis.spring.oauth.server.dao.UserDao;
import com.louis.spring.oauth.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User selectByUsername(String username){
        User user = userDao.selectByUsername(username);

        if (user!=null){
            return user;
        }else{
            user.setUsername("null");
            return user;
        }

    }
}
