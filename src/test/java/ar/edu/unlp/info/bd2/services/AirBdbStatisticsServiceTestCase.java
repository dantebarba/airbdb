package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.config.AppConfig;
import ar.edu.unlp.info.bd2.config.DBInitializerConfig;
import ar.edu.unlp.info.bd2.config.HibernateConfiguration;
import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.utils.DBInitializer;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class, DBInitializerConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
@Rollback(true)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AirBdbStatisticsServiceTestCase {


  @Autowired
  DBInitializer initializer;

  @Autowired
  AirBdbStatisticsService service;

  @BeforeAll
  public void prepareDB() throws Exception {
    this.initializer.prepareDB();
  }

  @Test
  public void testGetAllPropertiesReservedByUserUser() {
    List<Property> properties = this.service.getAllPropertiesReservedByUser("voluptas@massive.net");
    Assert.assertEquals(2, properties.size());
    this.assertListEquality(
      properties.stream().map(property -> property.getName()).collect(Collectors.toList()),
      Arrays.asList("Quia tempora vo", "Veniam, labo"));
  }

  @Test
  public void testGetUsersSpendingMoreThan() {
    List<User> users = this.service.getUsersSpendingMoreThan(1500);
    Assert.assertEquals(1, users.size());
    this.assertListEquality(
      users.stream().map(property -> property.getUsername()).collect(Collectors.toList()),
      Arrays.asList("quae@yahoo.com"));
  }

  @Test
  public void testGetApartmentTop3Ranking() {
    List<Object[]> ranking = this.service.getApartmentTop3Ranking();
    Assert.assertEquals(3, ranking.size());
    Assert.assertEquals("Veniam, labo", ((Apartment)ranking.get(0)[0]).getName());
    Assert.assertEquals(7d, ranking.get(0)[1]);
    Assert.assertEquals("Adipi", ((Apartment)ranking.get(1)[0]).getName());
    Assert.assertEquals(6.5d, ranking.get(1)[1]);
    Assert.assertEquals("Commodi moles", ((Apartment)ranking.get(2)[0]).getName());
    Assert.assertEquals(6d, ranking.get(2)[1]);

  }

  @Test
  public void testGetUsersThatReservedMoreThan1PropertyDuringASpecificYear() {
    List<User> users = this.service.getUsersThatReservedMoreThan1PropertyDuringASpecificYear(2014);
    Assert.assertEquals(2, users.size());
    this.assertListEquality(
      users.stream().map(property -> property.getUsername()).collect(Collectors.toList()),
      Arrays.asList("quae@yahoo.com", "sunt@bd2.edu"));
  }

  @Test
  public void testGetPropertiesThatHaveBeenReservedByMoreThanOneUserWithCapacityMoreThan() {
    List<Property> properties = this.service.getPropertiesThatHaveBeenReservedByMoreThanOneUserWithCapacityMoreThan(4);
    this.assertListEquality(
      properties.stream().map(property -> property.getName()).collect(Collectors.toList()),
      Arrays.asList("Ipsum nesc", "Ut aperiam, ", "Vel qui fugiat", "Esse q", "Iure eos eos", "Ea consectetur", "Veritatis sit", "Eum quia quam n"));
  }

  @Test
  public void testGetCitiesThatHaveReservationsBetween() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<City> cities = this.service.getCitiesThatHaveReservationsBetween(sdf.parse("01/01/2014"), sdf.parse("01/06/2014"));
    this.assertListEquality(
      cities.stream().map(property -> property.getName()).collect(Collectors.toList()),
      Arrays.asList("Córdoba", "Bariloche", "Salta", "La Plata", "Mar del Plata"));
  }

  @Test
  public void testGetReservationsInCitiesForUser() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<Reservation> reservations = this.service.getReservationsInCitiesForUser("eum@me.com", "La Plata");
    Assert.assertEquals(1, reservations.size());
    Assert.assertEquals("Velit", reservations.get(0).getProperty().getName());
  }

  @Test
  public void testGetMostExpensivePrivateRoomReservation() {
    Reservation reservation = this.service.getMostExpensivePrivateRoomReservation();
    Assert.assertEquals(8500d, reservation.getPrice(), 0);
  }

  @Test
  public void testGetHotmailUsersWithAllTheirReservationsFinished() {
    List<String> users = this.service.getHotmailUsersWithAllTheirReservationsFinished();
    this.assertListEquality(
      users,
      Arrays.asList("commodi@hotmail.com", "nihil@hotmail.com", "porro@hotmail.com", "enim@hotmail.com", "voluptatem@hotmail.com"));
  }

  @Test
  public void testGetTotalRevenueForFinishedReservationsDuringYear() {
    Double revenue = this.service.getTotalRevenueForFinishedReservationsDuringYear(2016);
    Assert.assertEquals(4666.0d, revenue.doubleValue(), 0);
  }

  @Test
  public void testGetMatchingUsersThatOnlyHaveReservationsInCities() {
    List<User> users = this.service.getMatchingUsersThatOnlyHaveReservationsInCities("@unlp.edu.ar", "La Plata", "Jujuy");
    this.assertListEquality(
      users.stream().map(property -> property.getUsername()).collect(Collectors.toList()),
      Arrays.asList("adipisci@unlp.edu.ar", "quasi@unlp.edu.ar", "esse@unlp.edu.ar"));

  }

  private <T> void assertListEquality(List<T> list1, List<T> list2) {
    if (list1.size() != list2.size()) {
      Assert.fail("Lists have different size");
    }

    for (T objectInList1 : list1) {
      if (!list2.contains(objectInList1)) {
        Assert.fail(objectInList1 + " is not present in list2");
      }
    }
  }

}
