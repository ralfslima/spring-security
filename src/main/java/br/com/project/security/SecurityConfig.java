package br.com.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        
        http
            .httpBasic()
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .csrf()
            .disable();

        return http.build();
    }

 



    // @Bean
    // public UserDetailsService users() {
    //     UserDetails admin = User.builder()
    //         .username("ralf")
    //         .password(passwordEncoder().encode("123"))
    //         .roles("ADMIN")
    //         .build();

    //     UserDetails user = User.builder()
    //         .username("larissa")
    //         .password(passwordEncoder().encode("abc"))
    //         .roles("USER")
    //         .build();

    //     return new InMemoryUserDetailsManager(admin, user);
    // }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
