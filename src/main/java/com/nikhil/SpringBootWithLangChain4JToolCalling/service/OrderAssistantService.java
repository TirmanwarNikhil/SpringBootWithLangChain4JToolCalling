package com.nikhil.SpringBootWithLangChain4JToolCalling.service;

import org.springframework.stereotype.Service;

import com.nikhil.SpringBootWithLangChain4JToolCalling.assistant.OrderAssistant;

@Service
public class OrderAssistantService {

	private final OrderAssistant orderAssistant;

	public OrderAssistantService(OrderAssistant orderAssistant) {
		this.orderAssistant = orderAssistant;
	}

	public String chat(String question) {

		return orderAssistant.chat(question);
	}
}
