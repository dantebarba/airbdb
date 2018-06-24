package ar.edu.info.unlp.bd2.etapa2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.edu.info.unlp.bd2.etapa2.model.City;

public interface CityRepository extends MongoRepository<City, String> {

	City findByName(String name);
	
}
