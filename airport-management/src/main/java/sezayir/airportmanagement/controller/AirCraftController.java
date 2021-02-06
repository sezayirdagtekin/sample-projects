package sezayir.airportmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import sezayir.airportmanagement.domain.Aircraft;
import sezayir.airportmanagement.service.AirCraftService;

@RestController
@RequestMapping("/aircraft")
@Log4j2
public class AirCraftController {

	@Autowired
	AirCraftService service;

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

	@RequestMapping(value = "/template/delete/code", method = RequestMethod.DELETE)
	public void deleteAirCraft(@RequestBody Aircraft aircraft) {
		service.deleteByAirCraftCode(aircraft.getCode());
		log.info(aircraft.toString() + " deleted");

	}

	@RequestMapping(value = "/template/add", method = RequestMethod.POST)
	public void addAirCraft(@RequestBody Aircraft aircraft) {
		service.addAirCraft(aircraft);
		log.info(aircraft.toString() + " deleted");

	}

	@RequestMapping(value = "/template/update", method = RequestMethod.PUT)
	public void updateAirCraft(@RequestBody Aircraft aircraft) {
		service.updateAirCraft(aircraft);
		log.info(aircraft.toString() + " updated");

	}

}
