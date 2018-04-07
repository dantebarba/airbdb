package ar.edu.unlp.info.bd2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReservationRating {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int points;
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ReservationRating create(int points2, String comment2) {
		this.setPoints(points2);
		this.setComment(comment2);
		return this;
	}
}
