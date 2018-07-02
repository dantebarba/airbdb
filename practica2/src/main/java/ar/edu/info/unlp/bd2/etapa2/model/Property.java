package ar.edu.info.unlp.bd2.etapa2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "property")
public class Property implements Persistable {
	
	@Id
	private String id;
	private String name;
	private double price;

	@DBRef
	private City city;
	private int capacity;
	private String description;
	private int rooms;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Property create(String name2, String description, double price2, int capacity2, int rooms, City city2) {
		this.name = name2;
		this.setDescription(description);
		this.price = price2;
		this.capacity = capacity2;
		this.setRooms(rooms);
		this.city = city2;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

}
