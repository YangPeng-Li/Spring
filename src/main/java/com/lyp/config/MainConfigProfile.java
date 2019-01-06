package com.lyp.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.lyp.entiry.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Profile:
 * 		  Spring ：为我们提供的可以根据当前的环境，动态激活和切换一些列组件的功能
 *
 * 
 * 开发环境、测试环境、生产环境
 * 数据源（dev/test/prod）
 *
 * 
 * @Profile :  指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * 			1)、加了环境标识，只有这个环境被激活的时候才能注册到容器中 默认是default	
 * 		     	 ①可以修改 VM argument  Dspring.profiles.active=test 
 *				 ②也可以通过代码获取
 *			2)、写在配置类上，只是指定环境的时候，整个配置类的里面所有配置才开始生效
 *			3)、没有标注环境标识的bean,在任何环境下都是加载的
 */
 

@PropertySource("classpath:/dbfig.properties")
@Configuration
public class MainConfigProfile implements EmbeddedValueResolverAware {

	@Value("@{db.user}")
	private String user;
	
	private StringValueResolver stringValueResolver;
	
	@Bean
	public Yellow yellow ()
	{
		return new Yellow();
	}
	
	
	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest (@Value("${db.password}")String pwd)
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
		try {
			String driverClass = stringValueResolver.resolveStringValue("db.driverClass");
			dataSource.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("${db.password}")String pwd)
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/dev");
		try {
			String dirverClass = stringValueResolver.resolveStringValue("db.driverClass");
			dataSource.setDriverClass(dirverClass);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Profile("prod")
	@Bean("prodDataSource")
	public DataSource dataSourceProd(@Value("${db.password}")String pwd)
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/prod");
		try {
			String driverClass = stringValueResolver.resolveStringValue("db.driverClass");
			
			dataSource.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}



	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.stringValueResolver = resolver;
	}
	
}
