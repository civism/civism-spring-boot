package com.civism.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据库切换的切面配置
 *
 * @author xstarfct
 * @version 2018/3/7 下午5:25
 */
@Component
@Aspect
@Order(0)
public class DataSourceInterceptor {

    @Pointcut("execution(* com.civism.dao.mysql.*.*(..))")
    public void dataSourceMysql() {
    }

    @Before("dataSourceMysql()")
    public void setMysql(JoinPoint joinPoint) {
        DynamicDataSource.set(DataSourceType.MYSQL);
    }

    @Pointcut("execution(* com.civism.dao.sqlserver.*.*(..))")
    public void dataSourceSqlServer() {
    }

    @Before("dataSourceSqlServer()")
    public void setSqlServer(JoinPoint joinPoint) {
        DynamicDataSource.set(DataSourceType.SERVER);
    }


    @After("dataSourceSqlServer()")
    public void clear(JoinPoint joinPoint) {
        DynamicDataSource.clearDataSource();
    }


    @After("dataSourceMysql()")
    public void clearMysql(JoinPoint joinPoint) {
        DynamicDataSource.clearDataSource();
    }

}
