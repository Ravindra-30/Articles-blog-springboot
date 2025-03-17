package com.ravindra.personalblog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ArticleSecurity {

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager theDetailsManager = new JdbcUserDetailsManager(dataSource);
        theDetailsManager.setUsersByUsernameQuery("SELECT username, password, active FROM profiles WHERE username = ?");
        theDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, role FROM roles WHERE username = ?");
        return theDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/edit/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/new").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/home").permitAll()
                        .requestMatchers(HttpMethod.GET, "/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/article/**").permitAll()
                        .anyRequest()
                        .authenticated()

        ).formLogin(form -> form
                .permitAll()
        ).logout(logout -> logout.permitAll());;


        return http.build();
    }
}
