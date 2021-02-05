package sezayir.airportmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sezayir.airportmanagement.domain.Aircraft;
import sezayir.airportmanagement.service.AirCraftService;

@RestController
@RequestMapping("/aircraft")
public class AirCraftController {

	@Autowired
	AirCraftService service;


	@RequestMapping(value = "/template/model", method = RequestMethod.GET)
	public ResponseEntity<List<Aircraft>> findByAircraft(@RequestParam("model") String model) {

		try {
			List<Aircraft> aircrafts = service.findByModel(model);
			if(aircrafts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Aircraft>>(aircrafts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
