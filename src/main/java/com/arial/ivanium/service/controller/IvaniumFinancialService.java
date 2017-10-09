package com.arial.ivanium.service.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.arial.ivanium.delegate.DatabaseDelegate;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;

@Controller
public class IvaniumFinancialService {

	@Autowired
	private DatabaseDelegate delegate;

	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}

	@RequestMapping(value = "/fact/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FactIngredientDTO> getFacts() {
		try {
			return delegate.getFactIngredient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/fact/getAllExternalData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllExternalData() {
		try {
			List<FinancialIncomeStatmentDTO> factIngredients = null;
			final String uri = "http://localhost:8080/springrestexample/employees.json";
			String line = "";
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> result = restTemplate.exchange(
					"https://api.intrinio.com/financials/standardized.csv?fiscal_period=FY&fiscal_year=2016&statement=income_statement&ticker=EOG",
					HttpMethod.GET, request, String.class);
			BufferedReader br = null;
			String data = result.getBody();

			System.out.println(data);

			br = new BufferedReader(new FileReader(data));
			while ((line = br.readLine()) != null) {

				System.out.println(line);

			}

			List<FactIngredientDTO> factIngredientDTOs = null;
			delegate.saveFinancialIncomeData(factIngredients);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
