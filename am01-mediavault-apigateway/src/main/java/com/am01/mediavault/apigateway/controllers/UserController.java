package com.am01.mediavault.apigateway.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @GetMapping("/me")
    public Mono<String> me(@AuthenticationPrincipal Jwt jwt) {
        return Mono.just(jwt.getClaim("email"));
    }

    @GetMapping("/username")
    public Mono<String> username(Authentication authentication) {
        return Mono.just(authentication.getName()); // returns email
    }

}
