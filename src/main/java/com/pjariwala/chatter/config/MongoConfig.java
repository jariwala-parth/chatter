package com.pjariwala.chatter.config;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;

/** Mongo Configuration. */
@Slf4j
@Configuration
@EnableMongoAuditing
public class MongoConfig {

  @Value("${spring.data.mongodb.uri:mongodb://localhost:27017}")
  private String mongoUri;

  @Value("${environment:staging}")
  private String environment;

  @Value("${spring.data.mongodb.username:}")
  String mongodbUserName;

  @Value("${spring.data.mongodb.password:}")
  String mongodbPassword;

  /** Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance. */
  public @Bean MongoClient mongoClient() {
    log.info("Initializing mongoClient for environment = " + environment);

    return MongoClients.create(mongoUri);
  }

  public @Bean MongoTemplate mongoTemplate() {
    return new MongoTemplate(mongoClient(), "chatter");
  }

  /** CodecRegistryProvider. */
  public @Bean CodecRegistry codecRegistryProvider() {
    CodecRegistry pojoCodecRegistry =
        fromProviders(PojoCodecProvider.builder().automatic(true).build());
    return fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
  }
}
