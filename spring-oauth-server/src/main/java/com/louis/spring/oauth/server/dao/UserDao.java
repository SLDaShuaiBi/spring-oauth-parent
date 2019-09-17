package com.louis.spring.oauth.server.dao;

import com.louis.spring.oauth.server.entity.User;

public interface UserDao {

    User selectByUsername(String username);

}
