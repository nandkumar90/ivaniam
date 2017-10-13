package com.arial.ivanium.service.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.arial.ivanium.dto.StandardIncomeStatment;

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
			List<FinancialIncomeStatmentDTO> factIngredientDTOs = new ArrayList<>();
			Map<String, Integer> pagedetail = new HashMap<>();
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

			BufferedReader bufReader = new BufferedReader(new StringReader(data));
			String PageDetail = bufReader.readLine();
			String columnDetail = bufReader.readLine();
			int crrentPage = 0;
			int totalPage = 0;
			if (null != PageDetail) {
				String[] pageDetails = PageDetail.split(",");
				for (String string : pageDetails) {
					String[] mapEntry = string.split(":");

					pagedetail.put(mapEntry[0], Integer.parseInt(mapEntry[1].trim()));

				}
				crrentPage = pagedetail.get("CURRENT_PAGE");
				totalPage = pagedetail.get("TOTAL_PAGES");

			}
			while ((line = bufReader.readLine()) != null) {
				String[] tagData = line.split(",");
				FinancialIncomeStatmentDTO faFinancialIncomeStatmentDTO = new FinancialIncomeStatmentDTO();
				faFinancialIncomeStatmentDTO.setTag(tagData[0].trim());
				faFinancialIncomeStatmentDTO.setValue(tagData[1].trim());
				factIngredientDTOs.add(faFinancialIncomeStatmentDTO);

			}

			delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/fact/getStandardIncomeStatmentData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllIncomeStatmentData() {
		try {
			String[] year = { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" };
			String[] period = { "Q1", "Q2", "Q3", "Q4" };

			int crrentPage = 0;
			int totalPage = 0;
			List<FinancialIncomeStatmentDTO> factIngredientDTOs = new ArrayList<>();
			Map<String, Integer> pagedetail = new HashMap<>();
			List<FinancialIncomeStatmentDTO> factIngredients = null;
			final String uri = "http://localhost:8080/springrestexample/employees.json";
			String line = "";
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			for (int z = 0; z <= 7; z++) {
				String fiscalYear=year[z];
				
				for (int i = 0; i <= 3; i++) {

					String fiscalQuarter = "fiscal_period=" + "Q" + i;
					ResponseEntity<StandardIncomeStatment> result = restTemplate.exchange(
							"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=income_statement&fiscal_year="+fiscalYear+"&"
									+ fiscalQuarter,
							HttpMethod.GET, request, StandardIncomeStatment.class);
					String tesrtUrl="https://api.intrinio.com/financials/standardized?identifier=EOG&statement=income_statement&fiscal_year="+fiscalYear+"&"+ fiscalQuarter;
					System.out.println(tesrtUrl);
					StandardIncomeStatment data = result.getBody();
					crrentPage = data.getCurrent_page();
					totalPage = data.getTotal_pages();
					List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
					// delegate.saveFinancialIncomeData(factIngredientDTOs);

					if ((crrentPage != totalPage) && (totalPage>1)) {
						crrentPage += 1;
						String urlAttr = ("page_index=" + crrentPage);
						ResponseEntity<StandardIncomeStatment> results = restTemplate.exchange(
								"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=income_statement&fiscal_year="+fiscalYear+"&"+fiscalQuarter+"&page_index="+crrentPage,
								HttpMethod.GET, request, StandardIncomeStatment.class);
						data = result.getBody();
						crrentPage = data.getCurrent_page();
						List<FinancialIncomeStatmentDTO> IncomeStatments = data.getData();
						// delegate.saveFinancialIncomeData(IncomeStatments);

					}

					//System.out.println(data);
				}

			}

			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
