package ar.edu.info.unlp.bd2.etapa2.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import ar.edu.info.unlp.bd2.etapa2.model.Reservation;
import ar.edu.info.unlp.bd2.etapa2.model.User;

public class AirBdbRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	public <T> T save(T entity) {
		mongoTemplate.save(entity);
		return entity;
	}

	public User findUserByUsername(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(email));
		return (User) mongoTemplate.findOne(query, User.class);
	}

	public <T> T findById(String id, Class<T> clazz) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return (T) mongoTemplate.findOne(query, clazz);
	}

	public String getReservationsBetweenDates(String id, Date from, Date to) {
		return null;
	}

	public List<Reservation> getReservationsForProperty(String propertyId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("property.id").is(propertyId));
		return this.mongoTemplate.find(query, Reservation.class);
	}

	public void clearDb() {
		mongoTemplate.getDb().drop();
	}

}
