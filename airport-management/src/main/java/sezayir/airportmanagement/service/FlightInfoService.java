package sezayir.airportmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import sezayir.airportmanagement.dao.FlightInfoDao;
import sezayir.airportmanagement.domain.FlightInformation;

@Service
@Log
public class FlightInfoService {

	@Autowired
	FlightInfoDao dao;

	public List<FlightInformation> findAll() {

		return dao.findAll();
	}

	public List<FlightInformation> findAllWithRepository() {
		log.info("findAllWithRepository is called...");
		return dao.findAllWithRepository();
	}

}
