package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
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

	public List<Property> getAllPropertiesReservedByUser(String userEmail) {

		return this.sessionFactory.getCurrentSession()
				.createQuery("from Property property where property.id in (select reservation.property.id from Reservation reservation where reservation.user.username =:email)")
				.setParameter("email", userEmail).getResultList();
	}

    public List<String> getHotmailUsersWithAllTheirReservationsFinished() {

        return this.sessionFactory.getCurrentSession()
                .createQuery("select distinct us.username from User us where us.username like '%@hotmail.com' AND not exists (from Reservation res where res.status!=:status and res.user.id=us.id)")
                .setParameter("status", ReservationStatus.FINISHED)
                .getResultList();
    }

    public List<Property> getPropertiesThatHaveBeenReservedByMoreThanOneUserWithCapacityMoreThan(int capacity) {

        return this.sessionFactory.getCurrentSession()
                .createQuery(
                        "from Property pro2\n" +
                                "where 1 < (select count(distinct res.user.id)\n" +
                                "from Reservation res \n" +
                                "where res.property.id= pro2.id)\n" +
                                "and pro2.capacity >:capacity ")
                .setParameter("capacity", capacity)
                .getResultList();
    }

    public List<User> getUsersSpendingMoreThan(double amount) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from User user1\n" +
                        "where :amount < (select sum(res.price)\n" +
                        "\t\t\t  from user1.reservations res \n" +
                        "     \t\t ) "
                )
                .setParameter("amount", amount)
                .getResultList();
    }
}
