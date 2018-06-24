package ar.edu.info.unlp.bd2.etapa2.config;

import ar.edu.info.unlp.bd2.etapa2.repository.AirBdbRepository;
import ar.edu.info.unlp.bd2.etapa2.service.AirBdbService;
import ar.edu.info.unlp.bd2.etapa2.service.impl.AirBdbServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

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
