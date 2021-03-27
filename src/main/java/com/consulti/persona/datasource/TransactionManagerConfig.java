package com.consulti.persona.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionManagerConfig {
  @Bean(name = "personaTransactionManager")
  public ChainedTransactionManager biselTransactionManager(
      @Qualifier("PersonaTM") PlatformTransactionManager PersonaTM) {
    return new ChainedTransactionManager(PersonaTM);
  }
}
