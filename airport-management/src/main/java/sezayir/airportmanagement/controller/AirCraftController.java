package sezayir.airportmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.log4j.Log4j2;
import sezayir.airportmanagement.domain.Aircraft;
import sezayir.airportmanagement.exception.AirCraftNotFoundException;
import sezayir.airportmanagement.service.AirCraftService;

@RestController
@RequestMapping("/aircraft")
@Log4j2
public class AirCraftController {

	@Autowired
	AirCraftService service;

	@GetMapping("/repository/{code}")
	public ResponseEntity<Aircraft> getAirCraftByCode(@PathVariable("code") String code) {
		try {

			Aircraft aircraft = service.findByCode(code);
			return new ResponseEntity<Aircraft>(aircraft, HttpStatus.OK);

		} catch (AirCraftNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aircraft Not Found");
		}

	}

	@RequestMapping(value = "/repository/all", method = RequestMethod.GET)
	public ResponseEntity<List<Aircraft>> findAll() {

		try {
			List<Aircraft> aircrafts = service.findAll();
			if (aircrafts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Aircraft>>(aircrafts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/template/model", method = RequestMethod.GET)
	public ResponseEntity<List<Aircraft>> findByAircraft(@RequestParam("model") String model) {

		try {
			List<Aircraft> aircrafts = service.findByModel(model);
			if (aircrafts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Aircraft>>(aircrafts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/repository/model", method = RequestMethod.GET)
	public ResponseEntity<List<Aircraft>> findByModelUsingRepostiory(@RequestParam("model") String model) {

		try {
			List<Aircraft> aircrafts = service.findByModelUsingRepostiory(model);
			if (aircrafts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Aircraft>>(aircrafts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/repository/model/like", method = RequestMethod.GET)
	public ResponseEntity<List<Aircraft>> findByModelLike(@RequestParam("model") String model) {

		try {
			List<Aircraft> aircrafts = service.findByModelLike(model);
			if (aircrafts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Aircraft>>(aircrafts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/template/delete/code", method = RequestMethod.DELETE)
	public void deleteAirCraft(@RequestBody Aircraft aircraft) {
		service.deleteByAirCraftCode(aircraft.getCode());
		log.info(aircraft.toString() + " deleted");

	}

	@RequestMapping(value = "/template/add", method = RequestMethod.POST)
	public void addAirCraft(@RequestBody Aircraft aircraft) {
		service.addAirCraft(aircraft);
		log.info(aircraft.toString() + " added");

	}

	@RequestMapping(value = "/template/update", method = RequestMethod.PUT)
	public void updateAirCraft(@RequestBody Aircraft aircraft) {
		service.updateAirCraft(aircraft);
		log.info(aircraft.toString() + " updated");

	}

}
