package com.example.demo.securingweb;



import com.example.demo.model.Login;
import com.example.demo.repositorys.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    private final LoginRepo loginRepo;

    public WebSecurityConfig(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/stylesheet/**", "/images/**","/", "/home", "/login", "/register", "/css/**").permitAll()
                        .requestMatchers("/ratings","ratings/submit","/Rechner/**", "/BMI/**").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")  // Ziel nach Logout
                        .permitAll()

                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Login login = loginRepo.findByName(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Benutzer nicht gefunden"));

            return new org.springframework.security.core.userdetails.User(
                    login.getName(),
                    login.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
            );
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}