package com.louis.spring.oauth.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	/**
	 * 自定义登录页面
	 * @return
	 */
    @GetMapping("/login")
    public String login() {
    	//return "redirect:http://localhost:8080/snow/login.html";

		return "login";
    }

}
