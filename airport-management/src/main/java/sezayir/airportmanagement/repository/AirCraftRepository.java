package sezayir.airportmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sezayir.airportmanagement.domain.Aircraft;

@Repository
public interface AirCraftRepository extends  MongoRepository<Aircraft, String> {
	
	public List<Aircraft> findByModel(String model);

	public List<Aircraft> findByModelLike(String modelStr);

	public Optional<Aircraft> findByCode(String code);

}
