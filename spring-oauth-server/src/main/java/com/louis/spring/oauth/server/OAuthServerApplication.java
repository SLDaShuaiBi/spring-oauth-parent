package com.louis.spring.oauth.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@MapperScan("com.louis.spring.oauth.server.dao")
public class OAuthServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OAuthServerApplication.class, args);
    }
}