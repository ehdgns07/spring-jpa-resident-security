package com.nhnacademy.jpa.config;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.nhnacademy.jpa.Base;
import com.p6spy.engine.spy.P6DataSource;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
                excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        basicDataSource.setUrl("jdbc:mysql://133.186.211.156:3306/nhn_academy_19");
        basicDataSource.setUsername("nhn_academy_19");
        basicDataSource.setPassword("2/5l(ky6VP_bbyzZ");
        basicDataSource.setInitialSize(2);
        basicDataSource.setMaxTotal(2);
        return basicDataSource;
    }

    @Bean
    public DataSource logDataSource() {
        return new P6DataSource(dataSource());
    }
}
