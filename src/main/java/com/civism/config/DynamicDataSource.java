package com.civism.config;

/**
 * @author star
 * @date 2019-02-14 15:06
 */
public class DynamicDataSource {

    private static final ThreadLocal<DataSourceType> DATA_SOURCE_KEY = ThreadLocal.withInitial(() -> DataSourceType.MYSQL);

    static DataSourceType get() {
        return DATA_SOURCE_KEY.get();
    }

    static void set(DataSourceType dataSourceType) {
        DATA_SOURCE_KEY.set(dataSourceType);
    }

    public static void reset() {
        DATA_SOURCE_KEY.set(DataSourceType.MYSQL);
    }

    public static void clearDataSource() {
        DATA_SOURCE_KEY.remove();
    }
}
