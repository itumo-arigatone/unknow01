package com.unknow01.ec;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.unknow01.ec.login.SimpleAuthenticationEntryPoint;
import com.unknow01.ec.login.SimpleAccessDeniedHandler;
import com.unknow01.ec.login.SimpleAuthenticationSuccessHandler;
import com.unknow01.ec.login.SimpleAuthenticationFailureHandler;
import com.unknow01.ec.login.SimpleUserDetailsService;
import com.unknow01.ec.user.UserRepository;

@EnableWebSecurity
class SecurityConfiguration: WebSecurityConfigurerAdapter {
    val userRepository: UserRepository;
    @Autowired
    constructor(userRepository: UserRepository){
        this.userRepository = userRepository
    }
    override protected fun configure (http: HttpSecurity) {
        http
        .authorizeRequests()
            .mvcMatchers("/prelogin", "/hello")
                .permitAll()
            .mvcMatchers("/user/**")
                .hasRole("USER")
            .mvcMatchers("/admin/**")
                .hasRole("ADMIN")
            .anyRequest()
                .authenticated()
        .and()
        // EXCEPTION
        .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint())
            .accessDeniedHandler(accessDeniedHandler())
        .and()
        // LOGIN
        .formLogin()
            .loginProcessingUrl("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
            .successHandler(authenticationSuccessHandler())
            .failureHandler(authenticationFailureHandler())
        .and()
        // LOGOUT
        .logout()
            .logoutUrl("/logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .logoutSuccessHandler(logoutSuccessHandler())
            //.addLogoutHandler(new CookieClearingLogoutHandler())
        .and()
        // CSRF
        .csrf()
            //.disable()
            .ignoringAntMatchers("/login")
            .csrfTokenRepository(CookieCsrfTokenRepository())
        ;
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.eraseCredentials(true)
            .userDetailsService(SimpleUserDetailsService(userRepository))
            .passwordEncoder(BCryptPasswordEncoder());
    }

    fun authenticationEntryPoint(): AuthenticationEntryPoint {
        return SimpleAuthenticationEntryPoint();
    }

    fun accessDeniedHandler(): AccessDeniedHandler {
        return SimpleAccessDeniedHandler();
    }

    fun authenticationSuccessHandler(): AuthenticationSuccessHandler {
        return SimpleAuthenticationSuccessHandler();
    }

    fun authenticationFailureHandler(): AuthenticationFailureHandler {
        return SimpleAuthenticationFailureHandler();
    }

    fun logoutSuccessHandler(): LogoutSuccessHandler {
        return HttpStatusReturningLogoutSuccessHandler();
    }
}