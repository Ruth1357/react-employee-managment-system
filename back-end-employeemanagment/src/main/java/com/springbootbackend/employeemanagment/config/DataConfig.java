package com.springbootbackend.employeemanagment.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DataConfig {

    @Bean
    @Primary
    public DataSource dataSource()
    {
    	DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    	dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("Ruthvi@1");
        return dataSourceBuilder.build();
    }
    
    



    @Bean
    @Primary
    @Qualifier("jdbcTemplate")
    public NamedParameterJdbcTemplate revelationsTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }
    

  

    
}