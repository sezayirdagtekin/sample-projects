package sezayir.airportmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import sezayir.airportmanagement.domain.FlightInformation;
import sezayir.airportmanagement.repository.FlightInfoRepository;

@Component
public class FlightInfoDao {

	@Autowired
	private MongoTemplate template;

	@Autowired
	private FlightInfoRepository repository;

	public List<FlightInformation> findAll() {
		return template.findAll(FlightInformation.class);
	}

	public List<FlightInformation> findAllWithRepository() {
		return repository.findAll();
	}

}
