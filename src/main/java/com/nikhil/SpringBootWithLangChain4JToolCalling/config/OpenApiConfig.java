package com.nikhil.SpringBootWithLangChain4JToolCalling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Spring Boot LangChain4j API").version("1.0.0")
				.description("REST APIs for testing LangChain4j and OpenAI integration"));
	}
}