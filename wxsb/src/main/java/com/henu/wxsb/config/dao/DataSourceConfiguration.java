package com.henu.wxsb.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * 配置datasource到ioc容器里面
 *
 */
@Configuration
@MapperScan("com.henu.wxsb.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    /**
     * 生成与spring-dao.xml对应的bean dataSource
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        // 生成datasource实例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 跟配置文件一样设置以下信息
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        // 配置c3p0连接池的私有属性
        // 关闭连接后不自动commit，可以使用事务进行控制
        dataSource.setAutoCommitOnClose(false);
        dataSource.setMaxPoolSize(30);
        dataSource.setMinPoolSize(10);
        dataSource.setCheckoutTimeout(10000);
        // 连接失败重试次数
        dataSource.setAcquireRetryAttempts(2);
        return dataSource;
    }

}
