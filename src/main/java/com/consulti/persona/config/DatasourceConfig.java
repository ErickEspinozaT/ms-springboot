package com.consulti.persona.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "PersonaEMFactory", transactionManagerRef = "PersonaTM", basePackages = {
    "com.consulti.persona.repository" })
@EntityScan(basePackages = { "com.consulti.persona.entity" })
public class DatasourceConfig {
}
