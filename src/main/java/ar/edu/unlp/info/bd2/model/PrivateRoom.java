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

	public PrivateRoom create(String name, String description, double price, int capacity, int beds,
			String cityName) {
		super.create(name, description, price, capacity, cityName);
		this.beds = beds;
		return this;
	}
	
}
