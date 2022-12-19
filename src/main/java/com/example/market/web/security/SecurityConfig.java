package com.example.market.web.security;

import com.example.market.domain.service.MarketUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import static org.springframework.security.config.Customizer.withDefaults;

public class SecurityConfig{

    @Autowired
    private MarketUserDetailService marketUserDetailService;

    @Bean
    public HttpSecurity filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic(withDefaults());
        return http.userDetailsService(marketUserDetailService);
    }

}
