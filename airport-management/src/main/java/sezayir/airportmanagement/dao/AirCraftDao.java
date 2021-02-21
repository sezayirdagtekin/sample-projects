package sezayir.airportmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import sezayir.airportmanagement.domain.Aircraft;
import sezayir.airportmanagement.repository.AirCraftRepository;

@Component
public class AirCraftDao {

	@Autowired
	private MongoTemplate template;
	
	@Autowired
	private AirCraftRepository repository;

	public List<Aircraft> findByModel(String model) {
		Query query = new Query();
		query.addCriteria(Criteria.where("model").is(model));

		return template.find(query, Aircraft.class);
	}
	
	public List<Aircraft> findByModelUsingRepostiory(String model) {
		return repository.findByModel(model);
	}

	public void deleteAirCraft(Aircraft aircraft) {
		template.remove(aircraft);
	}

	public void deleteByAirCraftCode(String code) {
		Query query = new Query();
		query.addCriteria(Criteria.where("code").is(code));
		template.remove(query, Aircraft.class);
		;
	}

	public void addAirCraft(Aircraft aircraft) {
		template.insert(aircraft);
	}
	
	public void updateAirCraft(Aircraft aircraft) {
		Query query= new Query();
		query.addCriteria(Criteria.where("code").is(aircraft.getCode()));
		Update update= new Update();
		update.set("nbSeats", aircraft.getNbSeats());
		update.set("capacity", aircraft.getCapacity());
		template.updateFirst(query, update, Aircraft.class);
	}

	public List<Aircraft> findByModelLike(String modelStr) {
		return repository.findByModelLike(modelStr);
	}

	public List<Aircraft> findAll() {
		return repository.findAll();
	}

	

	public Optional<Aircraft> findByCode(String code) {
		return repository.findByCode(code);
	}
}
