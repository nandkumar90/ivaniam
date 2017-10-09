package com.arial.ivanium.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arial.ivanium.dao.IvaniamFinanceDao;
import com.arial.ivanium.dao.impl.IvaniamFinanceDaoImpl;
import com.arial.ivanium.delegate.DatabaseDelegate;
import com.arial.ivanium.delegate.impl.DatabaseDelegateImpl;


@Configuration
public class DaoBeanConfig {
	
	
	@Bean
	public DatabaseDelegate getDatabaseDelegate() {
		return new DatabaseDelegateImpl();
	}
	
	@Bean
	public IvaniamFinanceDao getIvaniumFinanceDao() {
		return new IvaniamFinanceDaoImpl();
	}
	
}
