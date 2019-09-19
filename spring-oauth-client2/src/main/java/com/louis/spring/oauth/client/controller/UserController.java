package com.louis.spring.oauth.client.controller;

import com.alibaba.fastjson.JSON;
import com.louis.spring.oauth.client.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/client")
    public User Oauth(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user = "";

        /*if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            //Collection<? extends GrantedAuthority> authorities = ((UserDetails) principal).getAuthorities();
        } else {
            username = principal.toString();
        }*/
        List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        for(SimpleGrantedAuthority simpleGrantedAuthority:authorities){
            user+=simpleGrantedAuthority.getAuthority()+",";
        }

        user=user.substring(0,user.length() - 1);

        User user1=JSON.parseObject(user, User.class);

        return user1;
    }




}
