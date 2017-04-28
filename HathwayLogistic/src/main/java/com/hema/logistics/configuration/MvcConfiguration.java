package com.hema.logistics.configuration;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hema.logistics.entities.ProjectEntity;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.hema.logistics")
@EnableTransactionManagement
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean(name="viewResolver")	
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;		
	}

	@Bean(name="dataSource")	
	public DataSource getDataSource(){
		BasicDataSource d = new BasicDataSource();			
			d.setDriverClassName("com.mysql.jdbc.Driver");
			d.setUrl("jdbc:mysql://localhost:3306/springtraining");
			d.setUsername("root");
			d.setPassword("root");		
		return d;
		
	}
	
	public Properties getHibernateProperties(){
		Properties p = new Properties();
			p.put("hibernate.show_sql", "true");
			p.put("hibernate.hbm2ddl.auto", "update");
			p.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");		
		return p;
	}
	
	@Bean
	@Autowired
	public SessionFactory getSessionFactorty(DataSource d){
		LocalSessionFactoryBuilder s = new LocalSessionFactoryBuilder(d);
			s.addProperties(getHibernateProperties());
			s.addAnnotatedClass(ProjectEntity.class);
		SessionFactory sf = s.buildSessionFactory();
		return sf;
	}	

	@Bean
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory s){
		HibernateTransactionManager tm = new HibernateTransactionManager(s);
		return tm;
		
	}
}
