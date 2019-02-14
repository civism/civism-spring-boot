package com.civism.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author star
 * @date 2019-02-14 16:23
 */
@Configuration
public class SlaveDataSource {


    @Bean(name = "slaveMysqlDataSource")
    @ConfigurationProperties(prefix = "datasource.slave")
    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
        return DruidDataSourceBuilder.create().build();
    }



    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("slaveMysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
