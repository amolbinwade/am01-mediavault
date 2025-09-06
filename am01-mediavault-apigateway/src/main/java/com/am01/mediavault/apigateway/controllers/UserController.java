package com.am01.mediavault.apigateway.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/me")
    public Mono<Map<String, String>> me(@AuthenticationPrincipal Jwt jwt) {
        String username = jwt.getClaim("email");
        logger.debug("Retrieved email/username: {} ", username);
        return Mono.just(Map.of("username", username));
    }

    @GetMapping("/username")
    public Mono<Map<String, String>> username(Authentication authentication) {
        String firstName = authentication.getName();
        logger.debug("Retrieved First Name: {} ", firstName);
        return Mono.just(Map.of("username", firstName));
    }

}
