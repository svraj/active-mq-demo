package com.tektrill.msg;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import java.util.Arrays;

@SpringBootApplication
@EnableJms
public class MsgDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgDemoApplication.class, args);
	}

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	/*@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}*/
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
		//factory.setTrustedPackages(Arrays.asList("com.my.package"));
		return factory;
	}

}
