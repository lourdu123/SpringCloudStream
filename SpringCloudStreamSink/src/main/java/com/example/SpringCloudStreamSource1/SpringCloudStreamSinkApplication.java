package com.example.SpringCloudStreamSource1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamSinkApplication.class, args);
	}
	
	@StreamListener(Sink.INPUT)
	public void processOrder(Order order) {
	System.out.println("Lurdhu Sink Processing order: " + order);
	}
}
