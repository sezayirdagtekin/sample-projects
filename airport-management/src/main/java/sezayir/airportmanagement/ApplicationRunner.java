package sezayir.airportmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class ApplicationRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("Application started...");
	}

}
