package com.civism.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author star
 * @date 2019-02-14 15:04
 */
public class MultipleDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSource.get();
    }


}
