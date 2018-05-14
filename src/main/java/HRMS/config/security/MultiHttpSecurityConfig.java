package HRMS.config.security;

import HRMS.repository.EmployeeRepository;
import HRMS.service.AdminService;
import HRMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Configuration
    @Order(1)
    public static class AdminLoginWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        @Bean
        protected UserDetailsService userDetailsService() {
            return new AdminService();
        }

//        AdminService adminService;
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/admin.html")
                    .exceptionHandling()
                        .authenticationEntryPoint(new UnauthorizedEntryPoint())
                        .and()
                    .authorizeRequests()
                        .anyRequest().hasRole("ADMIN")
                        .and()
                    .formLogin()
                        .loginPage("/login.html")
                        .loginProcessingUrl("/login/admin")
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .successHandler(new AjaxAuthSuccessHandler())
                        .failureHandler(new AjaxAuthFailHandler())
                        .permitAll()
                        .and()
                    .logout()
                        .logoutUrl("/logout.html")
                        .permitAll();
//                        .and()
//                    .userDetailsService(adminService);
        }
    }

    @Configuration
    public static class UserLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//        UserService userService;
        @Override
        @Bean
        protected UserDetailsService userDetailsService() {
            return new UserService();
        }

        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService()).passwordEncoder(new MessageDigestPasswordEncoder("MD5"));
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .exceptionHandling()
                        .authenticationEntryPoint(new UnauthorizedEntryPoint())
                        .and()
                    .csrf().disable()
                    .authorizeRequests()
                       .antMatchers("/login/**","/css/**", "/js/**","/assets/**","/fonts/**","/img/**","/404.html").permitAll()
                       .anyRequest().authenticated()
                        .and()
                    .formLogin()
                        .loginPage("/login.html")
                        .loginProcessingUrl("/login/user")
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .successHandler(new AjaxAuthSuccessHandler())
                        .failureHandler(new AjaxAuthFailHandler())
                        .permitAll()
                        .and()
                    .logout()
                        .logoutUrl("/logout.html")
                        .permitAll();
//                        .and()
//                    .userDetailsService(userService);
        }
    }

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
