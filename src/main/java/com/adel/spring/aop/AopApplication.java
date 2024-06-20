package com.adel.spring.aop;

import com.adel.spring.aop.annotation.LogExecTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

@Order
@Slf4j
@SpringBootApplication
public class AopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Override
	@LogExecTime
	public void run(String... args) throws Exception {
		log.info("Start main app");

		Thread.sleep(3000);

		log.info("End main app");
	}
}
