package sezayir.airportmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sezayir.airportmanagement.domain.FlightInformation;

@Repository
public interface FlightInfoRepository  extends  MongoRepository<FlightInformation, String>{

}
