package com.spring.edumentor.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.edumentor")
public class Config {

    public DataSource dataSource(){
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/my_db?useSSL=false");
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setUser("username");
            dataSource.setPassword("password");
            //dataSource.setContextClassLoaderSource("thread");
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }
}
