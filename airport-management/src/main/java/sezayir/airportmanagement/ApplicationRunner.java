package sezayir.airportmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import sezayir.airportmanagement.domain.FlightInformation;

@Component
@Log
public class ApplicationRunner implements CommandLineRunner {

	private MongoTemplate template;

	ApplicationRunner(MongoTemplate template) {
		this.template = template;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application started...");
/*
		FlightInformation flight = new FlightInformation();
		template.save(flight);
		log.info("FlightInformation saved...");
*/
	}

}
