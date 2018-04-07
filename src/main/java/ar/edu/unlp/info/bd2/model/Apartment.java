package ar.edu.unlp.info.bd2.model;

import javax.persistence.Entity;

@Entity
public class Apartment extends Property {
	
	private int rooms;

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int numberOfRooms) {
		this.rooms = numberOfRooms;
	}
	
}
