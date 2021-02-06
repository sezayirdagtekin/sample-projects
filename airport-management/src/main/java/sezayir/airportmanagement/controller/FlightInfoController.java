package sezayir.airportmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import sezayir.airportmanagement.domain.FlightInformation;
import sezayir.airportmanagement.service.FlightInfoService;

@RestController
@RequestMapping("/flight-info")
@Log4j2
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

	@RequestMapping(value = "/page/all", method = RequestMethod.GET)
	public List<FlightInformation> findAll(@RequestParam(required = false, name = "field") String field,
			@RequestParam(required = false, name = "pageNb") int pageNb,
			@RequestParam(required = false, name = "pageSize") int pageSize) {
		return flightInfoService.findAll(field, pageNb, pageSize);
	}

	@RequestMapping(value = "/template/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<FlightInformation> findById(@PathVariable("id") String id) {

		try {
			FlightInformation flightInformation = flightInfoService.findById(id);
			if (flightInformation == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<FlightInformation>(flightInformation, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/repository/type/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<FlightInformation>> findByType(@PathVariable("type") String type) {

		try {
			List<FlightInformation> flightInformations = flightInfoService.findByType(type);
			if (flightInformations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<FlightInformation>>(flightInformations, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/template/relatedcities", method = RequestMethod.GET)
	public ResponseEntity<List<FlightInformation>> findRelatedToCityAndNotDelayed(
			@RequestParam("departure") String departure, @RequestParam("destination") String destination,
			@RequestParam("delay") boolean delay) {

		try {
			List<FlightInformation> flightInformations = flightInfoService.findRelatedToCityAndNotDelayed(departure,
					destination, delay);
			if (flightInformations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<FlightInformation>>(flightInformations, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/template/freetext/{text}", method = RequestMethod.GET)
	public ResponseEntity<List<FlightInformation>> findByFreeText(@PathVariable("text") String text) {

		try {
			List<FlightInformation> flightInformations = flightInfoService.findByFreeText(text);
			if (flightInformations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<FlightInformation>>(flightInformations, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/template/add", method = RequestMethod.POST)
	public void addFlightInformation(@RequestBody FlightInformation flightInformation) {
		flightInfoService.addFlightInformation(flightInformation);
		log.info(flightInformation.toString() + " added");

	}

	@RequestMapping(value = "/template/delete", method = RequestMethod.DELETE)
	public void deleteFlightInformation(@RequestBody FlightInformation flightInformation) {
		flightInfoService.deleteFlightInformation(flightInformation);
		log.info(flightInformation.toString() + " deleted");

	}

}
