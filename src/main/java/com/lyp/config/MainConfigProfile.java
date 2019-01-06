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
 * 		  Spring ��Ϊ�����ṩ�Ŀ��Ը��ݵ�ǰ�Ļ�������̬������л�һЩ������Ĺ���
 *
 * 
 * �������������Ի�������������
 * ����Դ��dev/test/prod��
 *
 * 
 * @Profile :  ָ��������ĸ�����������²��ܱ�ע�ᵽ�����У���ָ�����κλ����¶���ע��������
 * 			1)�����˻�����ʶ��ֻ����������������ʱ�����ע�ᵽ������ Ĭ����default	
 * 		     	 �ٿ����޸� VM argument  Dspring.profiles.active=test 
 *				 ��Ҳ����ͨ�������ȡ
 *			2)��д���������ϣ�ֻ��ָ��������ʱ������������������������òſ�ʼ��Ч
 *			3)��û�б�ע������ʶ��bean,���κλ����¶��Ǽ��ص�
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
