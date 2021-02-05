package sezayir.airportmanagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sezayir.airportmanagement.domain.FlightInformation;

@Repository
public interface FlightInfoRepository  extends  MongoRepository<FlightInformation, String>{

	List<FlightInformation> findByType(String type);

}
