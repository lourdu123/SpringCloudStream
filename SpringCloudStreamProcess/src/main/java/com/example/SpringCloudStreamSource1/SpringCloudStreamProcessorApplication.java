package com.example.SpringCloudStreamSource1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class SpringCloudStreamProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamProcessorApplication.class, args);
	}
	
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Order processOrder(Order order) {
	System.out.println("Lurdhu Processing order: " + order);
	order.setName("sagar");
	return order;
	}
}
