package com.civism.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author star
 * @date 2019-02-14 16:28
 */
@Configuration
public class DataSourceConfig {

    @Resource
    private MasterDataSource masterDataSource;

    @Resource
    private SlaveDataSource slaveDataSource;

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     *
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        MultipleDataSource multipleDataSource = new MultipleDataSource();

        multipleDataSource.setDefaultTargetDataSource(masterDataSource.dataSource());

        Map<Object, Object> dsMap = new HashMap<>(2);
        dsMap.put(DataSourceType.MYSQL, masterDataSource.dataSource());
        dsMap.put(DataSourceType.SERVER, slaveDataSource.dataSource());

        multipleDataSource.setTargetDataSources(dsMap);
        return multipleDataSource;
    }

    /**
     * 配置@Transactional注解事物
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
