package com.example.HTWODBDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static sun.jvm.hotspot.code.CompressedStream.L;

@SpringBootApplication
public class HtwodbDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HtwodbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Student id 10002 -> {}", repository.findById(10002L));
		logger.info("All users 1 -> {}", repository.findAll());
		logger.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "A1234657")));
		logger.info("Update 10001 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));
		repository.deleteById(10002L);
		logger.info("Inserting -> {}", repository.insert(new Student(100120L, "Joh21n", "A121w212234657")));
		logger.info("All users 3 -> {}", repository.findAll());
	}
}
