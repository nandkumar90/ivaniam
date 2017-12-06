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
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.arial.ivanium.delegate.DatabaseDelegate;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.Historical_data_Common_DTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;
import com.arial.ivanium.dto.StandardCompaniesData;
import com.arial.ivanium.dto.StandardFinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.BalanceSheetDTO;
import com.arial.ivanium.dto.CalculationsDTO;
import com.arial.ivanium.dto.CashFlowStatementDTO;
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

	@RequestMapping(value = "/fact/getAllExternalData/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllExternalData(@PathVariable("ticker") String  ticker) {
		try {
			List<FinancialIncomeStatmentDTO> factIngredientDTOs = new ArrayList<>();
			Map<String, Integer> pagedetail = new HashMap<>();
			List<FinancialIncomeStatmentDTO> factIngredients = null;
			final String uri = "http://localhost:8080/springrestexample/employees.json";
			String line = "";
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> result = restTemplate.exchange(
					"https://api.intrinio.com/financials/standardized.csv?fiscal_period=FY&fiscal_year=2016&statement=income_statement&ticker="+ticker,
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

			//delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// this consist income statment and calculation section of requirment
	@RequestMapping(value = "/fact/getStandardIncomeStatmentData/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllIncomeStatmentData(@PathVariable("ticker") String  ticker) {
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
			//set header 
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			
			//headers = "http://localhost:8080/ivanium//fact/getAllExternalData";
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			StandardFinancialIncomeStatmentDTO financialIncomedto=new StandardFinancialIncomeStatmentDTO();
			financialIncomedto.setStatement("StandardIncomeStatment");
			financialIncomedto.setTicker(ticker);
			for (int z = 0; z <= 7; z++) {
				String fiscalYear = year[z];
				financialIncomedto.setFiscal_year(fiscalYear);

				for (int i = 0; i <= 4; i++) {
					financialIncomedto.setFiscal_period(period[i]);

					String fiscalQuarter = "fiscal_period=" + period[i];
					ResponseEntity<StandardIncomeStatment> result = restTemplate.exchange(
							"https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=income_statement&fiscal_year="
									+ fiscalYear + "&" + fiscalQuarter,
							HttpMethod.GET, request, StandardIncomeStatment.class);

					String tesrtUrl = "https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=income_statement&fiscal_year="
							+ fiscalYear + "&" + fiscalQuarter;
					System.out.println(tesrtUrl);
					StandardIncomeStatment data = result.getBody();
					crrentPage = data.getCurrent_page();
					totalPage = data.getTotal_pages();
					List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
					
					for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment) {
						String tagName=financialIncomeStatmentDTO.getTag();
						String tag=financialIncomeStatmentDTO.getValue();
						
						switch(tagName) {
						
						case "operatingrevenue":{financialIncomedto.setOperatingrevenue(tag);break;}
						case "otherrevenue":{financialIncomedto.setOtherrevenue(tag);break;}
					    case "totalrevenue":{financialIncomedto.setTotalrevenue(tag);break;}
						case "operatingcostofrevenue":{financialIncomedto.setOperatingcostofrevenue(tag);break;}
						case "othercostofrevenue":{financialIncomedto.setOthercostofrevenue(tag);break;}
						case "totalcostofrevenue":{financialIncomedto.setTotalcostofrevenue(tag);break;}
						case "totalgrossprofit":{financialIncomedto.setTotalgrossprofit(tag);break;}
						case "sgaexpense":{financialIncomedto.setSgaexpense(tag);break;}
						case "marketingexpense":{financialIncomedto.setMarketingexpense(tag);break;}
						case "explorationexpense":{financialIncomedto.setExplorationexpense(tag);break;}
						case "depreciationexpense":{financialIncomedto.setDepreciationexpense(tag);break;}
						case "impairmentexpense":{financialIncomedto.setImpairmentexpense(tag);break;}
						//case "otherspecialcharges":{financialIncomedto.setOtherspecialcharges(tag); break;}
						case "totaloperatingexpenses":{financialIncomedto.setTotaloperatingexpenses(tag);break;}
						case "totaloperatingincome":{financialIncomedto.setTotaloperatingincome(tag);break;}
						case "totalinterestexpense":{financialIncomedto.setTotalinterestexpense(tag);break;}
						case "otherincome":{financialIncomedto.setOtherincome(tag);break;}
						case "totalotherincome":{financialIncomedto.setTotalotherincome(tag);break;}
						case "totalpretaxincome":{financialIncomedto.setTotalpretaxincome(tag);break;}
						case "incometaxexpense":{financialIncomedto.setIncometaxexpense(tag);break;}
						case "netincomecontinuing":{financialIncomedto.setNetincomecontinuing(tag);break;}
						case "netincome":{financialIncomedto.setNetincome(tag);break;}
						case "netincometocommon":{financialIncomedto.setNetincometocommon(tag);break;}
						case "weightedavebasicsharesos":{financialIncomedto.setWeightedavebasicsharesos(tag);break;}
						case "basiceps":{financialIncomedto.setBasiceps(tag);break;}
						case "weightedavedilutedsharesos":{financialIncomedto.setWeightedavedilutedsharesos(tag);break;}
						case "dilutedeps":{financialIncomedto.setDilutedeps(tag);break;}

						case "weightedavebasicdilutedsharesos":{financialIncomedto.setWeightedavebasicdilutedsharesos(tag);break;}
						case "basicdilutedeps":{financialIncomedto.setBasicdilutedeps(tag);break;}
						case "cashdividendspershare":{financialIncomedto.setCashdividendspershare(tag);break;}
						
						
						}
						
					}
					delegate.saveFinancialIncomeData(financialIncomedto);

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

	
	//
	// this consist income statment and calculation section of requirment
		@RequestMapping(value = "/fact/getCalculation/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String getCalculationData(@PathVariable("ticker") String  ticker) {
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
				//set header 
				headers.add("Authorization",
						"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
				
				//headers = "http://localhost:8080/ivanium//fact/getAllExternalData";
				HttpEntity<String> request = new HttpEntity<String>(headers);
				RestTemplate restTemplate = new RestTemplate();
				
				
			
				CalculationsDTO caculationto = new CalculationsDTO();
				
				
				//StandardFinancialIncomeStatmentDTO financialIncomedto=new StandardFinancialIncomeStatmentDTO();
				caculationto.setStatement("StandardIncomeStatment");
				caculationto.setTicker(ticker);
									
				
			
				

			
				for (int z = 0; z <= 7; z++) {
					String fiscalYear = year[z];
					caculationto.setFiscal_year(fiscalYear);

					for (int i = 0; i <= 4; i++) {
						
						caculationto.setFiscal_period(period[i]);

						String fiscalQuarter = "fiscal_period=" + period[i];
						ResponseEntity<StandardIncomeStatment> result = restTemplate.exchange(
								"https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=calculations&fiscal_year="
										+ fiscalYear + "&" + fiscalQuarter,
								HttpMethod.GET, request, StandardIncomeStatment.class);
						String tesrtUrl = "https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=calculations&fiscal_year="
								+ fiscalYear + "&" + fiscalQuarter;
						
						
						System.out.println(tesrtUrl);
						StandardIncomeStatment data = result.getBody();
						crrentPage = data.getCurrent_page();
						totalPage = data.getTotal_pages();
						List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
						//delegate.saveFinancialIncomeData(IncomeStatment);
						
						/*for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment) {

							String tagName = financialIncomeStatmentDTO.getTag();
							System.out.println("case \"" + tagName + "\":{caculationto.set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1) + "(tag);break;}");
						}*/
						
						for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment) {
							
							String tagName=financialIncomeStatmentDTO.getTag();
							String tag=financialIncomeStatmentDTO.getValue();	
							
												
								switch(tagName) {
							
							//need to define all case for all instance parameter
								
								case "revenuegrowth":{caculationto.setRevenuegrowth(tag);break;}
								case "nopat":{caculationto.setNopat(tag);break;}
								case "nopatmargin":{caculationto.setNopatmargin(tag);break;}
								case "investedcapital":{caculationto.setInvestedcapital(tag);break;}
								case "investedcapitalturnover":{caculationto.setInvestedcapitalturnover(tag);break;}
								case "investedcapitalincreasedecrease":{caculationto.setInvestedcapitalincreasedecrease(tag);break;}
								case "freecashflow":{caculationto.setFreecashflow(tag);break;}
								case "netnonopex":{caculationto.setNetnonopex(tag);break;}
								case "netnonopobligations":{caculationto.setNetnonopobligations(tag);break;}
								case "ebit":{caculationto.setEbit(tag);break;}
								case "depreciationandamortization":{caculationto.setDepreciationandamortization(tag);break;}
								case "ebitda":{caculationto.setEbitda(tag);break;}
								case "capex":{caculationto.setCapex(tag);break;}
								case "dfcfnwc":{caculationto.setDfcfnwc(tag);break;}
								case "dfnwc":{caculationto.setDfnwc(tag);break;}
								case "nwc":{caculationto.setNwc(tag);break;}
								case "debt":{caculationto.setDebt(tag);break;}
								case "ltdebtandcapleases":{caculationto.setLtdebtandcapleases(tag);break;}
								case "netdebt":{caculationto.setNetdebt(tag);break;}
								case "totalcapital":{caculationto.setTotalcapital(tag);break;}
								case "bookvaluepershare":{caculationto.setBookvaluepershare(tag);break;}
								case "tangbookvaluepershare":{caculationto.setTangbookvaluepershare(tag);break;}
								case "marketcap":{caculationto.setMarketcap(tag);break;}
								case "enterprisevalue":{caculationto.setEnterprisevalue(tag);break;}
								case "pricetobook":{caculationto.setPricetobook(tag);break;}
								case "pricetotangiblebook":{caculationto.setPricetotangiblebook(tag);break;}
								case "pricetorevenue":{caculationto.setPricetorevenue(tag);break;}
								case "pricetoearnings":{caculationto.setPricetoearnings(tag);break;}
								case "dividendyield":{caculationto.setDividendyield(tag);break;}
								case "earningsyield":{caculationto.setEarningsyield(tag);break;}
								case "evtoinvestedcapital":{caculationto.setEvtoinvestedcapital(tag);break;}
								case "evtorevenue":{caculationto.setEvtorevenue(tag);break;}
								case "evtoebitda":{caculationto.setEvtoebitda(tag);break;}
								case "evtoebit":{caculationto.setEvtoebit(tag);break;}
								case "evtonopat":{caculationto.setEvtonopat(tag);break;}
								case "evtoocf":{caculationto.setEvtoocf(tag);break;}
								case "evtofcff":{caculationto.setEvtofcff(tag);break;}
								case "ebitdagrowth":{caculationto.setEbitdagrowth(tag);break;}
								case "ebitgrowth":{caculationto.setEbitgrowth(tag);break;}
								case "nopatgrowth":{caculationto.setNopatgrowth(tag);break;}
								case "netincomegrowth":{caculationto.setNetincomegrowth(tag);break;}
								case "epsgrowth":{caculationto.setEpsgrowth(tag);break;}
								case "ocfgrowth":{caculationto.setOcfgrowth(tag);break;}
								case "fcffgrowth":{caculationto.setFcffgrowth(tag);break;}
								case "investedcapitalgrowth":{caculationto.setInvestedcapitalgrowth(tag);break;}
								case "revenueqoqgrowth":{caculationto.setRevenueqoqgrowth(tag);break;}
								case "ebitdaqoqgrowth":{caculationto.setEbitdaqoqgrowth(tag);break;}
								case "ebitqoqgrowth":{caculationto.setEbitqoqgrowth(tag);break;}
								case "nopatqoqgrowth":{caculationto.setNopatqoqgrowth(tag);break;}
								case "netincomeqoqgrowth":{caculationto.setNetincomeqoqgrowth(tag);break;}
								case "epsqoqgrowth":{caculationto.setEpsqoqgrowth(tag);break;}
								case "ocfqoqgrowth":{caculationto.setOcfqoqgrowth(tag);break;}
								case "fcffqoqgrowth":{caculationto.setFcffqoqgrowth(tag);break;}
								case "investedcapitalqoqgrowth":{caculationto.setInvestedcapitalqoqgrowth(tag);break;}
								case "grossmargin":{caculationto.setGrossmargin(tag);break;}
								case "ebitdamargin":{caculationto.setEbitdamargin(tag);break;}
								case "operatingmargin":{caculationto.setOperatingmargin(tag);break;}
								case "ebitmargin":{caculationto.setEbitmargin(tag);break;}
								case "profitmargin":{caculationto.setProfitmargin(tag);break;}
								case "costofrevtorevenue":{caculationto.setCostofrevtorevenue(tag);break;}
								case "sgaextorevenue":{caculationto.setSgaextorevenue(tag);break;}
								case "rdextorevenue":{caculationto.setRdextorevenue(tag);break;}
								case "opextorevenue":{caculationto.setOpextorevenue(tag);break;}
								case "taxburdenpct":{caculationto.setTaxburdenpct(tag);break;}
								case "interestburdenpct":{caculationto.setInterestburdenpct(tag);break;}
								case "efftaxrate":{caculationto.setEfftaxrate(tag);break;}
								case "assetturnover":{caculationto.setAssetturnover(tag);break;}
								case "arturnover":{caculationto.setArturnover(tag);break;}
								case "invturnover":{caculationto.setInvturnover(tag);break;}
								case "faturnover":{caculationto.setFaturnover(tag);break;}
								case "apturnover":{caculationto.setApturnover(tag);break;}
								case "dso":{caculationto.setDso(tag);break;}
								case "dio":{caculationto.setDio(tag);break;}
								case "dpo":{caculationto.setDpo(tag);break;}
								case "ccc":{caculationto.setCcc(tag);break;}
								case "finleverage":{caculationto.setFinleverage(tag);break;}
								case "leverageratio":{caculationto.setLeverageratio(tag);break;}
								case "compoundleveragefactor":{caculationto.setCompoundleveragefactor(tag);break;}
								case "ltdebttoequity":{caculationto.setLtdebttoequity(tag);break;}
								case "debttoequity":{caculationto.setDebttoequity(tag);break;}
								case "roic":{caculationto.setRoic(tag);break;}
								case "nnep":{caculationto.setNnep(tag);break;}
								case "roicnnepspread":{caculationto.setRoicnnepspread(tag);break;}
								case "rnnoa":{caculationto.setRnnoa(tag);break;}
								case "roe":{caculationto.setRoe(tag);break;}
								case "croic":{caculationto.setCroic(tag);break;}
								case "oroa":{caculationto.setOroa(tag);break;}
								case "roa":{caculationto.setRoa(tag);break;}
								case "noncontrollinginterestsharingratio":{caculationto.setNoncontrollinginterestsharingratio(tag);break;}
								case "roce":{caculationto.setRoce(tag);break;}
								case "divpayoutratio":{caculationto.setDivpayoutratio(tag);break;}
								case "augmentedpayoutratio":{caculationto.setAugmentedpayoutratio(tag);break;}
								case "ocftocapex":{caculationto.setOcftocapex(tag);break;}
								case "stdebttocap":{caculationto.setStdebttocap(tag);break;}
								case "ltdebttocap":{caculationto.setLtdebttocap(tag);break;}
								case "debttototalcapital":{caculationto.setDebttototalcapital(tag);break;}
								case "preferredtocap":{caculationto.setPreferredtocap(tag);break;}
								case "noncontrolinttocap":{caculationto.setNoncontrolinttocap(tag);break;}
								case "commontocap":{caculationto.setCommontocap(tag);break;}
								case "debttoebitda":{caculationto.setDebttoebitda(tag);break;}						     	
						     									
								
								
							
							
							}
							
						}
						delegate.saveCalculationData(caculationto);
						
						if ((crrentPage != totalPage) && (totalPage > 1)) {
							crrentPage += 1;
							String urlAttr = ("page_index=" + crrentPage);
							ResponseEntity<StandardIncomeStatment> results = restTemplate.exchange(
									"https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=cash_flow_statement&fiscal_year="
											+ fiscalYear + "&" + fiscalQuarter + "&page_index=" + crrentPage,
									HttpMethod.GET, request, StandardIncomeStatment.class);
							data = result.getBody();
							crrentPage = data.getCurrent_page();
							List<FinancialIncomeStatmentDTO> IncomeStatments = data.getData();
							CalculationsDTO financialIncomeNextdto=new CalculationsDTO();
							//delegate.saveFinancialIncomeData(cashflowNext);

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

	@RequestMapping(value = "/fact/cashflow/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getHistoricaldataFacts(@PathVariable("ticker") String  ticker) {
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
			//set header 
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			
			//headers = "http://localhost:8080/ivanium//fact/getAllExternalData";
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			
			
			CashFlowStatementDTO cashflow = new CashFlowStatementDTO();
			
			
			//StandardFinancialIncomeStatmentDTO financialIncomedto=new StandardFinancialIncomeStatmentDTO();
			cashflow.setStatement("StandardIncomeStatment");
			cashflow.setTicker(ticker);
								
			
		
			

		
			for (int z = 0; z <= 7; z++) {
				String fiscalYear = year[z];
				cashflow.setFiscal_year(fiscalYear);

				for (int i = 0; i <= 4; i++) {
					
					cashflow.setFiscal_period(period[i]);

					String fiscalQuarter = "fiscal_period=" + period[i];
					ResponseEntity<StandardIncomeStatment> result = restTemplate.exchange(
							"https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=cash_flow_statement&fiscal_year="
									+ fiscalYear + "&" + fiscalQuarter,
							HttpMethod.GET, request, StandardIncomeStatment.class);
					String tesrtUrl = "https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=cash_flow_statement&fiscal_year="
							+ fiscalYear + "&" + fiscalQuarter;
					System.out.println(tesrtUrl);
					StandardIncomeStatment data = result.getBody();
					crrentPage = data.getCurrent_page();
					totalPage = data.getTotal_pages();
					List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
					//delegate.saveFinancialIncomeData(IncomeStatment);
					for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment) {
						
						String tagName=financialIncomeStatmentDTO.getTag();
						String tag=financialIncomeStatmentDTO.getValue();	
						
						
						
						
						
							switch(tagName) {
						
					
						
						
						
						case "netincome":{cashflow.setNetincome(tag);break;}
						case "netincomecontinuing":{cashflow.setNetincomecontinuing(tag);break;}
						case "depreciationexpense":{cashflow.setDepreciationexpense(tag);break;}
						case "noncashadjustmentstonetincome":{cashflow.setNoncashadjustmentstonetincome(tag);break;}
						case "increasedecreaseinoperatingcapital":{cashflow.setIncreasedecreaseinoperatingcapital(tag);break;}
						case "netcashfromcontinuingoperatingactivities":{cashflow.setNetcashfromcontinuingoperatingactivities(tag);break;}
						case "netcashfromoperatingactivities":{cashflow.setNetcashfromoperatingactivities(tag);break;}
						case "purchaseofplantpropertyandequipment":{cashflow.setPurchaseofplantpropertyandequipment(tag);break;}
						case "acquisitions":{cashflow.setAcquisitions(tag);break;}
						case "divestitures":{cashflow.setDivestitures(tag);break;}
						case "otherinvestingactivitiesnet":{cashflow.setOtherinvestingactivitiesnet(tag);break;}
						case "netcashfromcontinuinginvestingactivities":{cashflow.setNetcashfromcontinuinginvestingactivities(tag);break;}
						case "netcashfrominvestingactivities":{cashflow.setNetcashfrominvestingactivities(tag);break;}
						case "repaymentofdebt":{cashflow.setRepaymentofdebt(tag);break;}
						case "repurchaseofcommonequity":{cashflow.setRepurchaseofcommonequity(tag);break;}
						case "paymentofdividends":{cashflow.setPaymentofdividends(tag);break;}
						case "issuanceofdebt":{cashflow.setIssuanceofdebt(tag);break;}
						case "issuanceofcommonequity":{cashflow.setIssuanceofcommonequity(tag);break;}
						case "otherfinancingactivitiesnet":{cashflow.setOtherfinancingactivitiesnet(tag);break;}
						case "netcashfromcontinuingfinancingactivities":{cashflow.setNetcashfromcontinuingfinancingactivities(tag);break;}
						case "netcashfromfinancingactivities":{cashflow.setNetcashfromfinancingactivities(tag);break;}
						case "netchangeincash":{cashflow.setNetchangeincash(tag);break;}
					
											
						//need to define all case for all instance parameter
						
						
						}
						
					}
					
					delegate.saveFinancialIncomeData(cashflow);
					
					
					
					if ((crrentPage != totalPage) && (totalPage > 1)) {
						crrentPage += 1;
						String urlAttr = ("page_index=" + crrentPage);
						ResponseEntity<StandardIncomeStatment> results = restTemplate.exchange(
								"https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=cash_flow_statement&fiscal_year="
										+ fiscalYear + "&" + fiscalQuarter + "&page_index=" + crrentPage,
								HttpMethod.GET, request, StandardIncomeStatment.class);
						data = result.getBody();
						crrentPage = data.getCurrent_page();
						List<FinancialIncomeStatmentDTO> IncomeStatments = data.getData();
						CashFlowStatementDTO cashflowNext=new CashFlowStatementDTO();
						//delegate.saveFinancialIncomeData(cashflowNext);

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
	@RequestMapping(value = "/fact/balancesheet/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getIntiutionalOwnershipFacts(@PathVariable("ticker") String  ticker) {
		
		
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
		//set header 
		headers.add("Authorization",
				"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
		
		//headers = "http://localhost:8080/ivanium//fact/getAllExternalData";
		HttpEntity<String> request = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		
		
		BalanceSheetDTO balanceSheetDTO = new BalanceSheetDTO();
		
		
		//StandardFinancialIncomeStatmentDTO financialIncomedto=new StandardFinancialIncomeStatmentDTO();
		balanceSheetDTO.setStatement("StandardIncomeStatment");
		balanceSheetDTO.setTicker(ticker);
		for (int z = 0; z <= 7; z++) {
			String fiscalYear = year[z];
			balanceSheetDTO.setFiscal_year(fiscalYear);

			for (int i = 0; i <= 4; i++) {
				balanceSheetDTO.setFiscal_period(period[i]);

				String fiscalQuarter = "fiscal_period=" + period[i];
				ResponseEntity<StandardIncomeStatment> result = restTemplate.exchange(
						"https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=balance_sheet&fiscal_year="
								+ fiscalYear + "&" + fiscalQuarter,
						HttpMethod.GET, request, StandardIncomeStatment.class);

				String tesrtUrl = "https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=balance_sheet&fiscal_year="
						+ fiscalYear + "&" + fiscalQuarter;
				System.out.println(tesrtUrl);
				StandardIncomeStatment data = result.getBody();
				crrentPage = data.getCurrent_page();
				totalPage = data.getTotal_pages();
				List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
				
				for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment) {
					
				
					String tagName=financialIncomeStatmentDTO.getTag();
					String tag=financialIncomeStatmentDTO.getValue();				
						switch(tagName) {
						
						//need to define all case for all instance parameter
						
						
						case "cashandequivalents":{balanceSheetDTO.setCashandequivalents(tag);break;}
						case "accountsreceivable":{balanceSheetDTO.setAccountsreceivable(tag);break;}
						case "netinventory":{balanceSheetDTO.setNetinventory(tag);break;}
						case "othercurrentassets":{balanceSheetDTO.setOthercurrentassets(tag);break;}
						case "totalcurrentassets":{balanceSheetDTO.setTotalcurrentassets(tag);break;}
						case "grossppe":{balanceSheetDTO.setGrossppe(tag);break;}
						case "accumulateddepreciation":{balanceSheetDTO.setAccumulateddepreciation(tag);break;}
						case "netppe":{balanceSheetDTO.setNetppe(tag);break;}
						case "othernoncurrentassets":{balanceSheetDTO.setOthernoncurrentassets(tag);break;}
						case "totalnoncurrentassets":{balanceSheetDTO.setTotalnoncurrentassets(tag);break;}
						case "totalassets":{balanceSheetDTO.setTotalassets(tag);break;}
						case "shorttermdebt":{balanceSheetDTO.setShorttermdebt(tag);break;}
						case "accountspayable":{balanceSheetDTO.setAccountspayable(tag);break;}
						case "othercurrentliabilities":{balanceSheetDTO.setOthercurrentliabilities(tag);break;}
						case "totalcurrentliabilities":{balanceSheetDTO.setTotalcurrentliabilities(tag);break;}
						case "longtermdebt":{balanceSheetDTO.setLongtermdebt(tag);break;}
						case "othernoncurrentliabilities":{balanceSheetDTO.setOthernoncurrentliabilities(tag);break;}
						case "totalnoncurrentliabilities":{balanceSheetDTO.setTotalnoncurrentliabilities(tag);break;}
						case "totalliabilities":{balanceSheetDTO.setTotalliabilities(tag);break;}
						case "commitmentsandcontingencies":{balanceSheetDTO.setCommitmentsandcontingencies(tag);break;}
						case "commonequity":{balanceSheetDTO.setCommonequity(tag);break;}
						case "retainedearnings":{balanceSheetDTO.setRetainedearnings(tag);break;}
						case "treasurystock":{balanceSheetDTO.setTreasurystock(tag);break;}
						case "aoci":{balanceSheetDTO.setAoci(tag);break;}
						case "totalcommonequity":{balanceSheetDTO.setTotalcommonequity(tag);break;}
						case "totalequity":{balanceSheetDTO.setTotalequity(tag);break;}
						case "totalequityandnoncontrollinginterests":{balanceSheetDTO.setTotalequityandnoncontrollinginterests(tag);break;}
						case "totalliabilitiesandequity":{balanceSheetDTO.setTotalliabilitiesandequity(tag);break;}
						case "currentdeferredtaxassets":{balanceSheetDTO.setCurrentdeferredtaxassets(tag);break;}
						case "noncurrentdeferredtaxassets":{balanceSheetDTO.setNoncurrentdeferredtaxassets(tag);break;}
						case "dividendspayable":{balanceSheetDTO.setDividendspayable(tag);break;}
						case "currentdeferredtaxliabilities":{balanceSheetDTO.setCurrentdeferredtaxliabilities(tag);break;}
						case "noncurrentdeferredtaxliabilities":{balanceSheetDTO.setNoncurrentdeferredtaxliabilities(tag);break;}
									
						}
						
					}
					delegate.saveFinancialIncomeData(balanceSheetDTO);

					if ((crrentPage != totalPage) && (totalPage > 1)) {
						crrentPage += 1;
						String urlAttr = ("page_index=" + crrentPage);
						ResponseEntity<StandardIncomeStatment> results = restTemplate.exchange(
								"https://api.intrinio.com/financials/standardized?identifier="+ticker+"&statement=balance_sheet&fiscal_year="
										+ fiscalYear + "&" + fiscalQuarter + "&page_index=" + crrentPage,
								HttpMethod.GET, request, StandardIncomeStatment.class);
						data = result.getBody();
						crrentPage = data.getCurrent_page();
						List<FinancialIncomeStatmentDTO> IncomeStatments = data.getData();
					//	delegate.saveFinancialIncomeData(IncomeStatments);

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
/*	@RequestMapping(value = "/fact/dailyscript/closedprice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getHistoryClosedPrice() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			//set header 
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=close_price", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<HistoricaldataDTO> IncomeStatment = data.getData();
			for (HistoricaldataDTO financialIncomeStatmentDTO : IncomeStatment) {
				financialIncomeStatmentDTO.setTicker("EOG");
				financialIncomeStatmentDTO.setItem("close_price");		
				}
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
				for (HistoricaldataDTO financialIncomeStatmentDTO : IncomeStatments) {
					financialIncomeStatmentDTO.setTicker("EOG");
					financialIncomeStatmentDTO.setItem("close_price");				
					}
				delegate.saveDailyScriptClosedPriceData(IncomeStatments);
			}
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/

	
	
	
	
	// daily script for volume
/*	@RequestMapping(value = "/fact/dailyscript/volume", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getdailyscriptVomume() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=volume", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<HistoricaldataDTO> IncomeStatment = data.getData();
			for (HistoricaldataDTO financialIncomeStatmentDTO : IncomeStatment) {
				financialIncomeStatmentDTO.setTicker("EOG");
				financialIncomeStatmentDTO.setItem("volume");				
				}
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
				for (HistoricaldataDTO financialIncomeStatmentDTO : IncomeStatments) {
					financialIncomeStatmentDTO.setTicker("EOG");
					financialIncomeStatmentDTO.setItem("volume");				
					}
				delegate.saveDailyScriptClosedPriceData(IncomeStatments);
			}
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}*/

	
	
	// daily script for beta
	/*@RequestMapping(value = "/fact/dailyscript/beta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getdailyscriptBeta() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			//set header 
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=beta", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<HistoricaldataDTO> IncomeStatment = data.getData();
			for (HistoricaldataDTO financialIncomeStatmentDTO : IncomeStatment) {
				financialIncomeStatmentDTO.setTicker("EOG");
				financialIncomeStatmentDTO.setItem("beta");				
				}
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
				for (HistoricaldataDTO financialIncomeStatmentDTO : IncomeStatments) {
					financialIncomeStatmentDTO.setTicker("EOG");
					financialIncomeStatmentDTO.setItem("beta");				
					}
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

	}*/

	@RequestMapping(value = "/fact/dailyscript/news/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getdailyscriptNews(@PathVariable("ticker") String  ticker) {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			//set header 
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardNewsDTO> result = restTemplate.exchange(
					"https://api.intrinio.com/news?identifier="+ticker, HttpMethod.GET, request,
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
						"https://api.intrinio.com/news?identifier="+ticker, HttpMethod.GET, request,
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
	@RequestMapping(value = "/fact/biweeklyscript/shortinterest/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBiWeeklyShortInterest(@PathVariable("ticker") String  ticker) {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			
			HttpHeaders headers = new HttpHeaders();
			//set header 
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier="+ticker+"&item=short_interest", HttpMethod.GET,
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
						"https://api.intrinio.com/historical_data?identifier="+ticker+"&item=short_interest", HttpMethod.GET,
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
	@RequestMapping(value = "/fact/biweeklyscript/instuitional/ownership/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getBiWeeklyInstuitional(@PathVariable("ticker") String  ticker) {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			HttpHeaders headers = new HttpHeaders();
			//set header 
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StandardInstuitionalOwnershipDTO> result = restTemplate.exchange(
					"https://api.intrinio.com/securities/institutional_ownership?identifier="+ticker, HttpMethod.GET,
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
						"https://api.intrinio.com/securities/institutional_ownership?identifier="+ticker, HttpMethod.GET,
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
	/*@RequestMapping(value = "/fact/biweeklyscript/quaterly/script/companies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getQuaterlyScript() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
		
			
			HttpHeaders headers = new HttpHeaders();
			//set header
			headers.add("Authorization",
					"Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
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

	}*/
	
	
	
	

}
