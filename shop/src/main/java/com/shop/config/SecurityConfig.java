package com.shop.config;

import com.shop.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MemberService memberService;

    // HTTP保安設定
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // HTTP設定
        http
                .formLogin(form -> form
                    .loginPage("/members/login")
                    .defaultSuccessUrl("/")
                    .usernameParameter("email")
                    .failureUrl("/members/login/error")
                )

                .logout(logout -> logout
                        .logoutRequestMatcher((RequestMatcher) (HttpServletRequest request) ->
                                request.getRequestURI().equals("/members/logout") && request.getMethod().equals("POST")
                        )
                        .logoutSuccessUrl("/")
                );

                http.authorizeHttpRequests(requests -> requests
                        .anyRequest().permitAll() // 임시로 모든 요청 허용
                );


        return http.build();
    }

    // パスワード暗号化
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
