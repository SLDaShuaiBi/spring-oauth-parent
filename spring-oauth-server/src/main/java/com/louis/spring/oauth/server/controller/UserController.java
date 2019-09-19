package com.louis.spring.oauth.server.controller;

import java.security.Principal;

import com.louis.spring.oauth.server.entity.MyUserPrincipal;
import com.louis.spring.oauth.server.entity.User;
import com.louis.spring.oauth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

	/**
	 * 资源服务器提供的受保护接口
	 * @param principal
	 * @return
	 */
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }

    @RequestMapping("/getUser")
    public User getUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        User user=null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();

        } else {
            username = principal.toString();
        }

        return userService.selectByUsername(username);

    }


}
