package com.biblioteca.biblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails user = User
            .withUsername("pedro")
            .password("{noop}123")  // {noop} = sem criptografia, só para testes
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
    
}
