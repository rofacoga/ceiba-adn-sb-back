package com.ceiba.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
                .antMatchers(HttpMethod.GET, "/books").permitAll()
                .antMatchers(HttpMethod.GET, "/books/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/books").hasRole(ROL_ADMIN)
                .antMatchers(HttpMethod.POST, "/books").hasRole(ROL_ADMIN)
                .antMatchers(HttpMethod.PATCH, "/books").hasRole(ROL_ADMIN)
                .antMatchers(HttpMethod.DELETE, "/books").hasRole(ROL_ADMIN)
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }


/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // ...
        http.oauth2Login();
        // ...

        return http.build();
    }

    @Bean
    public RestOperations restTemplate(OAuth2AuthorizedClientService clientService) {
        return new RestTemplateBuilder().interceptors(
                (ClientHttpRequestInterceptor) (httpRequest, bytes, execution) -> {
                    OAuth2AuthenticationToken token = OAuth2AuthenticationToken.class.cast(SecurityContextHolder.getContext().getAuthentication());
                    OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
                    httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
                    return execution.execute(httpRequest, bytes);
                }).build();
    }
 */
}
