package com.techprimers.security.sringsecurityauthserver.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;




//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

   /* @Autowired
    AuthenticationManager authenticationManager;
*//* @Autowired
   @Qualifier("authenticationManagerBean")
   private AuthenticationManager authenticationManager;
*/
   /* @Autowired
    private BCryptPasswordEncoder passwordEncoder;
*/
/*
    @Autowired
    public AuthorizationServerConfig(DataSource dataSource,
                                     AuthenticationManager authenticationManager) {

        this.dataSource = dataSource;
        this.authenticationManager = authenticationManager;
    }*/

    //@Autowired private DataSource oauthDataSource;

    @Override
    public void configure (final AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /*@Override
    public void configure (final ClientDetailsServiceConfigurer clients) throws  Exception {
      *//*  clients.inMemory()
                .withClient("ClientId")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("user_info")
                .autoApprove(true)
                .redirectUris("http://localhost:8082/ui/login", "http://prj.local:80/g.php");*//*

        clients.jdbc(oauthDataSource())
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }*/

    //@Bean
    /*public TokenStore tokenStore() {
        return new JdbcTokenStore(oauthDataSource());
    }*/
/*
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource oauthDataSource() {
        return DataSourceBuilder.
                create().build();
    }*/

    @Autowired
    public Environment env;

    //@Primary
    /*@Bean
    public DataSource oauthDataSource() {
        System.out.println(env.getProperty("spring.datasource.jdbc-url"));
        System.out.println(env.getProperty("spring.datasource.username"));
        System.out.println(env.getProperty("spring.datasource.password"));
        System.out.println(env.getProperty("spring.datasource.driverClassName"));

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.jdbc-url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }*/


}
