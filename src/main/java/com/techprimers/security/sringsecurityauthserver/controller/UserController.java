package com.techprimers.security.sringsecurityauthserver.controller;

import java.security.Principal;

import com.techprimers.security.sringsecurityauthserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techprimers.security.sringsecurityauthserver.repos.UserRepo;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        //System.out.println(principal);
        //System.out.println(principal.getName());

        return principal;
    }

    @RequestMapping("/user/all")
    public String users() {


        Iterable<User> users = userRepo.findAll();

        System.out.print(users);

        return "Ok";
    }
}