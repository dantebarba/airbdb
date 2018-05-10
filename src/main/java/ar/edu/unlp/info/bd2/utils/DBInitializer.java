package ar.edu.unlp.info.bd2.utils;

import ar.edu.unlp.info.bd2.model.Property;
import ar.edu.unlp.info.bd2.model.Reservation;
import ar.edu.unlp.info.bd2.model.User;
import ar.edu.unlp.info.bd2.services.AirBdbService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBInitializer {

  @Autowired
  AirBdbService service;

  public void prepareDB() throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Property property001 = this.service.createRoom("Aspernatu", "Sit voluptas non Sed porro velit ", 58.0, 3, 5, "Córdoba");
    Property property002 = this.service.createAparment("Ipsum nesc", "Ipsa labore ullam ea dolorem consequuntur ", 27.0, 1, 5, "Mar del Plata");
    Property property003 = this.service.createAparment("Tempora", "Esse accusantium quis sunt ut bea", 76.0, 1, 2, "Jujuy");
    Property property004 = this.service.createAparment("Aliqui", "Commodi et modi ex aliquid ", 50.0, 4, 1, "Bariloche");
    Property property005 = this.service.createRoom("Sed mi", "Nesciunt aliquid voluptate eius voluptas minima", 59.0, 5, 3, "Mar del Plata");
    Property property006 = this.service.createAparment("Reprehend", "Ea aut enim quae qui corporis exercitationem volu", 64.0, 3, 1, "Córdoba");
    Property property007 = this.service.createRoom("Accusanti", "Pariatur voluptatem volup", 55.0, 2, 3, "Mar del Plata");
    Property property008 = this.service.createAparment("Adipi", "Quia numquam laudantium, illo consequ", 64.0, 5, 1, "Rosario");
    Property property009 = this.service.createRoom("Nulla eaque ", "Voluptas tempora nesciunt iure vitae m", 81.0, 1, 1, "Rosario");
    Property property010 = this.service.createRoom("Nemo perspici", "Dolorem sed sit non amet quaerat consecte", 76.0, 2, 4, "Ushuaia");
    Property property011 = this.service.createRoom("Et eaque ", "Voluptate enim vitae sit amet in ea unde", 88.0, 3, 3, "Buenos Aires");
    Property property012 = this.service.createRoom("Enim reprehen", "Dolore quisquam voluptatem aut consequatur quia", 62.0, 3, 4, "Buenos Aires");
    Property property013 = this.service.createRoom("Voluptas nostru", "Quia quaerat totam volup", 41.0, 3, 5, "Mar del Plata");
    Property property014 = this.service.createAparment("Commodi moles", "Voluptatem sed ipsum nu", 50.0, 2, 1, "Córdoba");
    Property property015 = this.service.createRoom("Velit", "Sed dolorem nemo neque ", 65.0, 3, 2, "La Plata");
    Property property016 = this.service.createRoom("Voluptas ", "Sit aut inventore voluptatem rem velit aliquam v", 46.0, 5, 1, "Ushuaia");
    Property property017 = this.service.createAparment("Aperiam, illum", "Quia aliquam ad corporis", 85.0, 5, 4, "Ushuaia");
    Property property018 = this.service.createRoom("Quis verit", "Dolore accusantium numquam sed qui", 23.0, 1, 4, "Bariloche");
    Property property019 = this.service.createAparment("Quasi sit", "Ea ut consequatur ut", 63.0, 1, 4, "Córdoba");
    Property property020 = this.service.createRoom("Quia vitae eius", "Eos dolorem error autem illum e", 70.0, 3, 4, "La Plata");
    Property property021 = this.service.createRoom("Sit error", "Ut ad modi aliquam ipsum numquam eum ea corpori", 89.0, 1, 1, "La Plata");
    Property property022 = this.service.createRoom("Ad ab autem pers", "Eum voluptatem qui voluptat", 60.0, 3, 3, "Buenos Aires");
    Property property023 = this.service.createRoom("Illo eaque ist", "Natus aut quasi illo voluptas aspernatu", 44.0, 3, 5, "La Plata");
    Property property024 = this.service.createAparment("Magnam null", "Veritatis voluptas q", 71.0, 2, 3, "La Plata");
    Property property025 = this.service.createAparment("Ut quia volupta", "Umnt ipsum consequatur sunt eos dolo", 85.0, 1, 4, "Mar del Plata");
    Property property026 = this.service.createRoom("Velit quae sit s", "Nesciunt aliquid non sequi incid", 75.0, 2, 5, "Salta");
    Property property027 = this.service.createRoom("Esse q", "Voluptatem porro Sed accusantium ", 45.0, 5, 4, "Mar del Plata");
    Property property028 = this.service.createRoom("Quia enim", "Ratione veritatis nesciunt quisquam lau", 83.0, 2, 2, "Jujuy");
    Property property029 = this.service.createRoom("Sit sequ", "Amet numquam nisi ipsa dolores illum doloremque a", 30.0, 2, 1, "La Plata");
    Property property030 = this.service.createAparment("Voluptatem nih", "Eaque quis enim numquam suscipit ", 46.0, 2, 3, "Rosario");
    Property property031 = this.service.createAparment("Aut ar", "Pariatur velit qui mo", 69.0, 2, 4, "La Plata");
    Property property032 = this.service.createRoom("Vitae ration", "Eius velit enim voluptatem ratione enim ut vo", 54.0, 4, 5, "Bariloche");
    Property property033 = this.service.createAparment("Aut eum", "Sunt fugit reprehenderit ipsa ip", 29.0, 3, 1, "Mar del Plata");
    Property property034 = this.service.createAparment("Voluptate", "Omnis eaque ipsam aperiam, perspiciatis unde vol", 98.0, 5, 4, "Córdoba");
    Property property035 = this.service.createRoom("Tempo", "Ea voluptas exercitationem consectetur ", 98.0, 4, 4, "Córdoba");
    Property property036 = this.service.createRoom("Commodi qu", "Consectetur non accusantium suscipit voluptatem ", 74.0, 5, 2, "Mar del Plata");
    Property property037 = this.service.createAparment("Nihil consectet", "Incidunt totam amet quia exercitationem laboriosam", 69.0, 1, 5, "Salta");
    Property property038 = this.service.createAparment("Incidunt quia e", "Laboriosam qui commodi ab", 27.0, 2, 3, "Ushuaia");
    Property property039 = this.service.createRoom("Eum nulla volup", "Consequuntur ratione nulla sit pariatur tot", 85.0, 2, 3, "Mar del Plata");
    Property property040 = this.service.createRoom("Ipsa voluptatem ", "Quam consequuntur ut moles", 40.0, 1, 5, "Mar del Plata");
    Property property041 = this.service.createAparment("Nostrum", "Quia illo quo eum labore exercitat", 40.0, 1, 1, "Buenos Aires");
    Property property042 = this.service.createRoom("Quia m", "Velit totam sit natus est ut ipsam iur", 26.0, 5, 5, "La Plata");
    Property property043 = this.service.createAparment("Vel qui fugiat", "Voluptatem sunt velit veniam, sit consectetur", 37.0, 2, 5, "Salta");
    Property property044 = this.service.createRoom("Voluptate", "Quae voluptatem eum et ", 20.0, 5, 1, "La Plata");
    Property property045 = this.service.createAparment("Nulla q", "Aliquid pariatur exercitationem eius sed e", 34.0, 3, 2, "Mar del Plata");
    Property property046 = this.service.createAparment("Veniam, labo", "Sit qui magni vitae voluptate nemo iure pariat", 25.0, 1, 2, "Rosario");
    Property property047 = this.service.createAparment("Rem accusantium ", "Sed aspernatur odit perspiciatis qui sunt", 94.0, 3, 1, "Córdoba");
    Property property048 = this.service.createAparment("Quia tempora vo", "Autem vitae nemo quia iure quia autem quo aliqua", 30.0, 4, 3, "Mar del Plata");
    Property property049 = this.service.createRoom("Porro un", "Ea magni accusantium voluptatem amet e", 86.0, 3, 4, "Mar del Plata");
    Property property050 = this.service.createRoom("Aperiam, ip", "Consectetur voluptatem ", 24.0, 1, 5, "Rosario");
    Property property051 = this.service.createAparment("Exercitationem n", "Ipsam nesciunt inventore quia dolorem qui", 81.0, 4, 3, "Jujuy");
    Property property052 = this.service.createAparment("Dolor no", "Aperiam, incidunt aut neque amet", 21.0, 2, 2, "Ushuaia");
    Property property053 = this.service.createAparment("Enim vel nost", "Quo voluptas accusantium ", 61.0, 4, 1, "Córdoba");
    Property property054 = this.service.createRoom("Aperiam, ea ex", "Suscipit eum suscipit modi architecto nulla asp", 50.0, 3, 4, "Bariloche");
    Property property055 = this.service.createRoom("Odit nemo quia n", "Velit suscipit labor", 71.0, 2, 4, "Buenos Aires");
    Property property056 = this.service.createAparment("Corpo", "Nihil suscipit veritatis dolorem esse qui quas", 98.0, 1, 3, "Bariloche");
    Property property057 = this.service.createRoom("Magnam commod", "Porro amet omnis quia totam dolores quae ", 77.0, 5, 2, "Rosario");
    Property property058 = this.service.createRoom("Eum quia quam n", "Consequatur ea vel labore consequuntur ac", 65.0, 5, 5, "Córdoba");
    Property property059 = this.service.createAparment("Sit odit qu", "Quis molestiae aperiam,", 43.0, 2, 2, "Rosario");
    Property property060 = this.service.createRoom("Sit dolores tot", "Quam ipsa nisi ut veniam, veniam, enim labori", 35.0, 2, 2, "Buenos Aires");
    Property property061 = this.service.createAparment("Aspernatur adi", "Voluptas aperiam, ut ab illo ut omnis est vel rem", 96.0, 3, 4, "La Plata");
    Property property062 = this.service.createAparment("Quia ex est e", "Tempora aperiam, esse", 62.0, 4, 1, "Jujuy");
    Property property063 = this.service.createAparment("Pariatur la", "Fugit commodi et esse voluptate", 84.0, 3, 3, "Rosario");
    Property property064 = this.service.createAparment("Iure eos eos", "Omnis labore porro quia in", 84.0, 5, 5, "Salta");
    Property property065 = this.service.createRoom("Quaerat est", "Sed Sed quia inventore dolorem doloremque rem ", 46.0, 4, 1, "Bariloche");
    Property property066 = this.service.createRoom("Veritatis sit", "Tempora magnam amet amet exercitationem dolor ", 71.0, 5, 5, "Bariloche");
    Property property067 = this.service.createRoom("Reprehenderit d", "Ab ipsa quis dolores ullam iste co", 82.0, 3, 3, "Rosario");
    Property property068 = this.service.createRoom("Ipsa aliq", "Quis ipsum vel sed dicta dicta accusantium", 72.0, 3, 3, "Ushuaia");
    Property property069 = this.service.createRoom("Ut aperiam, ", "Vitae sed molestiae iure eius eius", 56.0, 5, 1, "Mar del Plata");
    Property property070 = this.service.createAparment("Ea nemo inc", "Suscipit pariatur qui in", 65.0, 3, 3, "Salta");
    Property property071 = this.service.createRoom("Quaer", "Quis magnam ex et quia qui incidunt omnis", 46.0, 4, 5, "Mar del Plata");
    Property property072 = this.service.createAparment("Veniam, sed en", "Vel nesciunt voluptas et con", 69.0, 2, 2, "Buenos Aires");
    Property property073 = this.service.createAparment("Nihil", "Sed quae qui velit ut dolorem", 37.0, 4, 1, "Córdoba");
    Property property074 = this.service.createAparment("Sed adipi", "Eos quaerat et neque exercitationem", 34.0, 4, 1, "Córdoba");
    Property property075 = this.service.createRoom("Eaque paria", "Qui et sit quam laboriosam dolores aspernatur v", 850, 3, 2, "Córdoba");
    Property property076 = this.service.createAparment("Quaerat", "Fugiat omnis porro quia voluptatem et quia si", 76.0, 4, 2, "La Plata");
    Property property077 = this.service.createRoom("Veritatis ab s", "Sit ipsum vel voluptate", 62.0, 3, 2, "Bariloche");
    Property property078 = this.service.createRoom("Ea qui fugi", "Dolorem ipsam architecto velit pariatur pariatur i", 24.0, 3, 3, "La Plata");
    Property property079 = this.service.createAparment("Ea consectetur", "Incidunt aspernatur ei", 56.0, 1, 5, "Jujuy");
    Property property080 = this.service.createRoom("Doloremque qui", "Non tempora pariatur odi", 98.0, 1, 3, "La Plata");
    Property property081 = this.service.createRoom("Sort narf", "Qui et sit quam laboriosam dolores aspernatur v", 700, 3, 2, "Córdoba");
    User user001 = this.service.createUser("quae@yahoo.com", "quae");
    User user002 = this.service.createUser("quo@unlp.edu.ar", "quo");
    User user003 = this.service.createUser("nesciunt@gmail.com", "nesciunt");
    User user004 = this.service.createUser("velit@bd2.edu", "velit");
    User user005 = this.service.createUser("dolor@yahoo.com", "dolor");
    User user006 = this.service.createUser("commodi@hotmail.com", "commodi");
    User user007 = this.service.createUser("nihil@hotmail.com", "nihil");
    User user008 = this.service.createUser("consectetur@hotmail.com", "consectetur");
    User user009 = this.service.createUser("quia@outlook.com", "quia");
    User user010 = this.service.createUser("in@yahoo.com", "in");
    User user011 = this.service.createUser("veritatis@gmail.com", "veritatis");
    User user012 = this.service.createUser("magnam@hotmail.com", "magnam");
    User user013 = this.service.createUser("sunt@bd2.edu", "sunt");
    User user014 = this.service.createUser("ut@massive.net", "ut");
    User user015 = this.service.createUser("sed@outlook.com", "sed");
    User user016 = this.service.createUser("consequuntur@bd2.edu", "consequuntur");
    User user017 = this.service.createUser("ad@unlp.edu.ar", "ad");
    User user018 = this.service.createUser("adipisci@unlp.edu.ar", "adipisci");
    User user019 = this.service.createUser("consectetur@yahoo.com", "consectetur");
    User user020 = this.service.createUser("voluptas@massive.net", "voluptas");
    User user021 = this.service.createUser("vel@bd2.edu", "vel");
    User user022 = this.service.createUser("quia@gmail.com", "quia");
    User user023 = this.service.createUser("fugiat@outlook.com", "fugiat");
    User user024 = this.service.createUser("voluptas@info.edu", "voluptas");
    User user025 = this.service.createUser("unde@outlook.com", "unde");
    User user026 = this.service.createUser("magnam@bd2.edu", "magnam");
    User user027 = this.service.createUser("aut@info.edu", "aut");
    User user028 = this.service.createUser("porro@hotmail.com", "porro");
    User user029 = this.service.createUser("fugit@bd2.edu", "fugit");
    User user030 = this.service.createUser("ut@me.com", "ut");
    User user031 = this.service.createUser("quae@info.edu", "quae");
    User user032 = this.service.createUser("ad@info.edu", "ad");
    User user033 = this.service.createUser("ut@unlp.edu.ar", "ut");
    User user034 = this.service.createUser("enim@info.edu", "enim");
    User user035 = this.service.createUser("dolore@info.edu", "dolore");
    User user036 = this.service.createUser("sit@outlook.com", "sit");
    User user037 = this.service.createUser("eum@me.com", "eum");
    User user038 = this.service.createUser("dicta@hotmail.com", "dicta");
    User user039 = this.service.createUser("illo@bd2.edu", "illo");
    User user040 = this.service.createUser("eum@unlp.edu.ar", "eum");
    User user041 = this.service.createUser("fugit@unlp.edu.ar", "fugit");
    User user042 = this.service.createUser("quae@massive.net", "quae");
    User user043 = this.service.createUser("nihil@massive.net", "nihil");
    User user044 = this.service.createUser("quasi@unlp.edu.ar", "quasi");
    User user045 = this.service.createUser("esse@unlp.edu.ar", "esse");
    User user046 = this.service.createUser("laboriosam@gmail.com", "laboriosam");
    User user047 = this.service.createUser("quisquam@fruit.net", "quisquam");
    User user048 = this.service.createUser("enim@hotmail.com", "enim");
    User user049 = this.service.createUser("voluptas@yahoo.com", "voluptas");
    User user050 = this.service.createUser("voluptatem@hotmail.com", "voluptatem");
    User user051 = this.service.createUser("consequuntur@outlook.com", "consequuntur");
    User user052 = this.service.createUser("incidunt@fruit.net", "incidunt");
    User user053 = this.service.createUser("sit@fruit.net", "sit");
    User user054 = this.service.createUser("ea@fruit.net", "ea");
    User user055 = this.service.createUser("modi@yahoo.com", "modi");
    User user056 = this.service.createUser("eum@bd2.edu", "eum");
    User user057 = this.service.createUser("rem@massive.net", "rem");
    User user058 = this.service.createUser("dicta@yahoo.com", "dicta");
    User user059 = this.service.createUser("ratione@massive.net", "ratione");
    User user060 = this.service.createUser("voluptatem@yahoo.com", "voluptatem");
    User user061 = this.service.createUser("perspiciatis@hotmail.com", "perspiciatis");
    User user062 = this.service.createUser("architecto@info.edu", "architecto");
    User user063 = this.service.createUser("quia@info.edu", "quia");
    User user064 = this.service.createUser("est@bd2.edu", "est");
    User user065 = this.service.createUser("sit@gmail.com", "sit");
    User user066 = this.service.createUser("numquam@yahoo.com", "numquam");
    User user067 = this.service.createUser("ut@info.edu", "ut");
    User user068 = this.service.createUser("ab@yahoo.com", "ab");
    User user069 = this.service.createUser("ex@yahoo.com", "ex");
    User user070 = this.service.createUser("sunt@fruit.net", "sunt");
    User user071 = this.service.createUser("ullam@yahoo.com", "ullam");
    User user072 = this.service.createUser("dolores@info.edu", "dolores");
    User user073 = this.service.createUser("ullam@fruit.net", "ullam");
    User user074 = this.service.createUser("consequuntur@unlp.edu.ar", "consequuntur");
    User user075 = this.service.createUser("sit@outlook.com", "sit");
    User user076 = this.service.createUser("vitae@gmail.com", "vitae");
    User user077 = this.service.createUser("labore@fruit.net", "labore");
    User user078 = this.service.createUser("nihil@hotmail.com", "nihil");
    User user079 = this.service.createUser("natus@outlook.com", "natus");
    User user080 = this.service.createUser("qui@info.edu", "qui");
    Date from001 = sdf.parse("1/9/2013");
    Date to001 = sdf.parse("9/9/2013");
    Reservation reservation001 = this.service.createReservation(property002.getId(), user006.getId(), from001, to001);
    this.service.finishReservation(reservation001.getId());
    this.service.rateReservation(reservation001.getId(), 5, "scelerisque tortor Donec ac massa nisl cursus massa Praesent commodo ut ");

    Date from002 = sdf.parse("16/12/2010");
    Date to002 = sdf.parse("20/12/2010");
    Reservation reservation002 = this.service.createReservation(property059.getId(), user079.getId(), from002, to002);
    this.service.finishReservation(reservation002.getId());
    this.service.rateReservation(reservation002.getId(), 4, "commodo condimentum Praesent magna, tellus Donec odio cursus condimentum commodo cursus ");

    Date from003 = sdf.parse("15/8/2014");
    Date to003 = sdf.parse("23/8/2014");
    Reservation reservation003 = this.service.createReservation(property008.getId(), user057.getId(), from003, to003);
    this.service.finishReservation(reservation003.getId());
    this.service.rateReservation(reservation003.getId(), 3, "Donec Fusce tellus tortor amet nibh, Praesent et. ut Fusce ");

    Date from004 = sdf.parse("14/9/2010");
    Date to004 = sdf.parse("16/9/2010");
    Reservation reservation004 = this.service.createReservation(property069.getId(), user077.getId(), from004, to004);
    this.service.finishReservation(reservation004.getId());
    this.service.rateReservation(reservation004.getId(), 5, "nibh, mauris Praesent consectetur justo magna, et. nisl consectetur vel condimentum ");

    Date from005 = sdf.parse("7/6/2012");
    Date to005 = sdf.parse("14/6/2012");
    Reservation reservation005 = this.service.createReservation(property030.getId(), user062.getId(), from005, to005);
    this.service.finishReservation(reservation005.getId());
    this.service.rateReservation(reservation005.getId(), 1, "massa risus. cursus et. dapibus, dui. sit massa risus. sit consectetur ");

    Date from006 = sdf.parse("3/3/2013");
    Date to006 = sdf.parse("13/3/2013");
    Reservation reservation006 = this.service.createReservation(property073.getId(), user053.getId(), from006, to006);
    this.service.finishReservation(reservation006.getId());
    this.service.rateReservation(reservation006.getId(), 1, "fermentum dui. Fusce vel scelerisque scelerisque nibh, nisl commodo, consectetur ");

    Date from007 = sdf.parse("24/12/2011");
    Date to007 = sdf.parse("29/12/2011");
    Reservation reservation007 = this.service.createReservation(property053.getId(), user065.getId(), from007, to007);
    this.service.finishReservation(reservation007.getId());
    this.service.rateReservation(reservation007.getId(), 1, "Praesent tellus sed Fusce condimentum magna, Praesent cursus nibh, commodo, odio ");

    Date from008 = sdf.parse("25/1/2015");
    Date to008 = sdf.parse("2/2/2015");
    Reservation reservation008 = this.service.createReservation(property078.getId(), user063.getId(), from008, to008);

    Date from009 = sdf.parse("22/7/2012");
    Date to009 = sdf.parse("28/7/2012");
    Reservation reservation009 = this.service.createReservation(property043.getId(), user061.getId(), from009, to009);
    this.service.finishReservation(reservation009.getId());
    this.service.rateReservation(reservation009.getId(), 5, "commodo vel Fusce ac odio Donec commodo tellus sit justo ");

    Date from010 = sdf.parse("11/4/2016");
    Date to010 = sdf.parse("12/4/2016");
    Reservation reservation010 = this.service.createReservation(property027.getId(), user043.getId(), from010, to010);
    this.service.finishReservation(reservation010.getId());
    this.service.rateReservation(reservation010.getId(), 1, "nisl cursus nibh, condimentum vel nisl dapibus, tortor mauris commodo ");

    Date from011 = sdf.parse("8/9/2013");
    Date to011 = sdf.parse("9/9/2013");
    Reservation reservation011 = this.service.createReservation(property048.getId(), user020.getId(), from011, to011);

    Date from012 = sdf.parse("8/3/2015");
    Date to012 = sdf.parse("16/3/2015");
    Reservation reservation012 = this.service.createReservation(property018.getId(), user021.getId(), from012, to012);
    this.service.finishReservation(reservation012.getId());
    this.service.rateReservation(reservation012.getId(), 4, "magna, fermentum amet Fusce nisl et. dui. risus. ac Fusce commodo ");

    Date from013 = sdf.parse("23/3/2012");
    Date to013 = sdf.parse("30/3/2012");
    Reservation reservation013 = this.service.createReservation(property007.getId(), user013.getId(), from013, to013);
    this.service.finishReservation(reservation013.getId());
    this.service.rateReservation(reservation013.getId(), 3, "amet ac tortor justo Donec condimentum ac scelerisque nibh, vel tellus ");

    Date from014 = sdf.parse("5/7/2015");
    Date to014 = sdf.parse("9/7/2015");
    Reservation reservation014 = this.service.createReservation(property077.getId(), user003.getId(), from014, to014);
    this.service.finishReservation(reservation014.getId());
    this.service.rateReservation(reservation014.getId(), 4, "sit dui. sed sed fermentum cursus scelerisque justo nibh, sed sed vel ");

    Date from015 = sdf.parse("1/11/2011");
    Date to015 = sdf.parse("8/11/2011");
    Reservation reservation015 = this.service.createReservation(property070.getId(), user027.getId(), from015, to015);
    this.service.finishReservation(reservation015.getId());
    this.service.rateReservation(reservation015.getId(), 5, "justo risus. commodo, consectetur risus. tellus tellus condimentum scelerisque amet Fusce ");

    Date from016 = sdf.parse("10/4/2015");
    Date to016 = sdf.parse("20/4/2015");
    Reservation reservation016 = this.service.createReservation(property041.getId(), user041.getId(), from016, to016);
    this.service.finishReservation(reservation016.getId());
    this.service.rateReservation(reservation016.getId(), 3, "Donec vel risus. tortor ut consectetur Praesent Donec ac vel ");

    Date from017 = sdf.parse("28/1/2011");
    Date to017 = sdf.parse("29/1/2011");
    Reservation reservation017 = this.service.createReservation(property025.getId(), user038.getId(), from017, to017);
    this.service.finishReservation(reservation017.getId());
    this.service.rateReservation(reservation017.getId(), 3, "Praesent cursus scelerisque condimentum amet justo Donec tortor amet commodo, dui. nibh, ");

    Date from018 = sdf.parse("26/2/2016");
    Date to018 = sdf.parse("27/2/2016");
    Reservation reservation018 = this.service.createReservation(property076.getId(), user068.getId(), from018, to018);
    this.service.finishReservation(reservation018.getId());
    this.service.rateReservation(reservation018.getId(), 1, "Praesent scelerisque justo sit ut commodo Donec Praesent amet odio cursus massa ");

    Date from019 = sdf.parse("10/2/2016");
    Date to019 = sdf.parse("15/2/2016");
    Reservation reservation019 = this.service.createReservation(property003.getId(), user024.getId(), from019, to019);
    this.service.finishReservation(reservation019.getId());
    this.service.rateReservation(reservation019.getId(), 3, "Praesent scelerisque cursus Fusce dui. tellus Praesent cursus sed et. ac ");

    Date from020 = sdf.parse("7/3/2011");
    Date to020 = sdf.parse("9/3/2011");
    Reservation reservation020 = this.service.createReservation(property046.getId(), user029.getId(), from020, to020);
    this.service.finishReservation(reservation020.getId());
    this.service.rateReservation(reservation020.getId(), 8, "tellus Praesent fermentum justo nisl vel cursus condimentum dui. et. Donec ");

    Date from021 = sdf.parse("4/5/2010");
    Date to021 = sdf.parse("14/5/2010");
    Reservation reservation021 = this.service.createReservation(property020.getId(), user067.getId(), from021, to021);
    this.service.finishReservation(reservation021.getId());
    this.service.rateReservation(reservation021.getId(), 3, "dapibus, commodo magna, condimentum sed dui. magna, vel Praesent consectetur ");

    Date from022 = sdf.parse("12/7/2014");
    Date to022 = sdf.parse("22/7/2014");
    Reservation reservation022 = this.service.createReservation(property074.getId(), user075.getId(), from022, to022);
    this.service.finishReservation(reservation022.getId());
    this.service.rateReservation(reservation022.getId(), 1, "ut nisl sed commodo, et. Praesent Donec sed cursus ut nibh, ac ");

    Date from023 = sdf.parse("9/9/2016");
    Date to023 = sdf.parse("19/9/2016");
    Reservation reservation023 = this.service.createReservation(property060.getId(), user034.getId(), from023, to023);

    Date from024 = sdf.parse("21/3/2015");
    Date to024 = sdf.parse("23/3/2015");
    Reservation reservation024 = this.service.createReservation(property064.getId(), user047.getId(), from024, to024);

    Date from025 = sdf.parse("10/4/2015");
    Date to025 = sdf.parse("19/4/2015");
    Reservation reservation025 = this.service.createReservation(property072.getId(), user080.getId(), from025, to025);
    this.service.finishReservation(reservation025.getId());
    this.service.rateReservation(reservation025.getId(), 4, "amet dapibus, commodo, dapibus, mauris vel odio fermentum ut tellus et. ");

    Date from026 = sdf.parse("7/7/2011");
    Date to026 = sdf.parse("17/7/2011");
    Reservation reservation026 = this.service.createReservation(property061.getId(), user076.getId(), from026, to026);
    this.service.finishReservation(reservation026.getId());
    this.service.rateReservation(reservation026.getId(), 5, "nibh, tellus commodo commodo amet nibh, massa cursus justo scelerisque vel nisl ");

    Date from027 = sdf.parse("16/7/2015");
    Date to027 = sdf.parse("26/7/2015");
    Reservation reservation027 = this.service.createReservation(property063.getId(), user001.getId(), from027, to027);
    this.service.finishReservation(reservation027.getId());
    this.service.rateReservation(reservation027.getId(), 1, "commodo, risus. et. commodo justo commodo Fusce sit sit massa ");

    Date from028 = sdf.parse("7/10/2014");
    Date to028 = sdf.parse("15/10/2014");
    Reservation reservation028 = this.service.createReservation(property035.getId(), user064.getId(), from028, to028);

    Date from029 = sdf.parse("18/8/2011");
    Date to029 = sdf.parse("26/8/2011");
    Reservation reservation029 = this.service.createReservation(property023.getId(), user040.getId(), from029, to029);

    Date from030 = sdf.parse("1/12/2016");
    Date to030 = sdf.parse("6/12/2016");
    Reservation reservation030 = this.service.createReservation(property079.getId(), user078.getId(), from030, to030);
    this.service.finishReservation(reservation030.getId());
    this.service.rateReservation(reservation030.getId(), 3, "cursus tortor Praesent Donec sit Praesent justo cursus amet amet ");

    Date from031 = sdf.parse("22/11/2016");
    Date to031 = sdf.parse("25/11/2016");
    Reservation reservation031 = this.service.createReservation(property068.getId(), user056.getId(), from031, to031);
    this.service.finishReservation(reservation031.getId());
    this.service.rateReservation(reservation031.getId(), 4, "vel dapibus, justo nisl justo fermentum amet sit justo mauris ");

    Date from032 = sdf.parse("3/2/2011");
    Date to032 = sdf.parse("4/2/2011");
    Reservation reservation032 = this.service.createReservation(property066.getId(), user015.getId(), from032, to032);

    Date from033 = sdf.parse("4/12/2011");
    Date to033 = sdf.parse("11/12/2011");
    Reservation reservation033 = this.service.createReservation(property011.getId(), user007.getId(), from033, to033);
    this.service.finishReservation(reservation033.getId());
    this.service.rateReservation(reservation033.getId(), 1, "commodo et. dapibus, consectetur tellus sit odio tellus Praesent tortor ");

    Date from034 = sdf.parse("20/1/2016");
    Date to034 = sdf.parse("24/1/2016");
    Reservation reservation034 = this.service.createReservation(property028.getId(), user031.getId(), from034, to034);
    this.service.finishReservation(reservation034.getId());
    this.service.rateReservation(reservation034.getId(), 3, "condimentum odio consectetur tellus tellus amet et. justo commodo, amet ");

    Date from035 = sdf.parse("17/9/2010");
    Date to035 = sdf.parse("24/9/2010");
    Reservation reservation035 = this.service.createReservation(property050.getId(), user049.getId(), from035, to035);
    this.service.finishReservation(reservation035.getId());
    this.service.rateReservation(reservation035.getId(), 1, "Praesent magna, et. magna, sed ac justo cursus sit Praesent ");

    Date from036 = sdf.parse("1/7/2015");
    Date to036 = sdf.parse("8/7/2015");
    Reservation reservation036 = this.service.createReservation(property049.getId(), user025.getId(), from036, to036);

    Date from037 = sdf.parse("25/4/2012");
    Date to037 = sdf.parse("1/5/2012");
    Reservation reservation037 = this.service.createReservation(property026.getId(), user035.getId(), from037, to037);
    this.service.finishReservation(reservation037.getId());
    this.service.rateReservation(reservation037.getId(), 5, "mauris vel ut cursus cursus magna, magna, tellus Fusce risus. consectetur commodo ");

    Date from038 = sdf.parse("20/1/2014");
    Date to038 = sdf.parse("30/1/2014");
    Reservation reservation038 = this.service.createReservation(property058.getId(), user042.getId(), from038, to038);
    this.service.finishReservation(reservation038.getId());
    this.service.rateReservation(reservation038.getId(), 1, "massa magna, odio risus. massa commodo, magna, et. odio tellus risus. commodo, ");

    Date from039 = sdf.parse("1/10/2013");
    Date to039 = sdf.parse("5/10/2013");
    Reservation reservation039 = this.service.createReservation(property010.getId(), user033.getId(), from039, to039);
    this.service.finishReservation(reservation039.getId());
    this.service.rateReservation(reservation039.getId(), 5, "Fusce fermentum Donec vel justo dapibus, magna, Praesent amet risus. nibh, ");

    Date from040 = sdf.parse("1/5/2016");
    Date to040 = sdf.parse("2/5/2016");
    Reservation reservation040 = this.service.createReservation(property029.getId(), user018.getId(), from040, to040);
    this.service.finishReservation(reservation040.getId());
    this.service.rateReservation(reservation040.getId(), 3, "sit commodo, dui. Praesent sed sed commodo, nibh, vel ut et. ");

    Date from041 = sdf.parse("17/2/2012");
    Date to041 = sdf.parse("25/2/2012");
    Reservation reservation041 = this.service.createReservation(property043.getId(), user004.getId(), from041, to041);
    this.service.finishReservation(reservation041.getId());
    this.service.rateReservation(reservation041.getId(), 2, "consectetur commodo, vel ut nibh, sit scelerisque consectetur cursus Fusce ");

    Date from042 = sdf.parse("19/12/2011");
    Date to042 = sdf.parse("23/12/2011");
    Reservation reservation042 = this.service.createReservation(property056.getId(), user043.getId(), from042, to042);
    this.service.finishReservation(reservation042.getId());
    this.service.rateReservation(reservation042.getId(), 3, "tellus consectetur justo tellus risus. commodo, dapibus, justo scelerisque fermentum sit ");

    Date from043 = sdf.parse("1/9/2016");
    Date to043 = sdf.parse("6/9/2016");
    Reservation reservation043 = this.service.createReservation(property038.getId(), user007.getId(), from043, to043);
    this.service.finishReservation(reservation043.getId());
    this.service.rateReservation(reservation043.getId(), 4, "sit ac magna, dapibus, risus. ac condimentum Donec sed dapibus, ut ");

    Date from044 = sdf.parse("5/8/2012");
    Date to044 = sdf.parse("12/8/2012");
    Reservation reservation044 = this.service.createReservation(property013.getId(), user046.getId(), from044, to044);
    this.service.finishReservation(reservation044.getId());
    this.service.rateReservation(reservation044.getId(), 5, "justo Fusce sit condimentum ut magna, ac sit vel commodo dui. et. ");

    Date from045 = sdf.parse("17/1/2011");
    Date to045 = sdf.parse("26/1/2011");
    Reservation reservation045 = this.service.createReservation(property027.getId(), user069.getId(), from045, to045);
    this.service.finishReservation(reservation045.getId());
    this.service.rateReservation(reservation045.getId(), 4, "sit consectetur tellus magna, sed consectetur et. Praesent scelerisque consectetur ");

    Date from046 = sdf.parse("5/2/2012");
    Date to046 = sdf.parse("11/2/2012");
    Reservation reservation046 = this.service.createReservation(property022.getId(), user061.getId(), from046, to046);

    Date from047 = sdf.parse("17/9/2010");
    Date to047 = sdf.parse("24/9/2010");
    Reservation reservation047 = this.service.createReservation(property002.getId(), user074.getId(), from047, to047);

    Date from048 = sdf.parse("26/11/2014");
    Date to048 = sdf.parse("3/12/2014");
    Reservation reservation048 = this.service.createReservation(property053.getId(), user051.getId(), from048, to048);

    Date from049 = sdf.parse("13/6/2014");
    Date to049 = sdf.parse("16/6/2014");
    Reservation reservation049 = this.service.createReservation(property068.getId(), user050.getId(), from049, to049);
    this.service.finishReservation(reservation049.getId());
    this.service.rateReservation(reservation049.getId(), 1, "dui. tellus commodo tellus odio fermentum dui. mauris Praesent cursus dui. ");

    Date from050 = sdf.parse("20/10/2014");
    Date to050 = sdf.parse("26/10/2014");
    Reservation reservation050 = this.service.createReservation(property015.getId(), user045.getId(), from050, to050);
    this.service.finishReservation(reservation050.getId());
    this.service.rateReservation(reservation050.getId(), 1, "commodo magna, mauris Praesent tortor fermentum ut tortor odio massa ");

    Date from051 = sdf.parse("19/1/2015");
    Date to051 = sdf.parse("23/1/2015");
    Reservation reservation051 = this.service.createReservation(property020.getId(), user039.getId(), from051, to051);
    this.service.finishReservation(reservation051.getId());
    this.service.rateReservation(reservation051.getId(), 4, "dui. magna, sit sed tellus mauris massa amet Fusce dapibus, ");

    Date from052 = sdf.parse("28/7/2015");
    Date to052 = sdf.parse("30/7/2015");
    Reservation reservation052 = this.service.createReservation(property010.getId(), user003.getId(), from052, to052);

    Date from053 = sdf.parse("9/2/2014");
    Date to053 = sdf.parse("11/2/2014");
    Reservation reservation053 = this.service.createReservation(property061.getId(), user030.getId(), from053, to053);
    this.service.finishReservation(reservation053.getId());
    this.service.rateReservation(reservation053.getId(), 3, "nisl vel odio et. tellus Praesent Praesent sed odio odio commodo, ");

    Date from054 = sdf.parse("24/4/2015");
    Date to054 = sdf.parse("27/4/2015");
    Reservation reservation054 = this.service.createReservation(property073.getId(), user021.getId(), from054, to054);
    this.service.finishReservation(reservation054.getId());
    this.service.rateReservation(reservation054.getId(), 2, "magna, massa commodo condimentum cursus consectetur nibh, odio condimentum vel vel magna, ");

    Date from055 = sdf.parse("12/3/2013");
    Date to055 = sdf.parse("22/3/2013");
    Reservation reservation055 = this.service.createReservation(property036.getId(), user055.getId(), from055, to055);

    Date from056 = sdf.parse("23/4/2012");
    Date to056 = sdf.parse("24/4/2012");
    Reservation reservation056 = this.service.createReservation(property037.getId(), user017.getId(), from056, to056);
    this.service.finishReservation(reservation056.getId());
    this.service.rateReservation(reservation056.getId(), 4, "magna, cursus tortor tellus nisl ac massa tortor Praesent sit condimentum commodo, ");

    Date from057 = sdf.parse("10/11/2012");
    Date to057 = sdf.parse("13/11/2012");
    Reservation reservation057 = this.service.createReservation(property033.getId(), user033.getId(), from057, to057);
    this.service.finishReservation(reservation057.getId());
    this.service.rateReservation(reservation057.getId(), 2, "ut Praesent dapibus, massa ac massa consectetur justo commodo cursus sit dui. ");

    Date from058 = sdf.parse("12/3/2014");
    Date to058 = sdf.parse("14/3/2014");
    Reservation reservation058 = this.service.createReservation(property039.getId(), user006.getId(), from058, to058);
    this.service.finishReservation(reservation058.getId());
    this.service.rateReservation(reservation058.getId(), 2, "vel dapibus, sed Praesent condimentum ut mauris justo ac nibh, ");

    Date from059 = sdf.parse("17/7/2012");
    Date to059 = sdf.parse("26/7/2012");
    Reservation reservation059 = this.service.createReservation(property003.getId(), user008.getId(), from059, to059);

    Date from060 = sdf.parse("6/7/2015");
    Date to060 = sdf.parse("9/7/2015");
    Reservation reservation060 = this.service.createReservation(property016.getId(), user019.getId(), from060, to060);
    this.service.finishReservation(reservation060.getId());
    this.service.rateReservation(reservation060.getId(), 2, "amet dapibus, commodo, tortor ut scelerisque tellus risus. cursus vel ");

    Date from061 = sdf.parse("1/2/2015");
    Date to061 = sdf.parse("8/2/2015");
    Reservation reservation061 = this.service.createReservation(property047.getId(), user014.getId(), from061, to061);
    this.service.finishReservation(reservation061.getId());
    this.service.rateReservation(reservation061.getId(), 2, "Fusce tortor fermentum nisl magna, commodo Praesent massa mauris Praesent commodo ut ");

    Date from062 = sdf.parse("16/4/2014");
    Date to062 = sdf.parse("21/4/2014");
    Reservation reservation062 = this.service.createReservation(property032.getId(), user024.getId(), from062, to062);
    this.service.finishReservation(reservation062.getId());
    this.service.rateReservation(reservation062.getId(), 1, "vel sed sit scelerisque tortor ut tellus odio ut justo ");

    Date from063 = sdf.parse("23/11/2014");
    Date to063 = sdf.parse("24/11/2014");
    Reservation reservation063 = this.service.createReservation(property062.getId(), user013.getId(), from063, to063);

    Date from064 = sdf.parse("14/12/2014");
    Date to064 = sdf.parse("22/12/2014");
    Reservation reservation064 = this.service.createReservation(property005.getId(), user080.getId(), from064, to064);
    this.service.finishReservation(reservation064.getId());
    this.service.rateReservation(reservation064.getId(), 3, "ut commodo scelerisque risus. Fusce nibh, ut dui. amet sit ");

    Date from065 = sdf.parse("6/2/2014");
    Date to065 = sdf.parse("16/2/2014");
    Reservation reservation065 = this.service.createReservation(property070.getId(), user009.getId(), from065, to065);
    this.service.finishReservation(reservation065.getId());
    this.service.rateReservation(reservation065.getId(), 2, "odio tellus cursus nibh, mauris nibh, et. amet commodo, sit dui. dui. ");

    Date from066 = sdf.parse("14/9/2015");
    Date to066 = sdf.parse("22/9/2015");
    Reservation reservation066 = this.service.createReservation(property067.getId(), user042.getId(), from066, to066);

    Date from067 = sdf.parse("12/2/2012");
    Date to067 = sdf.parse("14/2/2012");
    Reservation reservation067 = this.service.createReservation(property025.getId(), user056.getId(), from067, to067);

    Date from068 = sdf.parse("17/4/2014");
    Date to068 = sdf.parse("18/4/2014");
    Reservation reservation068 = this.service.createReservation(property004.getId(), user053.getId(), from068, to068);

    Date from069 = sdf.parse("2/5/2011");
    Date to069 = sdf.parse("12/5/2011");
    Reservation reservation069 = this.service.createReservation(property018.getId(), user068.getId(), from069, to069);
    this.service.finishReservation(reservation069.getId());
    this.service.rateReservation(reservation069.getId(), 2, "mauris odio tortor et. ut nibh, magna, fermentum tortor commodo ");

    Date from070 = sdf.parse("19/12/2011");
    Date to070 = sdf.parse("28/12/2011");
    Reservation reservation070 = this.service.createReservation(property059.getId(), user028.getId(), from070, to070);
    this.service.finishReservation(reservation070.getId());
    this.service.rateReservation(reservation070.getId(), 2, "dui. massa tortor commodo et. amet sit nibh, ut Donec ");

    Date from071 = sdf.parse("8/8/2013");
    Date to071 = sdf.parse("17/8/2013");
    Reservation reservation071 = this.service.createReservation(property012.getId(), user063.getId(), from071, to071);

    Date from072 = sdf.parse("7/6/2014");
    Date to072 = sdf.parse("13/6/2014");
    Reservation reservation072 = this.service.createReservation(property026.getId(), user002.getId(), from072, to072);

    Date from073 = sdf.parse("3/5/2010");
    Date to073 = sdf.parse("9/5/2010");
    Reservation reservation073 = this.service.createReservation(property031.getId(), user032.getId(), from073, to073);

    Date from074 = sdf.parse("11/9/2016");
    Date to074 = sdf.parse("18/9/2016");
    Reservation reservation074 = this.service.createReservation(property049.getId(), user023.getId(), from074, to074);
    this.service.finishReservation(reservation074.getId());
    this.service.rateReservation(reservation074.getId(), 4, "justo mauris nisl fermentum dapibus, scelerisque vel tortor massa commodo mauris ");

    Date from075 = sdf.parse("26/12/2014");
    Date to075 = sdf.parse("3/1/2015");
    Reservation reservation075 = this.service.createReservation(property078.getId(), user025.getId(), from075, to075);

    Date from076 = sdf.parse("27/12/2014");
    Date to076 = sdf.parse("5/1/2015");
    Reservation reservation076 = this.service.createReservation(property057.getId(), user067.getId(), from076, to076);
    this.service.finishReservation(reservation076.getId());
    this.service.rateReservation(reservation076.getId(), 3, "tortor tortor magna, odio commodo, Praesent vel consectetur magna, nisl ac commodo, ");

    Date from077 = sdf.parse("6/7/2015");
    Date to077 = sdf.parse("10/7/2015");
    Reservation reservation077 = this.service.createReservation(property058.getId(), user035.getId(), from077, to077);

    Date from078 = sdf.parse("25/6/2011");
    Date to078 = sdf.parse("5/7/2011");
    Reservation reservation078 = this.service.createReservation(property029.getId(), user034.getId(), from078, to078);

    Date from079 = sdf.parse("15/11/2014");
    Date to079 = sdf.parse("25/11/2014");
    Reservation reservation079 = this.service.createReservation(property074.getId(), user016.getId(), from079, to079);
    this.service.finishReservation(reservation079.getId());
    this.service.rateReservation(reservation079.getId(), 4, "massa Praesent tortor ut sit scelerisque risus. tellus consectetur cursus dui. mauris ");

    Date from080 = sdf.parse("14/9/2012");
    Date to080 = sdf.parse("18/9/2012");
    Reservation reservation080 = this.service.createReservation(property063.getId(), user072.getId(), from080, to080);
    this.service.finishReservation(reservation080.getId());
    this.service.rateReservation(reservation080.getId(), 1, "Donec nisl nibh, ut consectetur consectetur Praesent magna, vel consectetur ");

    Date from081 = sdf.parse("7/12/2016");
    Date to081 = sdf.parse("17/12/2016");
    Reservation reservation081 = this.service.createReservation(property023.getId(), user066.getId(), from081, to081);
    this.service.finishReservation(reservation081.getId());
    this.service.rateReservation(reservation081.getId(), 3, "scelerisque risus. dui. risus. commodo, Donec sed tellus magna, ac ");

    Date from082 = sdf.parse("18/7/2013");
    Date to082 = sdf.parse("22/7/2013");
    Reservation reservation082 = this.service.createReservation(property041.getId(), user057.getId(), from082, to082);

    Date from083 = sdf.parse("16/9/2015");
    Date to083 = sdf.parse("18/9/2015");
    Reservation reservation083 = this.service.createReservation(property040.getId(), user073.getId(), from083, to083);

    Date from084 = sdf.parse("4/2/2013");
    Date to084 = sdf.parse("11/2/2013");
    Reservation reservation084 = this.service.createReservation(property051.getId(), user010.getId(), from084, to084);
    this.service.finishReservation(reservation084.getId());
    this.service.rateReservation(reservation084.getId(), 4, "Donec tellus dapibus, justo dui. tellus dui. ac Donec amet magna, ");

    Date from085 = sdf.parse("8/11/2013");
    Date to085 = sdf.parse("9/11/2013");
    Reservation reservation085 = this.service.createReservation(property030.getId(), user048.getId(), from085, to085);
    this.service.finishReservation(reservation085.getId());
    this.service.rateReservation(reservation085.getId(), 4, "sed tellus consectetur ut nibh, commodo, mauris sed commodo fermentum massa ");

    Date from086 = sdf.parse("23/1/2016");
    Date to086 = sdf.parse("27/1/2016");
    Reservation reservation086 = this.service.createReservation(property006.getId(), user079.getId(), from086, to086);

    Date from087 = sdf.parse("3/4/2011");
    Date to087 = sdf.parse("7/4/2011");
    Reservation reservation087 = this.service.createReservation(property011.getId(), user054.getId(), from087, to087);
    this.service.finishReservation(reservation087.getId());
    this.service.rateReservation(reservation087.getId(), 5, "tortor magna, risus. tortor nisl ut Fusce mauris massa et. massa ");

    Date from088 = sdf.parse("13/4/2016");
    Date to088 = sdf.parse("18/4/2016");
    Reservation reservation088 = this.service.createReservation(property034.getId(), user065.getId(), from088, to088);
    this.service.finishReservation(reservation088.getId());
    this.service.rateReservation(reservation088.getId(), 5, "condimentum nibh, commodo, risus. ut Fusce odio odio cursus odio ");

    Date from089 = sdf.parse("10/12/2012");
    Date to089 = sdf.parse("17/12/2012");
    Reservation reservation089 = this.service.createReservation(property046.getId(), user020.getId(), from089, to089);
    this.service.finishReservation(reservation089.getId());
    this.service.rateReservation(reservation089.getId(), 6, "commodo, cursus condimentum ut commodo nibh, mauris ac Donec et. ut ut ");

    Date from090 = sdf.parse("4/8/2016");
    Date to090 = sdf.parse("6/8/2016");
    Reservation reservation090 = this.service.createReservation(property021.getId(), user036.getId(), from090, to090);
    this.service.finishReservation(reservation090.getId());
    this.service.rateReservation(reservation090.getId(), 4, "et. Fusce Donec ut et. scelerisque consectetur vel ut et. cursus ");

    Date from091 = sdf.parse("15/5/2012");
    Date to091 = sdf.parse("24/5/2012");
    Reservation reservation091 = this.service.createReservation(property045.getId(), user076.getId(), from091, to091);
    this.service.finishReservation(reservation091.getId());
    this.service.rateReservation(reservation091.getId(), 3, "ac mauris amet amet sed nibh, ac cursus dui. Donec ");

    Date from092 = sdf.parse("21/5/2012");
    Date to092 = sdf.parse("31/5/2012");
    Reservation reservation092 = this.service.createReservation(property076.getId(), user044.getId(), from092, to092);
    this.service.finishReservation(reservation092.getId());
    this.service.rateReservation(reservation092.getId(), 5, "nisl odio Donec nibh, odio vel dapibus, dui. dapibus, Donec Fusce Fusce ");

    Date from093 = sdf.parse("5/1/2010");
    Date to093 = sdf.parse("11/1/2010");
    Reservation reservation093 = this.service.createReservation(property050.getId(), user058.getId(), from093, to093);
    this.service.finishReservation(reservation093.getId());
    this.service.rateReservation(reservation093.getId(), 2, "dapibus, commodo magna, nibh, ac fermentum fermentum Donec ut sit ");

    Date from094 = sdf.parse("27/4/2016");
    Date to094 = sdf.parse("6/5/2016");
    Reservation reservation094 = this.service.createReservation(property079.getId(), user037.getId(), from094, to094);

    Date from095 = sdf.parse("6/2/2014");
    Date to095 = sdf.parse("8/2/2014");
    Reservation reservation095 = this.service.createReservation(property014.getId(), user059.getId(), from095, to095);
    this.service.finishReservation(reservation095.getId());
    this.service.rateReservation(reservation095.getId(), 6, "Donec et. sit Praesent magna, massa Fusce justo justo justo ");

    Date from096 = sdf.parse("15/11/2015");
    Date to096 = sdf.parse("16/11/2015");
    Reservation reservation096 = this.service.createReservation(property007.getId(), user005.getId(), from096, to096);
    this.service.finishReservation(reservation096.getId());
    this.service.rateReservation(reservation096.getId(), 2, "ut Fusce fermentum mauris tortor commodo, Fusce ut dui. odio cursus ");

    Date from097 = sdf.parse("27/7/2013");
    Date to097 = sdf.parse("29/7/2013");
    Reservation reservation097 = this.service.createReservation(property077.getId(), user052.getId(), from097, to097);

    Date from098 = sdf.parse("28/5/2014");
    Date to098 = sdf.parse("6/6/2014");
    Reservation reservation098 = this.service.createReservation(property009.getId(), user060.getId(), from098, to098);
    this.service.finishReservation(reservation098.getId());
    this.service.rateReservation(reservation098.getId(), 5, "odio mauris Praesent commodo, commodo et. amet ut Donec Donec condimentum ");

    Date from099 = sdf.parse("6/2/2011");
    Date to099 = sdf.parse("12/2/2011");
    Reservation reservation099 = this.service.createReservation(property072.getId(), user075.getId(), from099, to099);
    this.service.finishReservation(reservation099.getId());
    this.service.rateReservation(reservation099.getId(), 1, "justo sed condimentum cursus risus. cursus mauris Praesent nisl dui. ac commodo, ");

    Date from100 = sdf.parse("13/10/2013");
    Date to100 = sdf.parse("19/10/2013");
    Reservation reservation100 = this.service.createReservation(property060.getId(), user077.getId(), from100, to100);
    this.service.finishReservation(reservation100.getId());
    this.service.rateReservation(reservation100.getId(), 5, "fermentum ac tortor risus. cursus tellus amet scelerisque amet mauris ");

    Date from101 = sdf.parse("15/7/2014");
    Date to101 = sdf.parse("21/7/2014");
    Reservation reservation101 = this.service.createReservation(property028.getId(), user027.getId(), from101, to101);
    this.service.finishReservation(reservation101.getId());
    this.service.rateReservation(reservation101.getId(), 3, "scelerisque amet fermentum consectetur risus. tortor risus. magna, ac ut ");

    Date from102 = sdf.parse("23/3/2012");
    Date to102 = sdf.parse("2/4/2012");
    Reservation reservation102 = this.service.createReservation(property055.getId(), user015.getId(), from102, to102);
    this.service.finishReservation(reservation102.getId());
    this.service.rateReservation(reservation102.getId(), 3, "sed condimentum massa ac mauris fermentum cursus dapibus, massa sit nisl sed ");

    Date from103 = sdf.parse("15/3/2015");
    Date to103 = sdf.parse("18/3/2015");
    Reservation reservation103 = this.service.createReservation(property069.getId(), user029.getId(), from103, to103);
    this.service.finishReservation(reservation103.getId());
    this.service.rateReservation(reservation103.getId(), 8, "tellus Donec ut condimentum mauris vel Donec Fusce fermentum ac vel tortor ");

    Date from104 = sdf.parse("23/9/2012");
    Date to104 = sdf.parse("30/9/2012");
    Reservation reservation104 = this.service.createReservation(property042.getId(), user071.getId(), from104, to104);

    Date from105 = sdf.parse("7/7/2016");
    Date to105 = sdf.parse("12/7/2016");
    Reservation reservation105 = this.service.createReservation(property019.getId(), user064.getId(), from105, to105);
    this.service.finishReservation(reservation105.getId());
    this.service.rateReservation(reservation105.getId(), 4, "amet amet scelerisque tellus fermentum dapibus, massa tortor consectetur mauris justo scelerisque ");

    Date from106 = sdf.parse("7/5/2016");
    Date to106 = sdf.parse("12/5/2016");
    Reservation reservation106 = this.service.createReservation(property008.getId(), user062.getId(), from106, to106);
    this.service.finishReservation(reservation106.getId());
    this.service.rateReservation(reservation106.getId(), 10, "fermentum vel justo Praesent cursus commodo Fusce tortor Fusce nisl ");

    Date from107 = sdf.parse("24/1/2013");
    Date to107 = sdf.parse("3/2/2013");
    Reservation reservation107 = this.service.createReservation(property066.getId(), user041.getId(), from107, to107);
    this.service.finishReservation(reservation107.getId());
    this.service.rateReservation(reservation107.getId(), 4, "sed massa cursus magna, sed scelerisque fermentum risus. commodo mauris ");

    Date from108 = sdf.parse("26/4/2010");
    Date to108 = sdf.parse("3/5/2010");
    Reservation reservation108 = this.service.createReservation(property035.getId(), user040.getId(), from108, to108);

    Date from109 = sdf.parse("22/5/2013");
    Date to109 = sdf.parse("29/5/2013");
    Reservation reservation109 = this.service.createReservation(property048.getId(), user047.getId(), from109, to109);

    Date from110 = sdf.parse("13/9/2015");
    Date to110 = sdf.parse("22/9/2015");
    Reservation reservation110 = this.service.createReservation(property054.getId(), user038.getId(), from110, to110);

    Date from111 = sdf.parse("9/4/2014");
    Date to111 = sdf.parse("17/4/2014");
    Reservation reservation111 = this.service.createReservation(property080.getId(), user018.getId(), from111, to111);
    this.service.finishReservation(reservation111.getId());
    this.service.rateReservation(reservation111.getId(), 4, "ac dui. vel Praesent massa nisl commodo, magna, nisl sed tortor ");

    Date from112 = sdf.parse("5/2/2013");
    Date to112 = sdf.parse("15/2/2013");
    Reservation reservation112 = this.service.createReservation(property071.getId(), user026.getId(), from112, to112);

    Date from113 = sdf.parse("15/2/2010");
    Date to113 = sdf.parse("24/2/2010");
    Reservation reservation113 = this.service.createReservation(property044.getId(), user070.getId(), from113, to113);

    Date from114 = sdf.parse("24/9/2016");
    Date to114 = sdf.parse("2/10/2016");
    Reservation reservation114 = this.service.createReservation(property017.getId(), user078.getId(), from114, to114);
    this.service.finishReservation(reservation114.getId());
    this.service.rateReservation(reservation114.getId(), 4, "vel justo condimentum scelerisque massa commodo, risus. cursus Praesent nisl risus. sed ");

    Date from115 = sdf.parse("13/1/2016");
    Date to115 = sdf.parse("16/1/2016");
    Reservation reservation115 = this.service.createReservation(property024.getId(), user012.getId(), from115, to115);

    Date from116 = sdf.parse("19/9/2013");
    Date to116 = sdf.parse("26/9/2013");
    Reservation reservation116 = this.service.createReservation(property001.getId(), user022.getId(), from116, to116);

    Date from117 = sdf.parse("17/1/2016");
    Date to117 = sdf.parse("24/1/2016");
    Reservation reservation117 = this.service.createReservation(property052.getId(), user031.getId(), from117, to117);
    this.service.finishReservation(reservation117.getId());
    this.service.rateReservation(reservation117.getId(), 5, "fermentum ut condimentum scelerisque cursus sed nibh, scelerisque massa sit vel ac ");

    Date from118 = sdf.parse("1/10/2012");
    Date to118 = sdf.parse("11/10/2012");
    Reservation reservation118 = this.service.createReservation(property064.getId(), user011.getId(), from118, to118);

    Date from119 = sdf.parse("28/9/2015");
    Date to119 = sdf.parse("1/10/2015");
    Reservation reservation119 = this.service.createReservation(property065.getId(), user049.getId(), from119, to119);
    this.service.finishReservation(reservation119.getId());
    this.service.rateReservation(reservation119.getId(), 2, "tortor risus. condimentum dui. fermentum dui. ut condimentum consectetur Fusce ");

    Date from120 = sdf.parse("13/10/2014");
    Date to120 = sdf.parse("23/10/2014");
    Reservation reservation120 = this.service.createReservation(property075.getId(), user001.getId(), from120, to120);

    Date from121 = sdf.parse("13/10/2014");
    Date to121 = sdf.parse("23/10/2014");
    Reservation reservation121 = this.service.createReservation(property081.getId(), user001.getId(), from121, to121);

    Date from122 = sdf.parse("26/11/2014");
    Date to122 = sdf.parse("27/11/2014");
    Reservation reservation122 = this.service.createReservation(property014.getId(), user013.getId(), from122, to122);

    Date from123 = sdf.parse("26/11/2014");
    Date to123 = sdf.parse("27/11/2014");
    Reservation reservation123 = this.service.createReservation(property015.getId(), user037.getId(), from123, to123);

  }

}
