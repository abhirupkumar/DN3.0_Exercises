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
        basePackages = "com.example.repository.department",
        entityManagerFactoryRef = "departmentEntityManagerFactory",
        transactionManagerRef = "departmentTransactionManager"
)
public class DepartmentDataSourceConfig {

    @Bean(name = "departmentDataSource")
    @ConfigurationProperties("spring.datasource.department")
    public DataSource departmentDataSource() {
        return new DriverManagerDataSource();
    }

    @Bean(name = "departmentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean departmentEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(departmentDataSource())
                .packages("com.example.entity.department") // Adjust package as necessary
                .persistenceUnit("departmentPU")
                .properties(hibernateProperties())
                .build();
    }

    @Bean(name = "departmentTransactionManager")
    public PlatformTransactionManager departmentTransactionManager(
            @Qualifier("departmentEntityManagerFactory") EntityManagerFactory departmentEntityManagerFactory) {
        return new JpaTransactionManager(departmentEntityManagerFactory);
    }

    private Map<String, Object> hibernateProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }
}
