package com.godeltech.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySources({
        @PropertySource("classpath:db.properties")
})
@ComponentScan(basePackages = {"com.godeltech.dao", "com.godeltech.service"})
public class AppConfiguration {

    @Value("${db.driverClassName}")
    String driverClassName;

    @Value("${db.url}")
    String url;

    @Value("${db.username}")
    String username;

    @Value("${db.password}")
    String password;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

}
