package com.am01.mediavault.apigateway.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;

import org.springframework.security.config.web.server.ServerHttpSecurity;

import org.springframework.security.web.server.SecurityWebFilterChain;

/***
 * Configuration class for Spring Security
 * @author : Amol Binwade
 */

@Configuration
public class SecurityConfig {

  /* Commenting this Bean for now as Oauth2 working without this
    @Bean
    SecurityWebFilterChain defaultSecurityFilterChain(ServerHttpSecurity http) throws Exception {

        http.authorizeExchange(
                authorize -> authorize.anyExchange().authenticated()
        ).oauth2Login(Customizer.withDefaults());
        return http.build();
    }*/

}
