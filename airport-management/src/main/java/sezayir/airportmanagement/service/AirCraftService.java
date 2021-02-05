package sezayir.airportmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sezayir.airportmanagement.dao.AirCraftDao;
import sezayir.airportmanagement.domain.Aircraft;

@Service
public class AirCraftService {

	@Autowired
	private AirCraftDao dao;
	
	public List<Aircraft> findByModel(String model) {
	
		return dao.findByModel(model);
	}

}
