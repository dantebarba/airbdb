package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

}
