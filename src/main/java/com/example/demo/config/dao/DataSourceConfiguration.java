package com.example.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot 讲求去掉xml配置,配置越少越好
 * 配置mybatis mapper的扫描路径
 */
@Configuration
@MapperScan("com.example.demo.dao")
public class DataSourceConfiguration
{
	@Value("${jdbc.driver}")
	private String jdbcDriver;

	@Value("${jdbc.url}")
	private String jdbcUrl;

	@Value("${jdbc.username}")
	private String jdbcUsername;

	@Value("${jdbc.password}")
	private String jdbcPassword;

	/**
	 * 此注解会在ioc中注册一个ID为dataSource的bean
	 * @return
	 */
	@Bean(name="dataSource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException
	{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        //连接池关闭的时候不自动commit
        dataSource.setAutoCommitOnClose(false);

		return dataSource;
	}
}
