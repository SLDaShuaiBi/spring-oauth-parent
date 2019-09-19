package com.louis.spring.oauth.server.service;

import com.alibaba.fastjson.JSON;
import com.louis.spring.oauth.server.dao.UserDao;
import com.louis.spring.oauth.server.entity.MyUserPrincipal;
import com.louis.spring.oauth.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        String str = JSON.toJSONString(user);

        //return new MyUserPrincipal(user);

        List<GrantedAuthority> authorityList = new ArrayList<>();

        authorityList.add(new SimpleGrantedAuthority(str));

        //return new User(user.getUsername(),user.getPassword(),authorityList);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorityList);

    }


}
