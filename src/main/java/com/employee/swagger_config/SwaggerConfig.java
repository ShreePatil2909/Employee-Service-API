package com.employee.swagger_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openApi() {
		Contact contact = new Contact();

		contact.setEmail("shree.patil2909@gmail.com");
		contact.setName("Shree Patil");
		contact.setUrl("https://www.bezkoder.com/spring-boot-swagger-3/");

		Info info = new Info().title("Tutorial. Management API").version("1.0").contact(contact)
				.description("This API exposes endpoints to manage tutorials.");

		return new OpenAPI().info(info);
	}
}
