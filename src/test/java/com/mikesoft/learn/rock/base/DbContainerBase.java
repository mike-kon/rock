package com.mikesoft.learn.rock.base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.postgresql.PostgreSQLContainer;

@SpringBootTest
@ContextConfiguration(initializers = DbContainerBase.Initializer.class)
public abstract class DbContainerBase {

  private static final String DATABASE_NAME = "rock-test";

  @Container
  private static final PostgreSQLContainer postgreSQLContainer =
      new PostgreSQLContainer("postgres:15.14-alpine")
          .withDatabaseName(DATABASE_NAME)
          //.withReuse(true)
          .withInitScript("./db/v0-create-schema.sql");

  static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      postgreSQLContainer.start();
      TestPropertyValues.of(
          "spring.datasource.username = " + postgreSQLContainer.getUsername(),
          "spring.datasource.password = " + postgreSQLContainer.getPassword(),
          "spring.datasource.url = " + postgreSQLContainer.getJdbcUrl()
      ).applyTo(applicationContext.getEnvironment());
    }
  }

}
