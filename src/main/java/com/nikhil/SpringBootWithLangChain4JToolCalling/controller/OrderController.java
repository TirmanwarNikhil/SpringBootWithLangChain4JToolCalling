package com.nikhil.SpringBootWithLangChain4JToolCalling.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.SpringBootWithLangChain4JToolCalling.service.OrderAssistantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order AI Assistant", description = "AI-powered order management APIs")
public class OrderController {

	private final OrderAssistantService orderService;

	public OrderController(OrderAssistantService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/chat")
	@Operation(summary = "Ask AI about order information")
	public Map<String, String> chat(@RequestBody Map<String, String> request) {

		String question = request.get("question");

		if (question == null || question.isBlank()) {
			throw new IllegalArgumentException("Question must not be empty");
		}

		String response = orderService.chat(question);

		return Map.of("question", question, "response", response);
	}
}
