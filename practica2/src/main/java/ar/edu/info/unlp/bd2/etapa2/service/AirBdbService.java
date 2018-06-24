package ar.edu.info.unlp.bd2.etapa2.service;

import ar.edu.info.unlp.bd2.etapa2.model.*;
import ar.edu.info.unlp.bd2.etapa2.utils.ReservationCount;

import java.util.Date;
import java.util.List;

public interface AirBdbService {

  /**
   * Crea un usuario
   * @param username nombre de usuario en el sistema (email)
   * @param name nombre real del usuario
   * @return el usuario creado
   */
  User createUser(String username, String name) throws RepeatedUsernameException;

  /**
   * Obtiene un usuario por su username (email)
   * @param email email del usuario a buscar
   * @return el usuario que coincida o null si no hay ninguna coincidencia
   */
  User getUserByUsername(String email);

  /**
   * Crea una nueva propiedad, incluyendo la creación lazy de la <code>City</code> con nombre <code>name</code>
   * @param name nombre de la propiedad
   * @param description description corta de la propiedad
   * @param price precio por noche de la propiedad
   * @param capacity cantidad de habitantes que la propiedad puede alojar
   * @param rooms cantidad de habitaciones de la propiedad
   * @param cityName nombre de la ciudad en que la propiedad estará localizada
   * @return la propiedad creada
   */
  Property createProperty(String name, String description, double price, int capacity, int rooms, String cityName);

  /**
   * Limpia la base de datos por completo, borrando todas las colecciones
   */
  void clearDb();

  /**
   * Crea una nueva reserva para un usuario dado en una propiedad puntual
   * @param propertyId id de la propiedad en la cual se quiere crear la reserva
   * @param userId id del usuario para el cual se quiere crear la reserva
   * @param from fecha desde la cual comienza la reserva
   * @param to fecha en la cual termina la reserva
   * @param initialStatus estado inicial de la reserva
   * @return la reserva creada
   * @throws ReservationException si ya existe una reserva en ese rango de fechas
   */
  Reservation createReservation(String propertyId, String userId, Date from, Date to, ReservationStatus initialStatus) throws ReservationException;

  /**
   * Obtiene un usuario por su id
   * @param id el id del usuario
   * @return el usuario que coincida o null si no hay ninguna coincidencia
   */
  User getUserById(String id);

  /**
   * Obtiene una ciudad por su nombre
   * @param name
   * @return la ciudad que cumpla con el criterio o <code>null</code> de no existir ninguna
   */
  City getCityByName(String name);

  /**
   * Obtiene todas las reservas de una propiedad dada
   * @param propertyId id de la propiedad
   * @return las reservas que cumplan con el criterio
   */
  List<Reservation> getReservationsForProperty(String propertyId);

  /**
   * Obtiene las ciudades que contengan en su nombre <code>content</code>, <bold>ordenadas por nomrbes</bold>
   * @param content
   * @return Las ciudades que coincidan con el criterio
   */
  List<City> getCitiesMatching(String content);

  /**
   * Registra una ciudad con nombre <code>name</code> si no está registrada aún
   * @param name
   */
  City registerCity(String name);

  /**
   * Lista todas las ciudades registradas en la aplicación
   * @return
   */
  List<City> getAllCities();

  /**
   * Obtiene las cantidad de reservas que hay en el sistema en cada estado en particular
   * @return
   */
  List<ReservationCount> getReservationCountByStatus();
}
