package com.horizon.backend.server.conf;

import javax.activation.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
	/*@Bean
    public DataSource datasource() {
        return (DataSource) DataSourceBuilder.create()
          .driverClassName("com.mysql.cj.jdbc.Driver")
          .url("jdbc:mysql://localhost:3306/horizondb")
          .username("root")
          .password("")
          .build(); 
    }*/
}
