package ar.edu.unlp.info.bd2.config;

import ar.edu.unlp.info.bd2.repositories.AirBdbRepository;
import ar.edu.unlp.info.bd2.services.AirBdbService;
import ar.edu.unlp.info.bd2.services.AirBdbServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public AirBdbService createService() {
    AirBdbRepository repository = this.createRepository();
    return new AirBdbServiceImpl(repository);
  }

  @Bean
  public AirBdbRepository createRepository() {
    return new AirBdbRepository();
  }

}

