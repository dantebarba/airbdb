package ar.edu.unlp.info.bd2.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Long id;
	private String username;
	
	private Set<Reservation> reservations = new HashSet<Reservation>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
