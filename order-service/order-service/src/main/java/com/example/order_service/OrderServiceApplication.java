package com.example.order_service;

import io.pyroscope.http.Format;
import io.pyroscope.javaagent.EventType;
import io.pyroscope.javaagent.PyroscopeAgent;
import io.pyroscope.javaagent.config.Config;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Start initialize pyroscope serve");
		PyroscopeAgent.start(
				new Config.Builder()
						.setApplicationName("order-app-java")
						.setProfilingEvent(EventType.ITIMER)
						.setFormat(Format.JFR)
						.setServerAddress("http://pyroscope:4040")
						// Optionally, if authentication is enabled, specify the API key.
						// .setBasicAuthUser("<User>")
						// .setBasicAuthPassword("<Password>")
						// Optionally, if you'd like to set allocation threshold to register events, in bytes. '0' registers all events
						// .setProfilingAlloc("0")
						.build()
		);
	}
}
