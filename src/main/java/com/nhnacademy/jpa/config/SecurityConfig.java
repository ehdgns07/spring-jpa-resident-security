package com.nhnacademy.jpa.config;

import com.nhnacademy.jpa.handler.LoginFailureHandler;
import com.nhnacademy.jpa.handler.LoginSuccessHandler;
import com.nhnacademy.jpa.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/resident").hasAnyAuthority("ROLE_ADMIN", "ROLE_MEMBER")
            .antMatchers("/relationship").hasAnyAuthority("ROLE_ADMIN", "ROLE_MEMBER")
            .anyRequest().permitAll()
            .and()
            .formLogin()
                .usernameParameter("id")
                .passwordParameter("pwd")
                .loginPage("/resident/login")
                .loginProcessingUrl("/login")
                .successHandler(new LoginSuccessHandler(null))
                .failureHandler(new LoginFailureHandler())
            .and()
            // .oauth2Login()
            // .successHandler(new LoginSuccessHandler(null))
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

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(RedisTemplate<String, String> redisTemplate) {
        return new LoginSuccessHandler(redisTemplate);
    }
}
