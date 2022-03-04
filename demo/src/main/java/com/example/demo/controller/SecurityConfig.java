package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) {
        try {
            builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            System.out.println(e);
        }

    }



    //Al concepto de agregar usuarios se le conoce como autorizacion
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/editar/**", "/eliminar/**", "/agregar/**")
                    .hasRole("ADMIN")
                .antMatchers("/")
                    .hasAnyRole("USER", "ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errors/403")
                ;

    }
}
