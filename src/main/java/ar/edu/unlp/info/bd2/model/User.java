package ar.edu.unlp.info.bd2.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String name;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	/**
	 * Usa tabla intermedia.
	 */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
