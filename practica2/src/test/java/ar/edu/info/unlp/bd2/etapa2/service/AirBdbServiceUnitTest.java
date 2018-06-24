package ar.edu.info.unlp.bd2.etapa2.service;

import ar.edu.info.unlp.bd2.etapa2.config.ApplicationConfiguration;
import ar.edu.info.unlp.bd2.etapa2.config.MongoConfiguration;
import ar.edu.info.unlp.bd2.etapa2.model.*;
import ar.edu.info.unlp.bd2.etapa2.utils.ReservationCount;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MongoConfiguration.class, ApplicationConfiguration.class }, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class AirBdbServiceUnitTest {

  @Autowired
  AirBdbService service;

  @BeforeEach
  public void clearDb() {
    this.service.clearDb();
  }

  @Test
  public void testCreateUser() throws RepeatedUsernameException {
    boolean exceptionThrown = false;

    this.service.createUser("user@email.com", "user");
    User user = this.service.getUserByUsername("user@email.com");
    Assert.assertNotNull(user);
    Assert.assertEquals("user@email.com", user.getUsername());
    Assert.assertNotNull(user.getId());

    try {this.service.createUser("user@email.com", "user");}
    catch (RepeatedUsernameException e){
      exceptionThrown = true;
    }
    if (!exceptionThrown) {
      Assert.fail("Creating more than one user with the same username should not be allowed.");
    }
  }

  @Test
  public void testRentProperty() throws ParseException, ReservationException, RepeatedUsernameException {
    Property property = this.service.createProperty("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2, 2, "La Plata");

    City city = this.service.getCityByName("La Plata");
    Assert.assertNotNull(city);
    Assert.assertEquals("La Plata", city.getName());

    User user = this.service.createUser("user@email.com", "user");

    Assert.assertEquals(0, user.getReservations().size());
    Assert.assertEquals(0, this.service.getReservationsForProperty(property.getId()).size());

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date from = sdf.parse("20/10/2018");
    Date to = sdf.parse("23/10/2018");
    Reservation reservation = this.service.createReservation(property.getId(), user.getId(), from, to, ReservationStatus.CONFIRMATION_PENDING);

    int nights = Days.daysBetween(new DateTime(from).withTimeAtStartOfDay() , new DateTime(to).withTimeAtStartOfDay() ).getDays();

    Assert.assertEquals(nights * property.getPrice(), reservation.getPrice(), 0);
    Assert.assertEquals(property.getId(), reservation.getProperty().getId());
    Assert.assertEquals(user.getId(), reservation.getUser().getId());

    user = this.service.getUserById(user.getId());
    Assert.assertEquals(1, user.getReservations().size());
    Assert.assertEquals(1, this.service.getReservationsForProperty(property.getId()).size());
  }

  @Test
  public void testRentPropertyCollision() throws ParseException, ReservationException, RepeatedUsernameException {
    boolean throwsException = false;

    Property property = this.service.createProperty("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2, 2, "La Plata");
    User user = this.service.createUser("user@email.com", "user");

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    this.service.createReservation(property.getId(), user.getId(), sdf.parse("20/10/2018"), sdf.parse("23/10/2018"), ReservationStatus.CONFIRMATION_PENDING);
    this.service.createReservation(property.getId(), user.getId(), sdf.parse("25/10/2018"), sdf.parse("28/10/2018"), ReservationStatus.CONFIRMATION_PENDING);
    try {
      this.service.createReservation(property.getId(), user.getId(), sdf.parse("22/10/2018"), sdf.parse("24/10/2018"), ReservationStatus.CONFIRMATION_PENDING);
    } catch (ReservationException e) {
      throwsException = true;
    }

    if (!throwsException) {
      Assert.fail("Last reservation should not be allowed since property is already reserved in those dates");
    }

    try {
      this.service.createReservation(property.getId(), user.getId(), sdf.parse("10/10/2018"), sdf.parse("30/10/2018"), ReservationStatus.CONFIRMATION_PENDING);
    } catch (ReservationException e) {
      return;
    }
    Assert.fail("Last reservation should not be allowed since property is already reserved in those dates");
  }

  @Test
  public void testGetCitiesMatching() throws ParseException, ReservationException, RepeatedUsernameException {
    this.service.registerCity("La Plata");
    this.service.registerCity("Mar del Plata");
    this.service.registerCity("Junin");
    this.service.registerCity("Mar de Ajo");
    this.service.registerCity("Mar de las Pampas");
    this.service.registerCity("Córdoba");

    List<City> cities = this.service.getCitiesMatching("Mar");

    Assert.assertEquals(3, cities.size());
    Assert.assertEquals("Mar de Ajo", cities.get(0).getName());
    Assert.assertEquals("Mar de las Pampas", cities.get(1).getName());
    Assert.assertEquals("Mar del Plata", cities.get(2).getName());

  }

  @Test
  public void testGetReservationCountByCity() throws RepeatedUsernameException, ParseException, ReservationException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    User user = this.service.createUser("user@email.com", "user");

    Property propertyInLaPlata = this.service.createProperty("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2, 2, "La Plata");
    Property propertyInMarDelPlata = this.service.createProperty("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2, 2, "Mar del Plata");
    Property propertyInLaPampa = this.service.createProperty("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2, 2, "La Pampa");

    this.service.createReservation(propertyInLaPlata.getId(), user.getId(), sdf.parse("22/10/2018"), sdf.parse("23/10/2018"), ReservationStatus.CONFIRMATION_PENDING);
    this.service.createReservation(propertyInMarDelPlata.getId(), user.getId(), sdf.parse("24/10/2018"), sdf.parse("25/10/2018"), ReservationStatus.CONFIRMED);
    this.service.createReservation(propertyInMarDelPlata.getId(), user.getId(), sdf.parse("26/10/2018"), sdf.parse("27/10/2018"), ReservationStatus.CONFIRMED);
    this.service.createReservation(propertyInLaPampa.getId(), user.getId(), sdf.parse("22/10/2018"), sdf.parse("24/10/2018"), ReservationStatus.FINISHED);
    this.service.createReservation(propertyInLaPampa.getId(), user.getId(), sdf.parse("25/10/2018"), sdf.parse("26/10/2018"), ReservationStatus.FINISHED);
    this.service.createReservation(propertyInLaPampa.getId(), user.getId(), sdf.parse("27/10/2018"), sdf.parse("28/10/2018"), ReservationStatus.FINISHED);

    List<City> cities = this.service.getAllCities();
    Assert.assertEquals(3, cities.size());

    List<ReservationCount> reservationCountByStatus = this.service.getReservationCountByStatus();
    Assert.assertEquals(3, reservationCountByStatus.size());
    Assert.assertTrue(
            reservationCountByStatus.stream()
                    .anyMatch(rc -> rc.getCount().equals(2L) && rc.getStatus().equals(ReservationStatus.CONFIRMED)));
    Assert.assertTrue(
            reservationCountByStatus.stream()
                    .anyMatch(rc -> rc.getCount().equals(3L) && rc.getStatus().equals(ReservationStatus.FINISHED)));
    Assert.assertTrue(
            reservationCountByStatus.stream()
                    .anyMatch(rc -> rc.getCount().equals(1L) && rc.getStatus().equals(ReservationStatus.CONFIRMATION_PENDING)));


  }

}
