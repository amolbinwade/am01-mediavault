package com.am01.mediavault.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@EnableWebFluxSecurity
@SpringBootApplication
public class Am01MediavaultApigatewayApplication {

	static Logger logger = LoggerFactory.getLogger(Am01MediavaultApigatewayApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Am01MediavaultApigatewayApplication.class, args);
	}

}
