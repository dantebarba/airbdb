package ar.edu.info.unlp.bd2.etapa2.service.impl;

import java.util.Date;
import java.util.List;

import ar.edu.info.unlp.bd2.etapa2.model.City;
import ar.edu.info.unlp.bd2.etapa2.model.Property;
import ar.edu.info.unlp.bd2.etapa2.model.RepeatedUsernameException;
import ar.edu.info.unlp.bd2.etapa2.model.Reservation;
import ar.edu.info.unlp.bd2.etapa2.model.ReservationException;
import ar.edu.info.unlp.bd2.etapa2.model.ReservationStatus;
import ar.edu.info.unlp.bd2.etapa2.model.User;
import ar.edu.info.unlp.bd2.etapa2.repository.AirBdbRepository;
import ar.edu.info.unlp.bd2.etapa2.service.AirBdbService;
import ar.edu.info.unlp.bd2.etapa2.utils.ReservationCount;

public class AirBdbServiceImpl implements AirBdbService {

	private AirBdbRepository repository = null;

	public AirBdbServiceImpl(AirBdbRepository repository) {
		this.repository  = repository;
	}

	@Override
	public User createUser(String username, String name) throws RepeatedUsernameException {
		return null;
	}

	@Override
	public User getUserByUsername(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property createProperty(String name, String description, double price, int capacity, int rooms,
			String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearDb() {
		// TODO Auto-generated method stub

	}

	@Override
	public Reservation createReservation(String propertyId, String userId, Date from, Date to,
			ReservationStatus initialStatus) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City getCityByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationsForProperty(String propertyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> getCitiesMatching(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City registerCity(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservationCount> getReservationCountByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
