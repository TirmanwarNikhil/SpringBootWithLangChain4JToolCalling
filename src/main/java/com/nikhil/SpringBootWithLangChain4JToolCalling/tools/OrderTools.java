package com.nikhil.SpringBootWithLangChain4JToolCalling.tools;

import org.springframework.stereotype.Component;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.P;

import java.util.Map;

@Component
public class OrderTools {

	private final Map<String, String> orders = Map.of("ORD1001",
			"Order ID: ORD1001, Product: Laptop, " + "Status: SHIPPED, Expected Delivery: 20-Nov-2026",

			"ORD1002",
			"Order ID: ORD1002, Product: Mobile Phone, " + "Status: PROCESSING, Expected Delivery: 23-Nov-2026",

			"ORD1003", "Order ID: ORD1003, Product: Headphones, " + "Status: DELIVERED, Delivered On: 15-Nov-2026");

	@Tool("Get the current shipping status and expected delivery of an order using its order ID")
	public String getOrderStatus(@P("Customer order ID, for example ORD1001") String orderId) {

		System.out.println("TOOL EXECUTED: getOrderStatus");

		String order = orders.get(orderId);

		if (order == null) {
			return "Order not found for ID: " + orderId;
		}

		return order;
	}

	@Tool("Get complete available information about a customer's order using its order ID")
	public String getOrderDetails(@P("Customer order ID, for example ORD1001") String orderId) {

		System.out.println("TOOL EXECUTED: getOrderDetails");

		String order = orders.get(orderId);

		if (order == null) {
			return "Order not found for ID: " + orderId;
		}

		return "Complete Order Details: " + order;
	}
}