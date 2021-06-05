package com.example.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.springsecurity.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // I will explain later
                .authorizeRequests()
                // must not authentication when / , index , css , js
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                // use basic auth
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        // create user 'viettq' with STUDENT role
        UserDetails anaSmithUser = User.builder()
                .username("viettq")
                .password(passwordEncoder.encode("1"))
                .roles(STUDENT.name()) // ROLE_STUDENT
                .build();
        // create user 'admin' with ADMIN role
        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("1"))
                .roles(ADMIN.name()) // role admin
                .build();

        // create user 'admin' with ADMIN role
        UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("1"))
                .roles(ADMINTRAINEE.name()) // role admintrainee
                .build();
        return new InMemoryUserDetailsManager(
                anaSmithUser,
                lindaUser,
                tomUser
        );
    }
}
