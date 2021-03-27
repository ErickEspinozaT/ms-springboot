package com.consulti.persona.datasource;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DbConfig {

  @Value("${db.username}")
  private String username;

  @Value("${db.password}")
  private String password;

  @Value("${db.host}")
  private String host;

  @Value("${db.name}")
  private String bdName;

  @Value("${spring.datasource.hikari.idle-timeout}")
  private int idleTimeout;

  @Value("${spring.datasource.hikari.connection-timeout}")
  private int connectionTimeout;

  @Value("${spring.datasource.hikari.maximum-pool-size}")
  private int maxPoolSize;

  @Value("${spring.datasource.hikari.minimum-idle}")
  private int minPoolSize;

  @Value("${spring.datasource.hikari.max-lifetime}")
  private int maxLifetime;

  private final Map<String, Object> hibernateProperties() {
    Map<String, Object> hibernateProperties = new LinkedHashMap<String, Object>();
    hibernateProperties.put("hibernate.connection.release_mode", "auto");
    return hibernateProperties;
  }

  @Primary
  @Bean(name = "dsPersona")
  public HikariDataSource dsPersona(@Qualifier("dsPersonaProperties") HikariConfig dataSourceConfig) {
    return new HikariDataSource(dataSourceConfig);
  }

  @Primary
  @Bean(name = "dsPersonaProperties")
  public HikariConfig dsPersonaConfig() throws Exception {
    HikariConfig dataSourceConfig = new HikariConfig();
    /*
     * Set: - poolname - username - password - jdbc
     */
    dataSourceConfig.setUsername(username);
    dataSourceConfig.setPassword(password);
    dataSourceConfig.setPoolName("ms-persona");
    dataSourceConfig.setJdbcUrl("jdbc:postgresql://" + host + "/" + bdName);
    dataSourceConfig.setConnectionTimeout(connectionTimeout);
    dataSourceConfig.setIdleTimeout(idleTimeout);
    dataSourceConfig.setMaximumPoolSize(maxPoolSize);
    dataSourceConfig.setMinimumIdle(minPoolSize);
    dataSourceConfig.setMaxLifetime(maxLifetime);
    dataSourceConfig.setValidationTimeout(10000);
    dataSourceConfig.addDataSourceProperty("oracle.jdbc.timezoneAsRegion", "false");
    return dataSourceConfig;
  }

  @Primary
  @Bean(name = "jdbcPersona")
  @Autowired
  public JdbcTemplate jdbcPersonaTemplate(@Qualifier("dsPersona") DataSource dsPersona) {
    return new JdbcTemplate(dsPersona);
  }

  @Primary
  @Bean(name = "PersonaEMFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryMonitoreo(EntityManagerFactoryBuilder builder,
      @Qualifier("dsPersona") DataSource dsPersona) {
    return builder.dataSource(dsPersona).properties(hibernateProperties()).packages("com.consulti.persona.entity")
        .persistenceUnit("dbPersona").build();
  }

  @Primary
  @Bean(name = "PersonaTM")
  public PlatformTransactionManager transactionManagerMonitoreo(
      @Qualifier("PersonaEMFactory") EntityManagerFactory PersonaEMFactory) {
    return new JpaTransactionManager(PersonaEMFactory);
  }
}