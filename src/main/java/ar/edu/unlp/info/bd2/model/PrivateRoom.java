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
	
}
