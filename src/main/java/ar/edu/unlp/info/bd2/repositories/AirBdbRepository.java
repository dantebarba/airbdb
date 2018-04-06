package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AirBdbRepository {

  @Autowired
  private SessionFactory sessionFactory;
  
  public Object find(Serializable id, Class<?> clazz) {
	  EntityManager entityManager = sessionFactory.createEntityManager();
	  return entityManager.find(clazz, id);
  }

}
