package ar.edu.info.unlp.bd2.etapa2.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User implements Persistable {
	
	private String id;
	private String username;
	private String name;

	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	/**
	 * Usa tabla intermedia.
	 */
	private Set<Property> properties = new HashSet<Property>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public static User create(String username2, String name) {
		User temp = new User();
		temp.setUsername(username2);
		temp.setName(name);
		return temp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
