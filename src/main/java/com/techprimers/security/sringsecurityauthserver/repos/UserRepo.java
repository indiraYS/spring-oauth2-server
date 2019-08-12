package com.techprimers.security.sringsecurityauthserver.repos;

import com.techprimers.security.sringsecurityauthserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
