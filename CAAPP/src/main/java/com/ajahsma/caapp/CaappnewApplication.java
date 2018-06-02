package com.ajahsma.caapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CaappnewApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(CaappnewApplication.class, args);
	}
}
