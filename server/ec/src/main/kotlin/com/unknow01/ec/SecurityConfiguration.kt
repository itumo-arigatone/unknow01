package com.unknow01.ec
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
class SecurityConfiguration: WebSecurityConfigurerAdapter() {
    override protected fun configure (http: HttpSecurity) {
        http.authorizeRequests().antMatchers("/").permitAll();
        http.csrf().ignoringAntMatchers("/user/create_user");
    }
}