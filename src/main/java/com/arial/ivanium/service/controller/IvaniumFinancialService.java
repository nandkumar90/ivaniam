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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.arial.ivanium.delegate.DatabaseDelegate;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;
import com.arial.ivanium.dto.StandardCompaniesData;
import com.arial.ivanium.dto.CompaniesDTO;
import com.arial.ivanium.dto.StandardHistoricalData;
import com.arial.ivanium.dto.StandardIncomeStatment;
import com.arial.ivanium.dto.StandardInstuitionalOwnershipDTO;
import com.arial.ivanium.dto.StandardNewsDTO;

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

	// this consist income statment and calculation section of requirment
	@RequestMapping(value = "/fact/getStandardIncomeStatmentData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllIncomeStatmentData() {
		try {
			String[] year = { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" };
			String[] period = { "Q1", "Q2", "Q3", "Q4", "FY" };

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
				String fiscalYear = year[z];

				for (int i = 0; i <= 4; i++) {

					String fiscalQuarter = "fiscal_period=" + period[i];
					ResponseEntity<StandardIncomeStatment> result = restTemplate.exchange(
							"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=income_statement&fiscal_year="
									+ fiscalYear + "&" + fiscalQuarter,
							HttpMethod.GET, request, StandardIncomeStatment.class);
					String tesrtUrl = "https://api.intrinio.com/financials/standardized?identifier=EOG&statement=income_statement&fiscal_year="
							+ fiscalYear + "&" + fiscalQuarter;
					System.out.println(tesrtUrl);
					StandardIncomeStatment data = result.getBody();
					crrentPage = data.getCurrent_page();
					totalPage = data.getTotal_pages();
					List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
					delegate.saveFinancialIncomeData(factIngredientDTOs);

					if ((crrentPage != totalPage) && (totalPage > 1)) {
						crrentPage += 1;
						String urlAttr = ("page_index=" + crrentPage);
						ResponseEntity<StandardIncomeStatment> results = restTemplate.exchange(
								"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=income_statement&fiscal_year="
										+ fiscalYear + "&" + fiscalQuarter + "&page_index=" + crrentPage,
								HttpMethod.GET, request, StandardIncomeStatment.class);
						data = result.getBody();
						crrentPage = data.getCurrent_page();
						List<FinancialIncomeStatmentDTO> IncomeStatments = data.getData();
						delegate.saveFinancialIncomeData(IncomeStatments);

					}

					// System.out.println(data);
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

	// daily script

	@RequestMapping(value = "/fact/cashflow", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getHistoricaldataFacts() {
		try {
			String[] year = { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" };
			String[] period = { "Q1", "Q2", "Q3", "Q4", "FY" };

			int crrentPage = 0;
			int totalPage = 0;
		
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			for (int z = 0; z <= 7; z++) {
				String fiscalYear = year[z];

				for (int i = 0; i <= 4; i++) {

					String fiscalQuarter = "fiscal_period=" + period[i];
					ResponseEntity<StandardIncomeStatment> result = restTemplate.exchange(
							"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=cash_flow_statement&fiscal_year="
									+ fiscalYear + "&" + fiscalQuarter,
							HttpMethod.GET, request, StandardIncomeStatment.class);
					String tesrtUrl = "https://api.intrinio.com/financials/standardized?identifier=EOG&statement=cash_flow_statement&fiscal_year="
							+ fiscalYear + "&" + fiscalQuarter;
					System.out.println(tesrtUrl);
					StandardIncomeStatment data = result.getBody();
					crrentPage = data.getCurrent_page();
					totalPage = data.getTotal_pages();
					List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
					delegate.saveFinancialIncomeData(IncomeStatment);

					if ((crrentPage != totalPage) && (totalPage > 1)) {
						crrentPage += 1;
						String urlAttr = ("page_index=" + crrentPage);
						ResponseEntity<StandardIncomeStatment> results = restTemplate.exchange(
								"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=cash_flow_statement&fiscal_year="
										+ fiscalYear + "&" + fiscalQuarter + "&page_index=" + crrentPage,
								HttpMethod.GET, request, StandardIncomeStatment.class);
						data = result.getBody();
						crrentPage = data.getCurrent_page();
						List<FinancialIncomeStatmentDTO> IncomeStatments = data.getData();
						delegate.saveFinancialIncomeData(IncomeStatments);

					}

					// System.out.println(data);
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

	// bi-weekly ownership
	@RequestMapping(value = "/fact/balancesheet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getIntiutionalOwnershipFacts() {
		try {
			String[] year = { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" };
			String[] period = { "Q1", "Q2", "Q3", "Q4", "FY" };

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			for (int z = 0; z <= 7; z++) {
				String fiscalYear = year[z];

				for (int i = 0; i <= 4; i++) {

					String fiscalQuarter = "fiscal_period=" + period[i];
					ResponseEntity<StandardIncomeStatment> result = restTemplate.exchange(
							"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=balance_sheet&fiscal_year="
									+ fiscalYear + "&" + fiscalQuarter,
							HttpMethod.GET, request, StandardIncomeStatment.class);
					String tesrtUrl = "https://api.intrinio.com/financials/standardized?identifier=EOG&statement=balance_sheet&fiscal_year="
							+ fiscalYear + "&" + fiscalQuarter;
					System.out.println(tesrtUrl);
					StandardIncomeStatment data = result.getBody();
					crrentPage = data.getCurrent_page();
					totalPage = data.getTotal_pages();
					List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
					delegate.saveFinancialIncomeData(IncomeStatment);

					if ((crrentPage != totalPage) && (totalPage > 1)) {
						crrentPage += 1;
						String urlAttr = ("page_index=" + crrentPage);
						ResponseEntity<StandardIncomeStatment> results = restTemplate.exchange(
								"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=balance_sheet&fiscal_year="
										+ fiscalYear + "&" + fiscalQuarter + "&page_index=" + crrentPage,
								HttpMethod.GET, request, StandardIncomeStatment.class);
						data = result.getBody();
						crrentPage = data.getCurrent_page();
						List<FinancialIncomeStatmentDTO> IncomeStatments = data.getData();
						delegate.saveFinancialIncomeData(IncomeStatments);

					}

					// System.out.println(data);
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

	// daily script for closed price

	@RequestMapping(value = "/fact/dailyscript/closedprice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getHistoryClosedPrice() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=close_price", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<HistoricaldataDTO> IncomeStatment = data.getData();
			delegate.saveDailyScriptClosedPriceData(IncomeStatment);

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_index=" + crrentPage);
				ResponseEntity<HistoricaldataDTO> results = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=close_price", HttpMethod.GET,
						request, HistoricaldataDTO.class);
				data = result.getBody();
				crrentPage = data.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = data.getData();
				delegate.saveDailyScriptClosedPriceData(IncomeStatments);

			}

			// System.out.println(data);

			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// daily script for volume

	@RequestMapping(value = "/fact/dailyscript/volume", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getdailyscriptVomume() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=volume", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<HistoricaldataDTO> IncomeStatment = data.getData();
			delegate.saveDailyScriptClosedPriceData(IncomeStatment);

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_index=" + crrentPage);
				ResponseEntity<HistoricaldataDTO> results = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=volume", HttpMethod.GET, request,
						HistoricaldataDTO.class);
				data = result.getBody();
				crrentPage = data.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = data.getData();
				delegate.saveDailyScriptClosedPriceData(IncomeStatments);

			}

			// System.out.println(data);

			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// daily script for beta

	@RequestMapping(value = "/fact/dailyscript/beta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getdailyscriptBeta() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
		
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=beta", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<HistoricaldataDTO> IncomeStatment = data.getData();
			delegate.saveDailyScriptClosedPriceData(IncomeStatment);

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_index=" + crrentPage);
				ResponseEntity<HistoricaldataDTO> results = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=beta", HttpMethod.GET, request,
						HistoricaldataDTO.class);
				data = result.getBody();
				crrentPage = data.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = data.getData();
				delegate.saveDailyScriptClosedPriceData(IncomeStatments);

			}

			// System.out.println(data);

			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/fact/dailyscript/news", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getdailyscriptNews() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardNewsDTO> result = restTemplate.exchange(
					"https://api.intrinio.com/news?identifier=EOG", HttpMethod.GET, request,
					StandardNewsDTO.class);
			StandardNewsDTO data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<NewsDTO> neswss = data.getData();
			delegate.saveDailyScriptNewsData(neswss);

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_index=" + crrentPage);
				ResponseEntity<HistoricaldataDTO> results = restTemplate.exchange(
						"https://api.intrinio.com/news?identifier=EOG", HttpMethod.GET, request,
						HistoricaldataDTO.class);
				data = result.getBody();
				crrentPage = data.getCurrent_page();
				List<NewsDTO> news = data.getData();
				delegate.saveDailyScriptNewsData(news);

			}

			// System.out.println(data);

			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// bi weekly script short interest
	@RequestMapping(value = "/fact/biweeklyscript/shortinterest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBiWeeklyShortInterest() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=short_interest", HttpMethod.GET,
					request, StandardHistoricalData.class);
			StandardHistoricalData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<HistoricaldataDTO> factIngredientDTOs = data.getData();
			delegate.saveDailyScriptClosedPriceData(factIngredientDTOs);

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_index=" + crrentPage);
				ResponseEntity<HistoricaldataDTO> results = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=short_interest", HttpMethod.GET,
						request, HistoricaldataDTO.class);
				data = result.getBody();
				crrentPage = data.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = data.getData();
				delegate.saveDailyScriptClosedPriceData(IncomeStatments);

			}

			// System.out.println(data);

			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// bi weekly script short interest
	@RequestMapping(value = "/fact/biweeklyscript/instuitional/ownership", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBiWeeklyInstuitional() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardInstuitionalOwnershipDTO> result = restTemplate.exchange(
					"https://api.intrinio.com/securities/institutional_ownership?identifier=EOG", HttpMethod.GET,
					request, StandardInstuitionalOwnershipDTO.class);
			StandardInstuitionalOwnershipDTO data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<IntiutionalOwnershipDTO> factIngredientDTOs = data.getData();
			delegate.saveWeeklyTnstuitionalOwnership(factIngredientDTOs);

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_index=" + crrentPage);
				ResponseEntity<HistoricaldataDTO> results = restTemplate.exchange(
						"https://api.intrinio.com/securities/institutional_ownership?identifier=EOG", HttpMethod.GET,
						request, HistoricaldataDTO.class);
				data = result.getBody();
				crrentPage = data.getCurrent_page();
				List<IntiutionalOwnershipDTO> IncomeStatments = data.getData();
				delegate.saveWeeklyTnstuitionalOwnership(IncomeStatments);

			}

			// System.out.println(data);

			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// bi weekly script short interest
	@RequestMapping(value = "/fact/biweeklyscript/quaterly/script/companies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getQuaterlyScript() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
		
			
			HttpHeaders headers = new HttpHeaders();
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardCompaniesData> result = restTemplate.exchange(
					"https://api.intrinio.com/companies/filings?identifier=EOG", HttpMethod.GET, request,
					StandardCompaniesData.class);
			StandardCompaniesData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<CompaniesDTO> companiesData = data.getData();
			delegate.saveQuaterlyComapniesData(companiesData);

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_index=" + crrentPage);
				ResponseEntity<HistoricaldataDTO> results = restTemplate.exchange(
						"https://api.intrinio.com/companies/filings?identifier=EOG", HttpMethod.GET, request,
						HistoricaldataDTO.class);
				data = result.getBody();
				crrentPage = data.getCurrent_page();
				List<CompaniesDTO> compnaie = data.getData();
				delegate.saveQuaterlyComapniesData(compnaie);

			}

			// System.out.println(data);

			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
