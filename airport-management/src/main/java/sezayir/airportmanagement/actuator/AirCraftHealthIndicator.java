package sezayir.airportmanagement.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import sezayir.airportmanagement.controller.AirCraftController;

@Component
public class AirCraftHealthIndicator implements HealthIndicator {

	@Autowired
	private AirCraftController controller;

	private final String message_key = "AircraftService";

	@Override
	public Health health() {

		if (!isRunningAircraftService()) {
			return Health.down().withDetail(message_key, "Not Available").build();
		}
		return Health.up().withDetail(message_key, "Available").build();
	}

	private Boolean isRunningAircraftService() {
		if (controller.findAll().getStatusCode().equals(HttpStatus.OK))
			return true;
		
		return false;
	}

}
