package com.nott.nettychat.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.nott.nettychat"})
@SpringBootApplication
public class NettychatApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettychatApplication.class, args);
	}

}
