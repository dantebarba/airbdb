package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface AirBdbService {

  /**
   * Crea un usuario
   * @param username nombre de usuario en el sistema (email)
   * @param name nombre real del usuario
   * @return el usuario creado
   */
  User createUser(String username, String name);

  /**
   * Obtiene un usuario por su username (email)
   * @param email email del usuario a buscar
   * @return el usuario que coincida o null si no hay ninguna coincidencia
   */
  User getUserByUsername(String email);

  /**
   * Crea un departamento nuevo
   * @param name nombre de la propiedad
   * @param description description corta de la propiedad
   * @param price precio por noche de la propiedad
   * @param capacity cantidad de habitantes que la propiedad puede alojar
   * @param rooms cantidad de habitaciones de la propiedad
   * @param cityName nombre de la ciudad en la que está localizada la propiedad
   * @return la propiedad creada
   */
  Apartment createAparment(String name, String description, double price, int capacity, int rooms, String cityName);

  /**
   * Crea una nueva habitación dentro de una propiedad
   * @param name nombre de la propiedad
   * @param description description corta de la propiedad
   * @param price precio por noche de la propiedad
   * @param capacity cantidad de habitantes que la propiedad puede alojar
   * @param beds cantidad de camas de las cuales dispone la propiedad
   * @param cityName nombre de la ciudad en la que está localizada la propiedad que contiene la habitación
   * @return la habitación creada
   */
  PrivateRoom createRoom(String name, String description, double price, int capacity, int beds, String cityName);

  /**
   * Obtiene una propiedad (habitación y departamento) por su nombre
   * @param name nombre de la propiedad a obtener
   * @return la propiedad que coincida o null si no hay ninguna coincidencia
   */
  Property getPropertyByName(String name);

  /**
   * Crea una nueva reserva para un usuario dado en una propiedad puntual
   * @param propertyId id de la propiedad en la cual se quiere crear la reserva
   * @param userId id del usuario para el cual se quiere crear la reserva
   * @param from fecha desde la cual comienza la reserva
   * @param to fecha en la cual termina la reserva
   * @return la reserva creada
   * @throws ReservationException si ya existe una reserva en ese rango de fechas
   */
  Reservation createReservation(long propertyId, long userId, Date from, Date to) throws ReservationException;

  /**
   * Devuelve si una propiedad está disponible para ser reservada en un rango de fechas dado
   * @param id id de la propiedad que se quiere consultar
   * @param from fecha desde la cual se quiere comprobar disponibilidad
   * @param to fecha hasta la cual se quiere comprobar disponibilidad
   * @return <code>true</code> si la propiedad está disponible para ser reservada o <code>false</code> en caso contrario
   */
  boolean isPropertyAvailable(Long id, Date from, Date to);

  /**
   * Cancela una reserva creada
   * @param reservationId id de la reserva a cancelar
   */
  void cancelReservation(Long reservationId);

  /**
   * Obtiene un usuario por su id
   * @param id el id del usuario
   * @return el usuario que coincida o null si no hay ninguna coincidencia
   */
  User getUserById(Long id);

  /**
   * Crea una evaluación para una reserva dada
   * @param reservationId id de la reserva a evaluar
   * @param points puntaje asignado en la evaluación
   * @param comment comentarios adicionales a la evaluación
   * @throws RateException si la reserva no fue completada exitosamente (es decir, no esta en estado
   * <code>ReservationStatus.FINISHED</code>
   */
  void rateReservation(Long reservationId, int points, String comment) throws RateException;

  /**
   * Pasa una reserva a estado terminado (<code>ReservationStatus.FINISHED</code>)
   * @param id
   */
  void finishReservation(Long id);

  /**
   * Obtiene la evaluación de una reserva dada
   * @param reservationId id de la reserva
   * @return la evaluación que concida para esa propiedad
   */
  ReservationRating getRatingForReservation(Long reservationId);

  /**
   * Obtiene una reserva por su id
   * @param id id de la reserva que se busca
   * @return la reserva que coincida con ese id o <code>null</code> en caso contrario
   */
  Reservation getReservationById(Long id);
}
