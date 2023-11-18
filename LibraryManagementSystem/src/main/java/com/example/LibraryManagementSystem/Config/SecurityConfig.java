package com.example.LibraryManagementSystem.Config;

import com.example.LibraryManagementSystem.Model.MyUser;
import com.example.LibraryManagementSystem.Repository.MyUserRepository;
import com.example.LibraryManagementSystem.Request.UserCreateRequest;
import com.example.LibraryManagementSystem.Service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserService myUserService;

    @Value("${users.admin.authority}")
    String adminAuthority;


    @Value("${users.student.authority}")
    String studentAuthority;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/student_for_admin/**").hasAuthority(adminAuthority)
                .antMatchers(HttpMethod.POST, "/student/**").permitAll()
                .antMatchers("/student/**", "/transaction/**").hasAuthority(studentAuthority)
                .antMatchers("/book/search/**").hasAnyAuthority(studentAuthority, adminAuthority)
                .antMatchers("/book/**").hasAnyAuthority(adminAuthority)
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }
}
