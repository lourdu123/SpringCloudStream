package com.example.SpringCloudStreamSource1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@EnableBinding(Source.class)
public class SpringCloudStreamSource1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamSource1Application.class, args);
	}
	
	@Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
    public MessageSource<Order> timerMessageSource() {
		System.out.println("test");
		Order order = new Order();
		order.setId(100);
        return () -> new GenericMessage<>(order);
    }
}
