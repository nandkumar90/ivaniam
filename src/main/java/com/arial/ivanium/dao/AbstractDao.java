package com.arial.ivanium.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.arial.ivanium.dto.Historical_data_Common_DTO;

public abstract class AbstractDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void flush() {
		getSession().flush();
	}

	
	
}
