package com.civism.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author star
 * @date 2019-02-14 16:04
 */
@Configuration
public class MasterDataSource {


    @Bean(name = "masterMysqlDataSource")
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
        return DruidDataSourceBuilder.create().build();
    }


    @Primary
    @Bean(name = "masterTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("masterMysqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
