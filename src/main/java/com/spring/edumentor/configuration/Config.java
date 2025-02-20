package com.spring.edumentor.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.edumentor")
@EnableTransactionManagement
public class Config {

    @Bean
    public DataSource dataSource(){
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/edumentorDB");
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setUser("server");
            dataSource.setPassword("edumentor123");
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.spring.edumentor");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgresPlusDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
}
