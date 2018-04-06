package ar.edu.unlp.info.bd2.services.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

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
		return false;
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
	public User createUser(String username, String name) {
		return null;
	}

	@Override
	@Transactional
	public User getUserByUsername(String email) {
		return null;
	}

	@Override
	@Transactional
	public Apartment createAparment(String name, String description, double price, int capacity, int rooms,
			String cityName) {
		return null;
	}

	@Override
	@Transactional
	public PrivateRoom createRoom(String name, String description, double price, int capacity, int beds,
			String cityName) {
		return null;
	}

	@Override
	@Transactional
	public Property getPropertyByName(String name) {
		return null;
	}

	@Override
	@Transactional
	public Reservation createReservation(long propertyId, long userId, Date from, Date to) throws ReservationException {
		return null;
	}

	@Override
	@Transactional
	public User getUserById(Long id) {
		return null;
	}

	@Override
	@Transactional
	public void rateReservation(Long reservationId, int points, String comment) throws RateException {
		
	}

	@Override
	@Transactional
	public ReservationRating getRatingForReservation(Long reservationId) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Reservation getReservationById(Long id) {
		return null;
	}

}
