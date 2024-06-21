package com.adel.spring.aop;

import com.adel.spring.aop.annotation.LogExecTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Order
@Slf4j
@EnableAsync
@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication implements CommandLineRunner {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		CompletableFuture.runAsync(() -> {
			SpringApplication.run(AopApplication.class, args);
//		}).orTimeout(5, TimeUnit.SECONDS).get();
	}

	@Override
	@LogExecTime
	public void run(String... args) throws Exception {
		log.info("Start main app");

		Thread.sleep(10000);

		log.info("End main app");
	}
}
