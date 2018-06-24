package ar.edu.info.unlp.bd2.etapa2.model;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservation")
public class Reservation implements Persistable {

	@Id
	private String id;
	
	private double price;

	private Date from;

	private Date to;

	private ReservationStatus status = ReservationStatus.CONFIRMATION_PENDING;

	private Property property;

	private User user;

	private ReservationRating rating;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public boolean isFinished() {
		return this.getStatus().equals(ReservationStatus.FINISHED);
	}

	public ReservationRating getRating() {
		return rating;
	}

	public void setRating(ReservationRating rating) {
		this.rating = rating;
	}

	public void rate(int points, String comment) throws RateException {
		if (!isFinished()) {
			throw new RateException();
		}
		this.setRating(new ReservationRating().create(points, comment));
	}

	public void finish() {
		setStatus(ReservationStatus.FINISHED);
	}

	public void cancel() {
		if (!this.canBeCanceled())
			throw new IllegalStateException();
		setStatus(ReservationStatus.CANCELED);
	}

	public boolean canBeCanceled() {
		return !ReservationStatus.FINISHED.equals(this.getStatus());
	}
}
