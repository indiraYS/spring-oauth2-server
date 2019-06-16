package com.techprimers.security.sringsecurityauthserver;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        //System.out.println(principal);
        //System.out.println(principal.getName());

        return principal;
    }
}