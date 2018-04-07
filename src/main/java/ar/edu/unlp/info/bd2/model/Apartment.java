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

	public Apartment create(String name, String description, double price, int capacity, int rooms2,
			String cityName) {
		super.create(name, description, price, capacity, cityName);
		this.rooms = rooms2;
		return this;
	}

}
