package ar.edu.unlp.info.bd2.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import ar.edu.unlp.info.bd2.exceptions.RateException;
import ar.edu.unlp.info.bd2.exceptions.ReservationException;
import ar.edu.unlp.info.bd2.model.Apartment;
import ar.edu.unlp.info.bd2.model.PrivateRoom;
import ar.edu.unlp.info.bd2.model.Property;
import ar.edu.unlp.info.bd2.model.Reservation;
import ar.edu.unlp.info.bd2.model.ReservationRating;
import ar.edu.unlp.info.bd2.model.User;
import ar.edu.unlp.info.bd2.repositories.AirBdbRepository;
import ar.edu.unlp.info.bd2.services.AirBdbService;

public class AirBdbServiceImpl implements AirBdbService {

	AirBdbRepository repository = null;

	public AirBdbServiceImpl(AirBdbRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isPropertyAvailable(Long id, Date from, Date to) {
		return this.repository.getReservationsBetweenDates(id, from, to).isEmpty();
	}

	@Override
	@Transactional
	public void cancelReservation(Long reservationId) {

	}

	@Override
	@Transactional
	public void finishReservation(Long id) {
	}

	@Override
	@Transactional
	public User createUser(String username, String name) {

		Assert.hasLength(username, "Se debe ingresar un usuario.");
		Assert.hasLength(name, "Se debe ingresar un nombre.");
		Assert.isNull(this.getUserByUsername(username), "Ya existe un usuario con username " + username);

		return (User) repository.persist(User.create(username, name));
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserByUsername(String email) {
		Assert.hasText(email, "El email ingresado no es válido");
		List<User> result = this.repository.getUserByEmail(email);
		return !result.isEmpty() ? result.get(0) : null;
	}

	@Override
	@Transactional
	public Apartment createAparment(String name, String description, double price, int capacity, int rooms,
			String cityName) {
		this.propertyValidation(name, capacity, cityName);
		Assert.isTrue(rooms > 0, "Debe tener al menos una habitación.");

		return (Apartment) repository
				.persist(new Apartment().create(name, description, price, capacity, rooms, cityName));
	}

	@Override
	@Transactional
	public PrivateRoom createRoom(String name, String description, double price, int capacity, int beds,
			String cityName) {
		propertyValidation(name, capacity, cityName);
		Assert.isTrue(beds > 0, "Debe tener al menos una habitación.");

		return (PrivateRoom) repository
				.persist(new PrivateRoom().create(name, description, price, capacity, beds, cityName));
	}

	private void propertyValidation(String name, int capacity, String cityName) {
		Assert.hasText(name, "El nombre no puede estar vacio");
		Assert.hasText(cityName, "Se debe ingresar la ciudad");
		Assert.isTrue(capacity > 0, "Debe poder ser ocupada.");
		Assert.isNull(this.getPropertyByName(name), "La propiedad ya existe");
	}

	@Override
	@Transactional
	public Property getPropertyByName(String name) {
		Assert.hasText(name, "El nombre ingresado no es válido");
		List<Property> result = this.repository.getPropertyByName(name);
		return !result.isEmpty() ? result.get(0) : null;
	}

	@Override
	@Transactional
	public Reservation createReservation(long propertyId, long userId, Date from, Date to) throws ReservationException {

		Assert.isTrue(propertyId != 0, "Se debe ingresar una propiedad");
		Assert.isTrue(userId != 0, "Se debe ingresar un usuario");
		Assert.notNull(from, "Se debe ingresar una fecha desde");
		Assert.notNull(to, "Se debe ingresar una fecha hasta");

		Property property = (Property) this.repository.find(propertyId, Property.class);
		Assert.notNull(property, "No se ha encontrado la propiedad con id " + propertyId);
		User user = (User) this.repository.find(userId, User.class);
		Assert.notNull(user, "No se ha encontrado el usuario con id " + userId);		
		
		if (!this.isPropertyAvailable(property.getId(), from, to))
			throw new ReservationException();
		
		return (Reservation) this.repository.persist(new Reservation().create(property, user, from, to));
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(Long id) {
		return (User) this.repository.find(id, User.class);
	}

	@Override
	@Transactional
	public void rateReservation(Long reservationId, int points, String comment) throws RateException {

	}

	@Override
	@Transactional(readOnly = true)
	public ReservationRating getRatingForReservation(Long reservationId) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Reservation getReservationById(Long id) {
		
		Assert.notNull(id, "Se debe ingresar una id valida");
		
		return (Reservation) repository.find(id, Reservation.class);
	}

}
