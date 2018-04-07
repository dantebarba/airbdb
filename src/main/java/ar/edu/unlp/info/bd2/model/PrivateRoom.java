package ar.edu.unlp.info.bd2.model;

import javax.persistence.Entity;

@Entity
public class PrivateRoom extends Property {

	private int beds;

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}
	
	public static PrivateRoom create(String name, String description, double price, int capacity, int beds,
			String cityName) {
		return new PrivateRoom().create(name, description, price, capacity, cityName, beds);
	}

	private PrivateRoom create(String name, String description, double price, int capacity, String cityName, int beds) {
		super.create(name, description, price, capacity, cityName);
		this.beds = beds;
		return this;
	}
	
}
