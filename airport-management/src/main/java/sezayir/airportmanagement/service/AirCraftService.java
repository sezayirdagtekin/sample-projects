package sezayir.airportmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sezayir.airportmanagement.dao.AirCraftDao;
import sezayir.airportmanagement.domain.Aircraft;
import sezayir.airportmanagement.exception.AirCraftNotFoundException;

@Service
public class AirCraftService {

	@Autowired
	private AirCraftDao dao;

	public List<Aircraft> findAll() {
		return dao.findAll();
	}

	public List<Aircraft> findByModel(String model) {

		return dao.findByModel(model);
	}

	public void deleteByAirCraftCode(String code) {
		dao.deleteByAirCraftCode(code);
	}

	public void addAirCraft(Aircraft aircraft) {
		dao.addAirCraft(aircraft);
	}

	public void updateAirCraft(Aircraft aircraft) {
		dao.updateAirCraft(aircraft);
	}

	public List<Aircraft> findByModelUsingRepostiory(String model) {
		return dao.findByModelUsingRepostiory(model);
	}

	public List<Aircraft> findByModelLike(String modelStr) {
		return dao.findByModelLike(modelStr);
	}

	public Aircraft findByCode(String code) {
		Optional<Aircraft> aircraft = dao.findByCode(code);
		if (aircraft.isPresent()) {
			return aircraft.get();
		} else {
			throw new AirCraftNotFoundException("Aircraft Not Found");
		}

	}

}
