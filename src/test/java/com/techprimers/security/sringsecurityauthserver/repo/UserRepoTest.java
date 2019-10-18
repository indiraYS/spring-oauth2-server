package com.techprimers.security.sringsecurityauthserver.repo;

import com.techprimers.security.sringsecurityauthserver.SringSecurityAuthServerApplication;
import com.techprimers.security.sringsecurityauthserver.entity.User;
import com.techprimers.security.sringsecurityauthserver.repos.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SringSecurityAuthServerApplication.class)
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void users() {
        System.out.println("ok");
        List<User> usrL =  userRepo.findAll();

          assertNotEquals(usrL.size(),0);
    }
}