package sezayir.airportmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sezayir.airportmanagement.domain.Season;
import sezayir.airportmanagement.repository.SeasonRepository;

@Component
public class SeasonDao {

	@Autowired
	private SeasonRepository repository;

	public Season save(Season season) {		
		return repository.save(season);
	}

}
