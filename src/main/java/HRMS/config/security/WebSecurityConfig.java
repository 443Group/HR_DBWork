/*
package HRMS.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .exceptionHandling()
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/LoginPage/**","/css/**", "/js/**","/fonts/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/LoginPage/login.html")
                .loginProcessingUrl("/login")
                .usernameParameter("name")
                .passwordParameter("password")
                .successHandler(new AjaxAuthSuccessHandler())
                .failureHandler(new AjaxAuthFailHandler())
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout.html")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("admin").password("admin").roles("USER");
    }
}*/
