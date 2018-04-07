package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;
import org.joda.time.Days;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double price;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_from")
	private Date from;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_to")
	private Date to;
	
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn
	private Property property;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn
	private User user;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public Reservation create(Property property2, User user2, Date from2, Date to2) {
		this.from = from2;
		this.to = to2;
		this.property = property2;
		this.user = user2;
		this.calculatePrice();
		this.addReservationToUser();
		return this;
		
	}
	
	private void addReservationToUser() {
		this.getUser().getReservations().add(this);
	}

	private void calculatePrice() {
		this.setPrice(
				Days.daysBetween(new DateTime(from).withTimeAtStartOfDay(), new DateTime(to).withTimeAtStartOfDay())
						.getDays() * this.getProperty().getPrice());
	}

}
