package com.am01.mediavault.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Am01MediavaultApigatewayApplication {

	static Logger logger = LoggerFactory.getLogger(Am01MediavaultApigatewayApplication.class);

	public static void main(String[] args) {
		logger.warn("########### Application started ########");
		SpringApplication.run(Am01MediavaultApigatewayApplication.class, args);
	}

}
