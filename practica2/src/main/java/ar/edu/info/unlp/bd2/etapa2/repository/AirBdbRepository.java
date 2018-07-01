package ar.edu.info.unlp.bd2.etapa2.repository;

import java.util.Date;
import java.util.List;

import ar.edu.info.unlp.bd2.etapa2.utils.ReservationCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ar.edu.info.unlp.bd2.etapa2.utils.ReservationCount;
import org.springframework.data.domain.Sort;
import ar.edu.info.unlp.bd2.etapa2.model.Reservation;
import ar.edu.info.unlp.bd2.etapa2.model.City;
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

	public List<Reservation> getReservationsBetweenDates(String propertyId, Date from, Date to) {
		// ((reservation.from >= :from and reservation.from < :to) or
		// (reservation.to <= :to and reservation.to > :from))
		Query query = new Query(new Criteria().andOperator(Criteria.where("property.id").is(propertyId))
				.orOperator(Criteria.where("from").gte(from).lt(to), Criteria.where("to").lte(to).gt(from)));
		return mongoTemplate.find(query, Reservation.class);
	}

	public List<Reservation> getReservationsForProperty(String propertyId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("property.id").is(propertyId));
		return this.mongoTemplate.find(query, Reservation.class);
	}

	public List<City> getCitiesMatching(String content) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(content)).with(new Sort(Sort.Direction.ASC, "name"));
		return this.mongoTemplate.find(query, City.class);
	}

	public void clearDb() {
		mongoTemplate.getDb().drop();
	}


	public List<ReservationCount> getReservationCountByStatus() {
		TypedAggregation<Reservation> reservationAggregation =
				Aggregation.newAggregation(Reservation.class,
						Aggregation.group("status")

				);
		AggregationResults<ReservationCount> results = mongoTemplate.
				aggregate(reservationAggregation, ReservationCount.class);

		List<ReservationCount> studentResultsList = results.getMappedResults();

		return studentResultsList;
 	}

}
