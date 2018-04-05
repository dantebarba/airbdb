package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.config.AppConfig;
import ar.edu.unlp.info.bd2.config.HibernateConfiguration;
import ar.edu.unlp.info.bd2.model.*;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@Rollback(true)
public class AirBdbServiceTestCase {

  @Autowired
  AirBdbService service;

  @Test
  public void testCreateUser() {
    this.service.createUser("user@email.com", "user");
    User user = this.service.getUserByUsername("user@email.com");
    Assert.assertNotNull(user);
    Assert.assertEquals("user@email.com", user.getUsername());
  }

  @Test
  public void testCreateApartment(){
    this.service.createAparment("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2,2, "La Plata");
    Property property = this.service.getPropertyByName("Apartment with 2 Rooms");
    Assert.assertNotNull(property);
    Assert.assertEquals("Apartment with 2 Rooms", property.getName());
  }

  @Test
  public void testCreateRoom(){
    this.service.createRoom("Private Room", "Room in ample house close to City Center", 45.0, 2,2, "La Plata");
    Property property = this.service.getPropertyByName("Private Room");
    Assert.assertNotNull(property);
    Assert.assertEquals("Private Room", property.getName());
  }

  @Test
  public void testRentProperty() throws ParseException, ReservationException {
    Apartment apartment = this.service.createAparment("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2, 2, "La Plata");
    User user = this.service.createUser("user@email.com", "user");

    Assert.assertEquals(0, user.getReservations().size());

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date from = sdf.parse("20/10/2018");
    Date to = sdf.parse("23/10/2018");
    Reservation reservation = this.service.createReservation(apartment.getId(), user.getId(), from, to);

    int nights = Days.daysBetween(new DateTime(from).withTimeAtStartOfDay() , new DateTime(to).withTimeAtStartOfDay() ).getDays();

    Assert.assertEquals(nights * apartment.getPrice(), reservation.getPrice(), 0);
    Assert.assertEquals(apartment, reservation.getProperty());
    Assert.assertEquals(user, reservation.getUser());

    user = this.service.getUserById(user.getId());
    Assert.assertEquals(1, user.getReservations().size());
  }

  @Test
  public void testRentPropertyCollision() throws ParseException, ReservationException {
    Property property = this.service.createAparment("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2,2, "La Plata" );
    User user = this.service.createUser("user@email.com", "user");

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    this.service.createReservation(property.getId(), user.getId(), sdf.parse("20/10/2018"), sdf.parse("23/10/2018"));
    this.service.createReservation(property.getId(), user.getId(), sdf.parse("25/10/2018"), sdf.parse("28/10/2018"));
    try {
      this.service.createReservation(property.getId(), user.getId(), sdf.parse("22/10/2018"), sdf.parse("24/10/2018"));
    } catch (ReservationException e) {
      return;
    }
    Assert.fail("Last reservation should not be allowed since property is already reserved in those dates");
  }

  @Test
  public void testIsPropertyAvailable() throws ParseException, ReservationException {
    Property property = this.service.createAparment("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2,2, "La Plata" );
    User user = this.service.createUser("user@email.com", "user");

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date from = sdf.parse("20/10/2018");
    Date to = sdf.parse("23/10/2018");
    Reservation reservation = this.service.createReservation(property.getId(), user.getId(), from, to);

    Assert.assertTrue(this.service.isPropertyAvailable(property.getId(), sdf.parse("10/10/2018"), sdf.parse("18/10/2018")));
    Assert.assertFalse(this.service.isPropertyAvailable(property.getId(), sdf.parse("10/10/2018"), sdf.parse("21/10/2018")));
    Assert.assertFalse(this.service.isPropertyAvailable(property.getId(), sdf.parse("21/10/2018"), sdf.parse("23/10/2018")));
    Assert.assertTrue(this.service.isPropertyAvailable(property.getId(), sdf.parse("24/10/2018"), sdf.parse("30/10/2018")));

    this.service.cancelReservation(reservation.getId());

    // now the property should be available during these days
    Assert.assertTrue(this.service.isPropertyAvailable(property.getId(), sdf.parse("10/10/2018"), sdf.parse("21/10/2018")));
    Assert.assertTrue(this.service.isPropertyAvailable(property.getId(), sdf.parse("21/10/2018"), sdf.parse("23/10/2018")));
  }

  @Test
  public void testRateReservation() throws ParseException, ReservationException, RateException {
    boolean exceptionThrown = false;
    Property property = this.service.createAparment("Apartment with 2 Rooms", "Cozy Apartment close to City Center", 45.0, 2,2, "La Plata" );
    User user = this.service.createUser("user@email.com", "user");

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date from = sdf.parse("20/10/2018");
    Date to = sdf.parse("23/10/2018");
    Reservation reservation = this.service.createReservation(property.getId(), user.getId(), from, to);

    Assert.assertNotEquals(reservation.getStatus(), ReservationStatus.FINISHED);

    try {
      this.service.rateReservation(reservation.getId(), 1, "Dirty place to stay");
    } catch (RateException e) {
      exceptionThrown = true;
    }
    if (!exceptionThrown) {
      Assert.fail("Reservation is not finished so it's not possible to rate it");
    }

    this.service.finishReservation(reservation.getId());
    reservation = this.service.getReservationById(reservation.getId());

    this.service.rateReservation(reservation.getId(), 1, "Very dirty and uncomfortable");

    ReservationRating rating = this.service.getRatingForReservation(reservation.getId());
    Assert.assertNotNull(rating);
    Assert.assertEquals(1, rating.getPoints());
    Assert.assertEquals("Very dirty and uncomfortable", rating.getComment());
  }

}
