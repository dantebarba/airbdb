package ar.edu.info.unlp.bd2.etapa2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AirBdbRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public <T> T save(T entity) {
		mongoTemplate.save(entity);
		return entity;
	}
	
	
}
