package uk.co.eleusis.deptstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring application context configuration
 * [replaces application-context.xml]
 * 
 * @author keithm
 *
 */
@Configuration
@ComponentScan({"uk.co.eleusis.deptstore.data"})
@EnableTransactionManagement
public class AppConfig 
{
	@Bean
	public LoadTimeWeaver loadTimeWeaver()
	{
		return new InstrumentationLoadTimeWeaver();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		return new LocalContainerEntityManagerFactoryBean();
	}
	
	@Bean
	public JpaTransactionManager txManager()
	{
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}
}
