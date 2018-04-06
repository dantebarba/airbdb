package ar.edu.unlp.info.bd2.model;

public class Apartment extends Property {

	private Long id;
	private Float price;

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
