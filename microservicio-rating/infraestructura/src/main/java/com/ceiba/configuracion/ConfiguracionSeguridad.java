package com.ceiba.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    private static final String ROL_ADMIN = "ADMIN";

    @Autowired
    public void configuracionGlobal1(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable()
                .authorizeRequests()
                .regexMatchers("^/ratings\\?bookId.*$").authenticated()
                .antMatchers(HttpMethod.GET, "/ratings/*").authenticated()
                .antMatchers(HttpMethod.GET, "/ratings").hasRole(ROL_ADMIN)
                .antMatchers(HttpMethod.PUT, "/ratings").hasRole(ROL_ADMIN)
                .antMatchers(HttpMethod.POST, "/ratings").hasRole(ROL_ADMIN)
                .antMatchers(HttpMethod.PATCH, "/ratings").hasRole(ROL_ADMIN)
                .antMatchers(HttpMethod.DELETE, "/ratings").hasRole(ROL_ADMIN)
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
