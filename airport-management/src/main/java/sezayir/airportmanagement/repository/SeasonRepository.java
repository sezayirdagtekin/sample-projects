package sezayir.airportmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sezayir.airportmanagement.domain.Season;

@Repository
public interface SeasonRepository extends  MongoRepository<Season, String> {
	

}
