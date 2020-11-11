package com.iabur.bs23.travel.config.security;

import com.iabur.bs23.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserService userService;

    @Autowired
    public WebSecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();


        http
                .authorizeRequests()
                .antMatchers("/img/**","/css/**", "/js/**", "/bootstrap/**", "/fonts/**","/registration/**")
                .permitAll()

                .and()
                .authorizeRequests()
                .antMatchers("/registration")
                .permitAll()
                .anyRequest()
                .authenticated()


                .and()
                .formLogin()
                .loginPage("/login") // Login page will be accessed through this endpoint. We will create a controller method for this.
                .loginProcessingUrl("/login-processing") // This endpoint will be mapped internally. This URL will be our Login form post action.
                .permitAll() //permitting all for login page
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/") // If the login is successful, user will be redirected to this URL.
                .failureUrl("/login?error=true") // If the user fails to login, application will redirect the user to this endpoint
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

    }
}
