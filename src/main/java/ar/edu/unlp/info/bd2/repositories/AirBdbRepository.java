package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlp.info.bd2.model.City;
import ar.edu.unlp.info.bd2.model.Property;
import ar.edu.unlp.info.bd2.model.Reservation;
import ar.edu.unlp.info.bd2.model.ReservationStatus;
import ar.edu.unlp.info.bd2.model.User;

/**
 * Los mapeos se realizaron utilizando los valores por defecto de Hibernate.
 *
 * @author dantebarba
 *
 */
public class AirBdbRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Object find(Serializable id, Class<?> clazz) {
		EntityManager entityManager = sessionFactory.getCurrentSession();
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserByEmail(String email) {
		return (List<User>) sessionFactory.getCurrentSession().createQuery("from User where username = :email")
				.setParameter("email", email).getResultList();
	}

	/**
	 * <b>Why use persist vs save?. </b>
	 * 
	 * Para los casos de uso presentados, siempre se persisten Transient
	 * Objects. Es preferible utilizar persist debido a que no gestiona el
	 * INSERT inmediatamente, sino que lo hace al cierre de la transacción.
	 * Además, explicitamente requiere la persistencia de objetos que no esten
	 * previamente persistidos en la base de datos y obliga a estar en un
	 * entorno transaccional.
	 * <p>
	 * <i>Since save does return the identifier, the INSERT statement has to be
	 * executed instantly regardless of the state of the transaction (which
	 * generally is a bad thing). Persist won't execute any statements outside
	 * of the currently running transaction just to assign the identifier.</i>
	 * 
	 * @see <a href=
	 *      "https://stackoverflow.com/questions/5862680/whats-the-advantage-of-persist-vs-save-in-hibernate"
	 *      >Stackoverflow</a>
	 * 
	 * @see <a href=
	 *      "https://stackoverflow.com/questions/161224/what-are-the-differences-between-the-different-saving-methods-in-hibernate">Stackoverflow
	 *      2</a>
	 * 
	 * 
	 * @param obj
	 * @return the persisted object
	 */
	public Object persist(Object obj) {
		this.sessionFactory.getCurrentSession().persist(obj);
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<Property> getPropertyByName(String name) {
		return (List<Property>) sessionFactory.getCurrentSession().createQuery("from Property where name = :name")
				.setParameter("name", name).getResultList();
	}

	public List<Reservation> getReservationsBetweenDates(Long id, Date from, Date to) {
		return this.sessionFactory.getCurrentSession()
				.createQuery(
						"from Reservation reservation where reservation.property.id = :id and reservation.status != :status and ((reservation.from >= :from and reservation.from < :to) or (reservation.to <= :to and reservation.to > :from))")
				.setParameter("to", to).setParameter("from", from).setParameter("id", id)
				.setParameter("status", ReservationStatus.CANCELED).getResultList();
	}

	public City findCityByName(String cityName) {
		List<City> cities = (List<City>) this.sessionFactory.getCurrentSession()
				.createQuery("from City where name = :cityName").setParameter("cityName", cityName).getResultList();
		return !cities.isEmpty() ? cities.get(0) : null;
	}

	public List<City> getCitiesThatHaveReservationsBetween(Date from, Date to) {
		List<City> cities = (List<City>) this.sessionFactory.getCurrentSession()
				.createQuery(
						"select distinct property.city from Reservation reservation join reservation.property property where reservation.from >= :from and reservation.to <= :to")
				.setParameter("from", from).setParameter("to", to).getResultList();
		return cities;
	}

	public Reservation getMostExpensivePrivateRoomReservation(Class<? extends Property> clazz) {
		String qlString = "from Reservation where price in (select max(reservation.price) from Reservation reservation where reservation.property.class = :class)";
		List<Reservation> result = (List<Reservation>) this.sessionFactory.getCurrentSession().createQuery(qlString)
				.setParameter("class", clazz.getSimpleName()).getResultList();
		return result.isEmpty() ? null : result.get(0);
	}

	public Double getTotalRevenueForFinishedReservationsDuringYear(Date from, Date to) {
		String qlString = "select sum(reservation.price) from Reservation reservation where reservation.status = 'FINISHED' and reservation.from >= :from and reservation.to <= :to ";
		Double priceSum = (Double) this.sessionFactory.getCurrentSession().createQuery(qlString).setParameter("from", from).setParameter("to", to).getSingleResult();
		return priceSum;
	}

	public List<User> getUsersThatReservedOnlyInCities(String[] cities) {
		String qlString = "select reservations.user from Reservation reservations join reservations.property property join property.city city where city.name in (:names) group by reservations.user.id having count(distinct city.name) = :listSize";
		List<User> resultList = this.sessionFactory.getCurrentSession().createQuery(qlString).setParameterList("names", Arrays.asList(cities))
				.setParameter("listSize", new Long(cities.length)).getResultList();
		return resultList;
	}

}
