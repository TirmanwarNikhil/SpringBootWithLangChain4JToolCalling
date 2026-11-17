package com.nikhil.SpringBootWithLangChain4JToolCalling.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nikhil.SpringBootWithLangChain4JToolCalling.assistant.OrderAssistant;
import com.nikhil.SpringBootWithLangChain4JToolCalling.tools.OrderTools;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class AiConfig {

	@Value("${app.ai.openai.api-key}")
	private String apiKey;

	@Value("${app.ai.openai.model-name}")
	private String modelName;

	@Value("${app.ai.openai.temperature}")
	private double temperature;

	@Bean
	public ChatModel chatModel() {

		return OpenAiChatModel.builder().apiKey(apiKey).modelName(modelName).temperature(temperature).build();
	}

	@Bean
	public OrderAssistant orderAssistant(ChatModel chatModel, OrderTools orderTools) {

		return AiServices.builder(OrderAssistant.class).chatModel(chatModel).tools(orderTools).build();
	}
}
