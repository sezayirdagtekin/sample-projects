package sezayir.airportmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import sezayir.airportmanagement.domain.Aircraft;

@Component
public class AirCraftDao {

	@Autowired
	private MongoTemplate template;

	public List<Aircraft> findByModel(String model) {
		Query query = new Query();
		query.addCriteria(Criteria.where("model").is(model));

		return template.find(query, Aircraft.class);
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

}
