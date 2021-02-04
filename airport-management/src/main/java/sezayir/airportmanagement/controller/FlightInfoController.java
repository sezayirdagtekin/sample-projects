package sezayir.airportmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sezayir.airportmanagement.domain.FlightInformation;
import sezayir.airportmanagement.service.FlightInfoService;

@RestController
@RequestMapping("/flight-info")
public class FlightInfoController {

	@Autowired
	FlightInfoService flightInfoService;

	@RequestMapping(value = "/template/all", method = RequestMethod.GET)
	public ResponseEntity<List<FlightInformation>> findAllWithTemplate() {
		try {
			List<FlightInformation> flightInformations = flightInfoService.findAll();
			if (flightInformations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<FlightInformation>>(flightInformations, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/repository/all", method = RequestMethod.GET)
	public ResponseEntity<List<FlightInformation>> findAllWithRepository() {
		try {
			List<FlightInformation> flightInformations = flightInfoService.findAllWithRepository();
			if (flightInformations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<FlightInformation>>(flightInformations, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
