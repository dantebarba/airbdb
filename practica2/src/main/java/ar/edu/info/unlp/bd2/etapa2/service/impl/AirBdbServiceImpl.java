package ar.edu.info.unlp.bd2.etapa2.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.Assert;

import ar.edu.info.unlp.bd2.etapa2.model.City;
import ar.edu.info.unlp.bd2.etapa2.model.Property;
import ar.edu.info.unlp.bd2.etapa2.model.RepeatedUsernameException;
import ar.edu.info.unlp.bd2.etapa2.model.Reservation;
import ar.edu.info.unlp.bd2.etapa2.model.ReservationException;
import ar.edu.info.unlp.bd2.etapa2.model.ReservationStatus;
import ar.edu.info.unlp.bd2.etapa2.model.User;
import ar.edu.info.unlp.bd2.etapa2.repository.AirBdbRepository;
import ar.edu.info.unlp.bd2.etapa2.repository.CityRepository;
import ar.edu.info.unlp.bd2.etapa2.service.AirBdbService;
import ar.edu.info.unlp.bd2.etapa2.utils.ReservationCount;

public class AirBdbServiceImpl implements AirBdbService {

	private AirBdbRepository repository = null;

	@Autowired
	CityRepository cityRepository;

	public AirBdbServiceImpl(AirBdbRepository repository) {
		this.repository = repository;
	}

	@Override
	public User createUser(String username, String name) throws RepeatedUsernameException {

		if (this.getUserByUsername(username) != null)
			throw new RepeatedUsernameException();

		return this.repository.save(User.create(username, name));
	}

	@Override
	public User getUserByUsername(String email) {
		return this.repository.findUserByUsername(email);
	}

	@Override
	public Property createProperty(String name, String description, double price, int capacity, int rooms,
			String cityName) {
		return this.repository.<Property>save(
				new Property().create(name, description, price, capacity, rooms, this.registerCity(cityName)));
	}

	@Override
	public void clearDb() {
		this.repository.clearDb();
	}

	@Override
	public Reservation createReservation(String propertyId, String userId, Date from, Date to,
			ReservationStatus initialStatus) throws ReservationException {

		User user = this.getUserById(userId);

		Assert.notNull(user, "User not found");

		Property property = this.repository.findById(propertyId, Property.class);

		Assert.notNull(property, "Property not found");

		if (!this.isPropertyAvailable(propertyId, from, to))
			throw new ReservationException();

		Reservation savedEntity = this.repository.save(new Reservation().create(property, user, from, to, initialStatus));
		
		this.repository.save(savedEntity.getUser());
		
		return savedEntity;
	}

	public boolean isPropertyAvailable(String id, Date from, Date to) {
		return this.repository.getReservationsBetweenDates(id, from, to).isEmpty();
	}

	@Override
	public User getUserById(String id) {
		return this.repository.findById(id, User.class);
	}

	@Override
	public City getCityByName(String name) {
		Example<City> example = Example.of(new City().create(name));
		Optional<City> findOne = cityRepository.findOne(example);
		return findOne.isPresent() ? findOne.get() : null;
	}

	@Override
	public List<Reservation> getReservationsForProperty(String propertyId) {
		return this.repository.getReservationsForProperty(propertyId);
	}

	@Override
	public List<City> getCitiesMatching(String content) {
		return null;
	}

	@Override
	public City registerCity(String name) {
		City exampleCity = new City().create(name);
		Example<City> example = Example.of(exampleCity);
		Optional<City> findOne = this.cityRepository.findOne(example);
		if (findOne.isPresent())
			return findOne.get();

		return this.cityRepository.save(exampleCity);
	}

	@Override
	public List<City> getAllCities() {
		return this.cityRepository.findAll();
	}

	@Override
	public List<ReservationCount> getReservationCountByStatus() {
		return null;
	}

}
