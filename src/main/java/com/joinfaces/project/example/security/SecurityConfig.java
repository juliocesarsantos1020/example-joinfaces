package com.joinfaces.project.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.csrf().disable();
            http
                    .userDetailsService(userDetailsService())
                    .authorizeRequests()
                    .antMatchers("/javax.faces.resource/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login.xhtml")
                    .permitAll()
                    .failureUrl("/login.xhtml?error=true")
                    .defaultSuccessUrl("/person.xhtml")
                    .and()
                    .authorizeRequests()
                    .and()
                    .logout()
                    .logoutSuccessUrl("/login.xhtml");
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager result = new InMemoryUserDetailsManager();
        result.createUser(User.withDefaultPasswordEncoder().username("persapiens").password("123").authorities("ROLE_ADMIN").build());
        result.createUser(User.withDefaultPasswordEncoder().username("nyilmaz").password("qwe").authorities("ROLE_USER").build());
        result.createUser(User.withDefaultPasswordEncoder().username("julio").password("456").authorities("ROLE_USER").build());
        return result;
    }
}