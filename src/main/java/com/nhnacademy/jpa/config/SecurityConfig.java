package com.nhnacademy.jpa.config;

import com.nhnacademy.jpa.LoginFailureHandler;
import com.nhnacademy.jpa.LoginSuccessHandler;
import com.nhnacademy.jpa.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
            .and()
            .formLogin()
            .usernameParameter("id")
            .passwordParameter("pwd")
            .loginPage("/resident/login")
            .loginProcessingUrl("/login")
            .successHandler(new LoginSuccessHandler())
            .failureHandler(new LoginFailureHandler())
            .and()
            .logout()
            .and()
            .csrf()
            .and();
            // .sessionManagement()
            // .sessionFixation()
            // .none()
            // .and()
            // .headers()
            // .defaultsDisabled()
            // .frameOptions().sameOrigin()
            // .and()
            // .exceptionHandling()
            // .accessDeniedPage("/error/403")
            // .and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider(null));
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
        CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }

}