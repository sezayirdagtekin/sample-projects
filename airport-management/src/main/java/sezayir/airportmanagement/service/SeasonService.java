package sezayir.airportmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sezayir.airportmanagement.dao.SeasonDao;
import sezayir.airportmanagement.domain.Season;

@Service
public class SeasonService {

	@Autowired
	SeasonDao dao;

	public Season save(Season season) {
		return dao.save(season);
	}

}
