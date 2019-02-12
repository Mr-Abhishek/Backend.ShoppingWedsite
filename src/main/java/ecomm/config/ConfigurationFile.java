package ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@ComponentScan("ecomm")
@EnableTransactionManagement
public class ConfigurationFile
{
	@Bean(name="dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("shubham");
		dataSource.setPassword("shubham");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/class");
		return dataSource;

	}
	@Bean
	public SessionFactory getSessionFactory() 
	{
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateProperties);
		factory.scanPackages("ecomm.model");
		SessionFactory sessionFactory=factory.buildSessionFactory();
		System.out.println("Session Factory is created");
		return sessionFactory;
	}
	
	
	@Bean(name="txtmanager")
	public HibernateTransactionManager getTransactionmanager(SessionFactory sessionfactory) {
		System.out.println("Create Trancation Manager");
		return new HibernateTransactionManager(sessionfactory);
		}
}
