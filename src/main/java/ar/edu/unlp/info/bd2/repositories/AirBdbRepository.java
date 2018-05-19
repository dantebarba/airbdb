package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


	public List<Object[]> getApartmentTop3Ranking() {
		return (List<Object[]>) this.sessionFactory.getCurrentSession().createQuery("select res.property,avg(res.rating.points)" +
				" as prom from Reservation res where res.status = 'FINISHED' AND res.property.class = 'Apartment'" +
				" group by res.property.id order by prom DESC").setMaxResults(3).getResultList();
		}
    public List<User> getMatchingUsersThatOnlyHaveReservationsInCities(String usernamePart, String... cities) {
        return this.sessionFactory.getCurrentSession().createQuery("select distinct us from User us join us.reservations res " +
                "where us.username like :subusername  and not exists " +
                "(from Reservation res2 where res2.property.city.name " +
                "not in :cities and res2.user.id = us.id)")
                .setParameter("subusername",'%' + usernamePart + '%' )
                .setParameterList("cities",Arrays.asList (cities)).getResultList();

    }
    public List<Reservation> getReservationsInCitiesForUser(String username, String... cities) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("select res from Reservation res " +
                        "where res.user.username = :us " +
                        "and res.property.city.name in :cities")
                .setParameter("us",username)
                .setParameterList("cities",Arrays.asList(cities)).getResultList();
    }
    public List<User> getUsersThatReservedMoreThan1PropertyDuringASpecificYear(int year){
        return this.sessionFactory.getCurrentSession()
                .createQuery("select res.user from Reservation res where year(res.from) = :year " +
						"or year(res.to) = :year  " +
						"group by res.user.id having count(*) > 1").setParameter("year",year).getResultList();
    }
}
