package com.example.employeemanagementsystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.repository.employee",
        entityManagerFactoryRef = "employeeEntityManagerFactory",
        transactionManagerRef = "employeeTransactionManager"
)
public class EmployeeDataSourceConfig {

    @Bean(name = "employeeDataSource")
    @ConfigurationProperties("spring.datasource.employee")
    public DataSource employeeDataSource() {
        return new DriverManagerDataSource();
    }

    @Bean(name = "employeeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(employeeDataSource())
                .packages("com.example.entity.employee") // Adjust package as necessary
                .persistenceUnit("employeePU")
                .properties(hibernateProperties())
                .build();
    }

    @Bean(name = "employeeTransactionManager")
    public PlatformTransactionManager employeeTransactionManager(
            @Qualifier("employeeEntityManagerFactory") EntityManagerFactory employeeEntityManagerFactory) {
        return new JpaTransactionManager(employeeEntityManagerFactory);
    }

    private Map<String, Object> hibernateProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }
}
