package HRMS.config.security;

import HRMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Configuration
    @Order(2)
    public static class UserLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//        UserService userService;
        @Autowired
        private UserService userService;

        @Bean
        public BCryptPasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .exceptionHandling()
                        .authenticationEntryPoint(new UnauthorizedEntryPoint())
                        .and()
                    .csrf().disable()
                    .authorizeRequests()
                       .antMatchers("/css/**", "/js/**","/assets/**","/fonts/**","/img/**","/404.html").permitAll()
                       .antMatchers("/admin*").hasRole("ADMIN")
                       .anyRequest().authenticated()
                       .and()
                    .formLogin()
                    .loginPage("/login.html")
                    .loginProcessingUrl("/login")
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .successHandler(new AjaxAuthSuccessHandler())
                        .failureHandler(new AjaxAuthFailHandler())
                        .permitAll()
                        .and()
                    .logout()
                        .logoutUrl("/logout")
                        .permitAll();
//                        .and()
//                    .userDetailsService(new UserService());
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService);//配置自定义userDetailService
        }
    }

/*
    @Configuration
    public static class BaseWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .exceptionHandling()
                    .authenticationEntryPoint(new UnauthorizedEntryPoint())
                    .and()
                    .authorizeRequests()
                    .antMatchers("/css/**", "/js/**", "/assets/**", "/fonts/**", "/img/**", "/404.html").permitAll()
                    .anyRequest().authenticated();
        }
    }
*/

/*
    @Configuration
    public static class UserLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin();
        }
    }
*/
/*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN").and()
                .withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER");
    }*/
}
