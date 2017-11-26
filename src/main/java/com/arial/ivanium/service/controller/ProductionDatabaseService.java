package com.arial.ivanium.service.controller;


import com.arial.ivanium.delegate.DatabaseDelegate;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ProductionDatabaseService {
	
	@Autowired
	private DatabaseDelegate delegate;

	
	
	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}

	
	

}
