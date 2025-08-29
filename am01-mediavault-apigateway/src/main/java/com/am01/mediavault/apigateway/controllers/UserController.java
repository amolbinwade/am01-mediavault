package com.am01.mediavault.apigateway.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/me")
    public Mono<Map<String, String>> me(@AuthenticationPrincipal Jwt jwt) {
        return Mono.just(Map.of("username", jwt.getClaim("email")));
    }

    // returns { "username": "email@example.com" }
    @GetMapping("/username")
    public Mono<Map<String, String>> username(Authentication authentication) {
        return Mono.just(Map.of("username", authentication.getName()));
    }

}
