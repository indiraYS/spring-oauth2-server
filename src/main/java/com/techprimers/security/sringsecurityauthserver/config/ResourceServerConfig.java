package com.techprimers.security.sringsecurityauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import javax.sql.DataSource;

@Order(1)
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()
                throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure (HttpSecurity http) throws  Exception {

        http.requestMatchers()
                .antMatchers("/login", "/oauth/authorize", "/user/all")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and().csrf().disable();
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth*//*.parentAuthenticationManager(authenticationManagerBean() )
                *//*.inMemoryAuthentication()
                .withUser("Peter")
                .password(passwordEncoder().encode("123"))
                .roles("USER")*/

        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("select USERNAME, 'USER' as ROLE from EMPLOYEE where USERNAME=?")
                .usersByUsernameQuery("select USERNAME, PASSWORD, 1 as enabled  from EMPLOYEE where USERNAME=?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        /*withUser("Peter")
        .password(passwordEncoder().encode("123"))
        .roles("USER");*/

        auth.inMemoryAuthentication()
                .withUser("Peter")
                .password(passwordEncoder().encode("123"))
                .roles("USER");
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
