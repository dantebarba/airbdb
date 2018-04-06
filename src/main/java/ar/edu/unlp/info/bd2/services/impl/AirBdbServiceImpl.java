package ar.edu.unlp.info.bd2.services.impl;

import java.util.Date;

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
	public boolean isPropertyAvailable(Long id, Date from, Date to) {
		return false;
	}

	@Override
	public void cancelReservation(Long reservationId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishReservation(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User createUser(String username, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Apartment createAparment(String name, String description, double price, int capacity, int rooms,
			String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrivateRoom createRoom(String name, String description, double price, int capacity, int beds,
			String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property getPropertyByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation createReservation(long propertyId, long userId, Date from, Date to) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rateReservation(Long reservationId, int points, String comment) throws RateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReservationRating getRatingForReservation(Long reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getReservationById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
