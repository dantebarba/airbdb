package ar.edu.info.unlp.bd2.etapa2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.edu.info.unlp.bd2.etapa2.model.City;

@Repository
public interface CityRepository extends MongoRepository<City, String> {

}
