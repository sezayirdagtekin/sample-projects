package com.sezayir.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sezayir.demo.input.InputData;

@SpringBootApplication
@ComponentScan(basePackages = "com.sezayir")
public class HikingTourApplication implements CommandLineRunner {

	@Autowired
	InputData InputData;
	
	public static void main(String[] args) {
		SpringApplication.run(HikingTourApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		InputData.InputMenu();
		
	}

}
