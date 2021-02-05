package sezayir.airportmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

}
