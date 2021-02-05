package sezayir.airportmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import sezayir.airportmanagement.domain.FlightInformation;
import sezayir.airportmanagement.repository.FlightInfoRepository;

@Component
@Log
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

	public List<FlightInformation> findAll(String field, int pageNb, int pageSize) {
		log.info("paramaters pageNb=" + pageNb + " pageSize=" + pageSize + " Sorting field=" + field);
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, field)).with(PageRequest.of(pageNb, pageSize));
		return template.find(query, FlightInformation.class);
	}

	public FlightInformation findById(String id) {
		return template.findById(id, FlightInformation.class);
	}

	public List<FlightInformation> findByType(String type) {
		return repository.findByType(type);
	}

	public List<FlightInformation> findRelatedToCityAndNotDelayed(String departure, String destination, boolean delay) {

		Criteria criteria = new Criteria();
		criteria.orOperator(Criteria.where("departure.city").is(departure),
				Criteria.where("destination.city").is(destination));
		criteria.andOperator(Criteria.where("delayed").is(false));
		Query query = new Query(criteria);

		return template.find(query, FlightInformation.class);
	}

	public List<FlightInformation> findByFreeText(String text) {

		TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(text);

		Query query = TextQuery.query(textCriteria);

		return template.find(query, FlightInformation.class);
	}

}
