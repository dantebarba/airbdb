package ar.edu.info.unlp.bd2.etapa2.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories({"ar.edu.info.unlp.bd2.etapa2"})
public class MongoConfiguration extends AbstractMongoConfiguration {

  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(this.mongoClient(), this.getDatabaseName());
  }

  @Override
  public MongoClient mongoClient() {
    return new MongoClient("127.0.0.1", 27017);
  }

  @Override
  protected String getDatabaseName() {
    return "bd2_grupo" + this.getGroupNumber();
  }

  public int getGroupNumber() {
    return 0;
  }

}
