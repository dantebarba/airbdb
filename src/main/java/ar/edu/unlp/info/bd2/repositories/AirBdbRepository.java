package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

	public List<User> getUserByEmail(String email) {
		return (List<User>) sessionFactory.getCurrentSession().createQuery("from User where username = :email").setParameter("email", email)
				.getResultList();
	}

	public Object persist(Object obj) {
		this.sessionFactory.getCurrentSession().persist(obj);
		return obj;
	}

}
