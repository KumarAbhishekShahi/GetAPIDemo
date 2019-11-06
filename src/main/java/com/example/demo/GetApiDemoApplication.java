package com.example.demo;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class GetApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetApiDemoApplication.class, args);
	}
	
   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }

	@RequestMapping(value = "/user")
   public Principal user(Principal principal) {
      return principal;
   }
	
	@RequestMapping(value = "/")
   public String success() {
      return "APP Engine deployment success";
   }

}
