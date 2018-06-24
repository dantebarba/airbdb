package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.City;
import ar.edu.unlp.info.bd2.model.Property;
import ar.edu.unlp.info.bd2.model.Reservation;
import ar.edu.unlp.info.bd2.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AirBdbStatisticsService {

  /**
   * Obtiene todas las propiedades que fueron reservadas por el usuario con username <code>userEmail</code>
   * @param userEmail
   * @return Una lista de propiedades que satisfagan la condición
   */
  List<Property> getAllPropertiesReservedByUser(String userEmail);

  /**
   * Obtiene todos los usuarios que han gastado más de <code>amount</code> en reservas en la plataforma
   * @param amount
   * @return Una lista de usuarios que satisfagan la condición
   */
  List<User> getUsersSpendingMoreThan(double amount);

  /**
   * Top 3 de Apartments con mejores calificaciones promedio
   * @return Una lista de arrays en el que cada uno contiene dos elementos, en este orden:
   *  1. el Apartment
   *  2. el puntaje promedio
   */
  List<Object[]> getApartmentTop3Ranking();

  /**
   * Obtiene todos los usuarios que han reservado más de una vez en el año <code>year</code>
   * @param year
   * @return Una lista de usuarios que satisfagan la condición
   */
  List<User> getUsersThatReservedMoreThan1PropertyDuringASpecificYear(int year);

  /**
   * Obtiene todas las propiedades con una capacidad mayor a <code>capacity</code> que han sido reservadas
   * por más de un usuario en la plataforma
   * @param capacity
   * @return Una lista de propiedades que satisfagan la condición
   */
  List<Property> getPropertiesThatHaveBeenReservedByMoreThanOneUserWithCapacityMoreThan(int capacity);

  /**
   * Obtiene las reservas del usuario con username <code>username</code> en las ciudades <code>cities</code>
   * @return Las ciudades que satisfagan la condición
   */
  List<Reservation> getReservationsInCitiesForUser(String username, String... cities);

  /**
   * Obtiene las ciudades que han tenido reservas entre las fechas <code>from</code> y <code>to</code>
   * @param from
   * @param to
   * @return Las ciudades que satisfagan la condición
   */
  List<City> getCitiesThatHaveReservationsBetween(Date from, Date to);

  /**
   * Obtiene los usuarios que realizaron *solo* realizaron reservas en todas las ciudades cuyos nombres son listados en <code>cities</code>
   * @return los usuairos que satisfagan el criterio
   */
  List<User> getUsersThatReservedOnlyInCities(String... cities);

  /**
   * Obtiene la reserva de habitación privada (PrivateRoom) más cara de toda la plataforma
   * @return La reserva que satisfaga el criterio
   */
  Reservation getMostExpensivePrivateRoomReservation();

  /**
   * Devuelve los nombres de usuarios de Hotmail (cuyo username termine en @hotmail.com) cuyas reservas estén todas finalizadas
   * @return Los nombres de usuario que coincidan con los criterios
   */
  List<String> getHotmailUsersWithAllTheirReservationsFinished();

  /**
   * Obtiene el importe total facturado por la plataforma en concepto de todas aquellas reservas que han sido finalizadas (es decir
   * que no han sido canceladas ni están en espera de confirmación) durante un año (<code>year</code>) específico
   * @param year
   * @return El importe en cuestión
   */
  Double getTotalRevenueForFinishedReservationsDuringYear(int year);

  /**
   * Devuelve una lista de usuarios que hayan reservado sólo en el conjunto de ciudades cuyos nombres son descriptos en <code>cities</code>
   * y cuyo username contenga <code>usernamePart</code>
   * @param usernamePart
   * @param cities
   * @return La lista de usuarios que satisfaga los criterios descriptos
   */
  List<User> getMatchingUsersThatOnlyHaveReservationsInCities(String usernamePart, String... cities);

}
