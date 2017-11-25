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
import java.util.Map.Entry;

import com.arial.ivanium.delegate.DatabaseDelegate;

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
import com.arial.ivanium.dto.Historical_data_Common_DTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;
import com.arial.ivanium.dto.StandardCompaniesData;
import com.arial.ivanium.dto.StandardFinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.BalanceSheetDTO;
import com.arial.ivanium.dto.CalculationsDTO;
import com.arial.ivanium.dto.CashFlowStatementDTO;
import com.arial.ivanium.dto.Common_CompDTO;
import com.arial.ivanium.dto.Common_financial_data_DTO;
import com.arial.ivanium.dto.CompaniesDTO;
import com.arial.ivanium.dto.StandardHistoricalData;
import com.arial.ivanium.dto.StandardIncomeStatment;
import com.arial.ivanium.dto.StandardInstuitionalOwnershipDTO;
import com.arial.ivanium.dto.StandardNewsDTO;

@Controller
public class CommonDatabaseService {
	
	@Autowired
	private DatabaseDelegate delegate;

	
	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}

	

	@RequestMapping(value = "/common/daily/historydata", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getHistoryClosedPrices() {
		try {

			int crrentPage = 0;
			int totalPage = 0;
			Historical_data_Common_DTO common_DTO=new Historical_data_Common_DTO("EOG");
			Map<String, Historical_data_Common_DTO> histomryObjecTmap=new HashMap<>();

			HttpHeaders headers = new HttpHeaders();
			//set header 
			headers.add("Authorization", "Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();

			//for close price 
			ResponseEntity<StandardHistoricalData> result = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=close_price", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData data = result.getBody();
			crrentPage = data.getCurrent_page();
			totalPage = data.getTotal_pages();
			List<HistoricaldataDTO> IncomeStatment = data.getData();
			histomryObjecTmap=setValuesInMap(IncomeStatment,histomryObjecTmap, "close_price" ,"EOG");
			
			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_number =" + crrentPage);
				ResponseEntity<StandardHistoricalData> results = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=close_price&"+urlAttr, HttpMethod.GET,
						request, StandardHistoricalData.class);
				StandardHistoricalData datas = results.getBody();
				crrentPage = datas.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = datas.getData();
				histomryObjecTmap=setValuesInMap(IncomeStatments,histomryObjecTmap, "close_price" ,"EOG");

			}

			
			//for volume
			ResponseEntity<StandardHistoricalData> resultVOlume = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=volume", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData dataVolume = resultVOlume.getBody();
			crrentPage = dataVolume.getCurrent_page();
			totalPage = dataVolume.getTotal_pages();
			List<HistoricaldataDTO> volume = dataVolume.getData();
			histomryObjecTmap=setValuesInMap(volume,histomryObjecTmap, "volume" ,"EOG");


			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_number=" + crrentPage);
				ResponseEntity<StandardHistoricalData> resultss = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=volume"+urlAttr, HttpMethod.GET, request,
						StandardHistoricalData.class);
				StandardHistoricalData dataVolumes = resultVOlume.getBody();

				crrentPage = dataVolumes.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = dataVolumes.getData();
				histomryObjecTmap=setValuesInMap(IncomeStatments,histomryObjecTmap, "volume" ,"EOG");

			}
			
			//for beta 
			ResponseEntity<StandardHistoricalData> resultBeta = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=beta", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData datas = resultBeta.getBody();
			crrentPage = datas.getCurrent_page();
			totalPage = datas.getTotal_pages();
			List<HistoricaldataDTO> beta = datas.getData();
			histomryObjecTmap=setValuesInMap(beta,histomryObjecTmap, "beta" ,"EOG");

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_number=" + crrentPage);
				ResponseEntity<StandardHistoricalData> results = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=beta"+urlAttr, HttpMethod.GET, request,
						StandardHistoricalData.class);
				StandardHistoricalData dataClosedPrice = results.getBody();
				crrentPage = dataClosedPrice.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = dataClosedPrice.getData();
				histomryObjecTmap=setValuesInMap(IncomeStatments,histomryObjecTmap, "beta" ,"EOG");
				
				ArrayList<Historical_data_Common_DTO> historical_data_list = new ArrayList<Historical_data_Common_DTO>();
				
				for (Entry<String, Historical_data_Common_DTO> date : histomryObjecTmap.entrySet()) {
					historical_data_list.add(date.getValue());
				}
				delegate.saveFactHistorycom(historical_data_list);
			}
					
			// System.out.println(data);
			printMap(histomryObjecTmap);
			// delegate.saveFinancialIncomeData(histomryObjecTmap);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	Map<String, Historical_data_Common_DTO> setValuesInMap(List<HistoricaldataDTO> historicaldataDTOs, Map<String, Historical_data_Common_DTO> map, String getKey, String Ticker){
		for (HistoricaldataDTO historicaldataDTO : historicaldataDTOs) {
			String key=historicaldataDTO.getDate();
			String value=historicaldataDTO.getValue();
			if(null !=key && null!=map)
			{  
				Historical_data_Common_DTO common_DTO=map.get(key);
				
				if(null == common_DTO)
				{
					common_DTO=new Historical_data_Common_DTO(Ticker);
					common_DTO.setDate(key);
				}
				
				switch(getKey ) {
					case "volume":
						common_DTO.setVolume(value);
						break;
					case "close_price":
						common_DTO.setClose_price(value);
						break;
					
					case "beta":
						common_DTO.setBeta(value);
						break;
				}
				
				map.put(key, common_DTO);

			}
			
		}
		
		return map;
		
		
	}
	
	
	
	Map<String, Common_financial_data_DTO> setValuesInMapF(List<FinancialIncomeStatmentDTO> incomeStatment,Map<String,Common_financial_data_DTO>map, String getKey, String Ticker){

		for (FinancialIncomeStatmentDTO IncomeStatmentDTO1 : incomeStatment) {
			String key=IncomeStatmentDTO1.getTag();
			String value=IncomeStatmentDTO1.getValue();
			if(null !=key && null!=map)
			{  
				Common_financial_data_DTO common_finance_DTO=map.get(key);
				
				if(null == common_finance_DTO)
				{ 
					//common_finance_DTO.(key);
					common_finance_DTO=new Common_financial_data_DTO();
					
				}
							
					/*switch(getTag ) {
					
					case "close_price":
						common_finance_DTO.setValue(income_statement);
						break;
					case "volume":
						common_finance_DTO.setValue(BalanceSheet);
						break;
					
					case "beta":
						common_finance_DTO.setValue(Calculation);
						break;					
					
					}	*/
				map.put(key, common_finance_DTO);

			}
			
		}
		
		return map;
		
		
	}
	
	
	
	
	
	
	
	
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	
	
	
	
	
	
	///for financial
	
	@RequestMapping(value = "/common/financial", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getfinancialData() {
		try {
				String[] year = { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" };
				String[] period = { "Q1", "Q2", "Q3", "Q4", "FY" };

			int crrentPage = 0;
			int totalPage = 0;
			Common_financial_data_DTO common_finance_DTO=new Common_financial_data_DTO();
			Map<String, Common_financial_data_DTO> financialObjecTmap=new HashMap<>();

			HttpHeaders headers = new HttpHeaders();
			//set header 
			headers.add("Authorization", "Basic YTAwMzc2MjE1ODM4NWU5MzI2YWY1ZmQwYmM4MzRmNWY6ZTNlYjZlMzc1NGZjMGZkN2Q3ODMxYTViYmRiNTY3Zjk=");
			HttpEntity<String> request = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			
			

			for (int z = 0; z <= 7; z++) {
				String fiscalYear = year[z];
				common_finance_DTO.setFiscal_year(fiscalYear);

				for (int i = 0; i <= 4; i++) {
					common_finance_DTO.setFiscal_period(period[i]);

					String fiscalQuarter = "fiscal_period=" + period[i];

			//for close price 
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
			//common_finance_DTO.setStatement("StandardIncomeStatment");
			common_finance_DTO.setTicker("EOG");
			List<FinancialIncomeStatmentDTO> IncomeStatment = data.getData();
			
			for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment) {
				
				String tagName=financialIncomeStatmentDTO.getTag();
				String tag=financialIncomeStatmentDTO.getValue();
				
				switch(tagName) {
				
				case "operatingrevenue":{common_finance_DTO.setOperatingrevenue(tag);break;}
				case "otherrevenue":{common_finance_DTO.setOtherrevenue(tag);break;}
			    case "totalrevenue":{common_finance_DTO.setTotalrevenue(tag);break;}
				case "operatingcostofrevenue":{common_finance_DTO.setOperatingcostofrevenue(tag);break;}
				case "othercostofrevenue":{common_finance_DTO.setOthercostofrevenue(tag);break;}
				case "totalcostofrevenue":{common_finance_DTO.setTotalcostofrevenue(tag);break;}
				case "totalgrossprofit":{common_finance_DTO.setTotalgrossprofit(tag);break;}
				case "sgaexpense":{common_finance_DTO.setSgaexpense(tag);break;}
				case "marketingexpense":{common_finance_DTO.setMarketingexpense(tag);break;}
				case "explorationexpense":{common_finance_DTO.setExplorationexpense(tag);break;}
				case "depreciationexpense":{common_finance_DTO.setDepreciationexpense(tag);break;}
				case "impairmentexpense":{common_finance_DTO.setImpairmentexpense(tag);break;}
				//case "otherspecialcharges":{financialIncomedto.setOtherspecialcharges(tag); break;}
				case "totaloperatingexpenses":{common_finance_DTO.setTotaloperatingexpenses(tag);break;}
				case "totaloperatingincome":{common_finance_DTO.setTotaloperatingincome(tag);break;}
				case "totalinterestexpense":{common_finance_DTO.setTotalinterestexpense(tag);break;}
				case "otherincome":{common_finance_DTO.setOtherincome(tag);break;}
				case "totalotherincome":{common_finance_DTO.setTotalotherincome(tag);break;}
				case "totalpretaxincome":{common_finance_DTO.setTotalpretaxincome(tag);break;}
				case "incometaxexpense":{common_finance_DTO.setIncometaxexpense(tag);break;}
				case "netincomecontinuing":{common_finance_DTO.setNetincomecontinuing(tag);break;}
				case "netincome":{common_finance_DTO.setNetincome(tag);break;}
				case "netincometocommon":{common_finance_DTO.setNetincometocommon(tag);break;}
				case "weightedavebasicsharesos":{common_finance_DTO.setWeightedavebasicsharesos(tag);break;}
				case "basiceps":{common_finance_DTO.setBasiceps(tag);break;}
				case "weightedavedilutedsharesos":{common_finance_DTO.setWeightedavedilutedsharesos(tag);break;}
				case "dilutedeps":{common_finance_DTO.setDilutedeps(tag);break;}

				case "weightedavebasicdilutedsharesos":{common_finance_DTO.setWeightedavebasicdilutedsharesos(tag);break;}
				case "basicdilutedeps":{common_finance_DTO.setBasicdilutedeps(tag);break;}
				case "cashdividendspershare":{common_finance_DTO.setCashdividendspershare(tag);break;}
				}
			}
			
		
			
			ResponseEntity<StandardIncomeStatment> result1 = restTemplate.exchange(
					"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=calculations&fiscal_year="
							+ fiscalYear + "&" + fiscalQuarter,
					HttpMethod.GET, request, StandardIncomeStatment.class);
			String tesrtUrl1 = "https://api.intrinio.com/financials/standardized?identifier=EOG&statement=calculations&fiscal_year="
					+ fiscalYear + "&" + fiscalQuarter;
			
			
			System.out.println(tesrtUrl1);
			StandardIncomeStatment data1 = result1.getBody();
			crrentPage = data1.getCurrent_page();
			totalPage = data1.getTotal_pages();
			List<FinancialIncomeStatmentDTO> IncomeStatment1 = data1.getData();
			
			
			for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment1) {
				
				String tagName=financialIncomeStatmentDTO.getTag();
				String tag=financialIncomeStatmentDTO.getValue();	
				
									
					switch(tagName) {
				
				//need to define all case for all instance parameter
					
					case "revenuegrowth":{common_finance_DTO.setRevenuegrowth(tag);break;}
					case "nopat":{common_finance_DTO.setNopat(tag);break;}
					case "nopatmargin":{common_finance_DTO.setNopatmargin(tag);break;}
					case "investedcapital":{common_finance_DTO.setInvestedcapital(tag);break;}
					case "investedcapitalturnover":{common_finance_DTO.setInvestedcapitalturnover(tag);break;}
					case "investedcapitalincreasedecrease":{common_finance_DTO.setInvestedcapitalincreasedecrease(tag);break;}
					case "freecashflow":{common_finance_DTO.setFreecashflow(tag);break;}
					case "netnonopex":{common_finance_DTO.setNetnonopex(tag);break;}
					case "netnonopobligations":{common_finance_DTO.setNetnonopobligations(tag);break;}
					case "ebit":{common_finance_DTO.setEbit(tag);break;}
					case "depreciationandamortization":{common_finance_DTO.setDepreciationandamortization(tag);break;}
					case "ebitda":{common_finance_DTO.setEbitda(tag);break;}
					case "capex":{common_finance_DTO.setCapex(tag);break;}
					case "dfcfnwc":{common_finance_DTO.setDfcfnwc(tag);break;}
					case "dfnwc":{common_finance_DTO.setDfnwc(tag);break;}
					case "nwc":{common_finance_DTO.setNwc(tag);break;}
					case "debt":{common_finance_DTO.setDebt(tag);break;}
					case "ltdebtandcapleases":{common_finance_DTO.setLtdebtandcapleases(tag);break;}
					case "netdebt":{common_finance_DTO.setNetdebt(tag);break;}
					case "totalcapital":{common_finance_DTO.setTotalcapital(tag);break;}
					case "bookvaluepershare":{common_finance_DTO.setBookvaluepershare(tag);break;}
					case "tangbookvaluepershare":{common_finance_DTO.setTangbookvaluepershare(tag);break;}
					case "marketcap":{common_finance_DTO.setMarketcap(tag);break;}
					case "enterprisevalue":{common_finance_DTO.setEnterprisevalue(tag);break;}
					case "pricetobook":{common_finance_DTO.setPricetobook(tag);break;}
					case "pricetotangiblebook":{common_finance_DTO.setPricetotangiblebook(tag);break;}
					case "pricetorevenue":{common_finance_DTO.setPricetorevenue(tag);break;}
					case "pricetoearnings":{common_finance_DTO.setPricetoearnings(tag);break;}
					case "dividendyield":{common_finance_DTO.setDividendyield(tag);break;}
					case "earningsyield":{common_finance_DTO.setEarningsyield(tag);break;}
					case "evtoinvestedcapital":{common_finance_DTO.setEvtoinvestedcapital(tag);break;}
					case "evtorevenue":{common_finance_DTO.setEvtorevenue(tag);break;}
					case "evtoebitda":{common_finance_DTO.setEvtoebitda(tag);break;}
					case "evtoebit":{common_finance_DTO.setEvtoebit(tag);break;}
					case "evtonopat":{common_finance_DTO.setEvtonopat(tag);break;}
					case "evtoocf":{common_finance_DTO.setEvtoocf(tag);break;}
					case "evtofcff":{common_finance_DTO.setEvtofcff(tag);break;}
					case "ebitdagrowth":{common_finance_DTO.setEbitdagrowth(tag);break;}
					case "ebitgrowth":{common_finance_DTO.setEbitgrowth(tag);break;}
					case "nopatgrowth":{common_finance_DTO.setNopatgrowth(tag);break;}
					case "netincomegrowth":{common_finance_DTO.setNetincomegrowth(tag);break;}
					case "epsgrowth":{common_finance_DTO.setEpsgrowth(tag);break;}
					case "ocfgrowth":{common_finance_DTO.setOcfgrowth(tag);break;}
					case "fcffgrowth":{common_finance_DTO.setFcffgrowth(tag);break;}
					case "investedcapitalgrowth":{common_finance_DTO.setInvestedcapitalgrowth(tag);break;}
					case "revenueqoqgrowth":{common_finance_DTO.setRevenueqoqgrowth(tag);break;}
					case "ebitdaqoqgrowth":{common_finance_DTO.setEbitdaqoqgrowth(tag);break;}
					case "ebitqoqgrowth":{common_finance_DTO.setEbitqoqgrowth(tag);break;}
					case "nopatqoqgrowth":{common_finance_DTO.setNopatqoqgrowth(tag);break;}
					case "netincomeqoqgrowth":{common_finance_DTO.setNetincomeqoqgrowth(tag);break;}
					case "epsqoqgrowth":{common_finance_DTO.setEpsqoqgrowth(tag);break;}
					case "ocfqoqgrowth":{common_finance_DTO.setOcfqoqgrowth(tag);break;}
					case "fcffqoqgrowth":{common_finance_DTO.setFcffqoqgrowth(tag);break;}
					case "investedcapitalqoqgrowth":{common_finance_DTO.setInvestedcapitalqoqgrowth(tag);break;}
					case "grossmargin":{common_finance_DTO.setGrossmargin(tag);break;}
					case "ebitdamargin":{common_finance_DTO.setEbitdamargin(tag);break;}
					case "operatingmargin":{common_finance_DTO.setOperatingmargin(tag);break;}
					case "ebitmargin":{common_finance_DTO.setEbitmargin(tag);break;}
					case "profitmargin":{common_finance_DTO.setProfitmargin(tag);break;}
					case "costofrevtorevenue":{common_finance_DTO.setCostofrevtorevenue(tag);break;}
					case "sgaextorevenue":{common_finance_DTO.setSgaextorevenue(tag);break;}
					case "rdextorevenue":{common_finance_DTO.setRdextorevenue(tag);break;}
					case "opextorevenue":{common_finance_DTO.setOpextorevenue(tag);break;}
					case "taxburdenpct":{common_finance_DTO.setTaxburdenpct(tag);break;}
					case "interestburdenpct":{common_finance_DTO.setInterestburdenpct(tag);break;}
					case "efftaxrate":{common_finance_DTO.setEfftaxrate(tag);break;}
					case "assetturnover":{common_finance_DTO.setAssetturnover(tag);break;}
					case "arturnover":{common_finance_DTO.setArturnover(tag);break;}
					case "invturnover":{common_finance_DTO.setInvturnover(tag);break;}
					case "faturnover":{common_finance_DTO.setFaturnover(tag);break;}
					case "apturnover":{common_finance_DTO.setApturnover(tag);break;}
					case "dso":{common_finance_DTO.setDso(tag);break;}
					case "dio":{common_finance_DTO.setDio(tag);break;}
					case "dpo":{common_finance_DTO.setDpo(tag);break;}
					case "ccc":{common_finance_DTO.setCcc(tag);break;}
					case "finleverage":{common_finance_DTO.setFinleverage(tag);break;}
					case "leverageratio":{common_finance_DTO.setLeverageratio(tag);break;}
					case "compoundleveragefactor":{common_finance_DTO.setCompoundleveragefactor(tag);break;}
					case "ltdebttoequity":{common_finance_DTO.setLtdebttoequity(tag);break;}
					case "debttoequity":{common_finance_DTO.setDebttoequity(tag);break;}
					case "roic":{common_finance_DTO.setRoic(tag);break;}
					case "nnep":{common_finance_DTO.setNnep(tag);break;}
					case "roicnnepspread":{common_finance_DTO.setRoicnnepspread(tag);break;}
					case "rnnoa":{common_finance_DTO.setRnnoa(tag);break;}
					case "roe":{common_finance_DTO.setRoe(tag);break;}
					case "croic":{common_finance_DTO.setCroic(tag);break;}
					case "oroa":{common_finance_DTO.setOroa(tag);break;}
					case "roa":{common_finance_DTO.setRoa(tag);break;}
					case "noncontrollinginterestsharingratio":{common_finance_DTO.setNoncontrollinginterestsharingratio(tag);break;}
					case "roce":{common_finance_DTO.setRoce(tag);break;}
					case "divpayoutratio":{common_finance_DTO.setDivpayoutratio(tag);break;}
					case "augmentedpayoutratio":{common_finance_DTO.setAugmentedpayoutratio(tag);break;}
					case "ocftocapex":{common_finance_DTO.setOcftocapex(tag);break;}
					case "stdebttocap":{common_finance_DTO.setStdebttocap(tag);break;}
					case "ltdebttocap":{common_finance_DTO.setLtdebttocap(tag);break;}
					case "debttototalcapital":{common_finance_DTO.setDebttototalcapital(tag);break;}
					case "preferredtocap":{common_finance_DTO.setPreferredtocap(tag);break;}
					case "noncontrolinttocap":{common_finance_DTO.setNoncontrolinttocap(tag);break;}
					case "commontocap":{common_finance_DTO.setCommontocap(tag);break;}
					case "debttoebitda":{common_finance_DTO.setDebttoebitda(tag);break;}						     	
			     									
					
						
				}
			}
				
			
			
			
			
		
			
		
		
			
					ResponseEntity<StandardIncomeStatment> result2 = restTemplate.exchange(
							"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=cash_flow_statement&fiscal_year="
									+ fiscalYear + "&" + fiscalQuarter,
							HttpMethod.GET, request, StandardIncomeStatment.class);
					String tesrtUrl2 = "https://api.intrinio.com/financials/standardized?identifier=EOG&statement=cash_flow_statement&fiscal_year="
							+ fiscalYear + "&" + fiscalQuarter;
					System.out.println(tesrtUrl2);
					StandardIncomeStatment data2 = result2.getBody();
					crrentPage = data2.getCurrent_page();
					totalPage = data2.getTotal_pages();
					List<FinancialIncomeStatmentDTO> IncomeStatment2 = data2.getData();
					//delegate.saveFinancialIncomeData(IncomeStatment);
					for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment2) {
						
						String tagName=financialIncomeStatmentDTO.getTag();
						String tag=financialIncomeStatmentDTO.getValue();	
						
						
						
						
						
							switch(tagName) {
						
					
						
						
						
						case "netincome":{common_finance_DTO.setNetincome(tag);break;}
						case "netincomecontinuing":{common_finance_DTO.setNetincomecontinuing(tag);break;}
						case "depreciationexpense":{common_finance_DTO.setDepreciationexpense(tag);break;}
						case "noncashadjustmentstonetincome":{common_finance_DTO.setNoncashadjustmentstonetincome(tag);break;}
						case "increasedecreaseinoperatingcapital":{common_finance_DTO.setIncreasedecreaseinoperatingcapital(tag);break;}
						case "netcashfromcontinuingoperatingactivities":{common_finance_DTO.setNetcashfromcontinuingoperatingactivities(tag);break;}
						case "netcashfromoperatingactivities":{common_finance_DTO.setNetcashfromoperatingactivities(tag);break;}
						case "purchaseofplantpropertyandequipment":{common_finance_DTO.setPurchaseofplantpropertyandequipment(tag);break;}
						case "acquisitions":{common_finance_DTO.setAcquisitions(tag);break;}
						case "divestitures":{common_finance_DTO.setDivestitures(tag);break;}
						case "otherinvestingactivitiesnet":{common_finance_DTO.setOtherinvestingactivitiesnet(tag);break;}
						case "netcashfromcontinuinginvestingactivities":{common_finance_DTO.setNetcashfromcontinuinginvestingactivities(tag);break;}
						case "netcashfrominvestingactivities":{common_finance_DTO.setNetcashfrominvestingactivities(tag);break;}
						case "repaymentofdebt":{common_finance_DTO.setRepaymentofdebt(tag);break;}
						case "repurchaseofcommonequity":{common_finance_DTO.setRepurchaseofcommonequity(tag);break;}
						case "paymentofdividends":{common_finance_DTO.setPaymentofdividends(tag);break;}
						case "issuanceofdebt":{common_finance_DTO.setIssuanceofdebt(tag);break;}
						case "issuanceofcommonequity":{common_finance_DTO.setIssuanceofcommonequity(tag);break;}
						case "otherfinancingactivitiesnet":{common_finance_DTO.setOtherfinancingactivitiesnet(tag);break;}
						case "netcashfromcontinuingfinancingactivities":{common_finance_DTO.setNetcashfromcontinuingfinancingactivities(tag);break;}
						case "netcashfromfinancingactivities":{common_finance_DTO.setNetcashfromfinancingactivities(tag);break;}
						case "netchangeincash":{common_finance_DTO.setNetchangeincash(tag);break;}
					
											
						//need to define all case for all instance parameter
						
						
						}
						
					}
					
					
					
					ResponseEntity<StandardIncomeStatment> result3 = restTemplate.exchange(
							"https://api.intrinio.com/financials/standardized?identifier=EOG&statement=balance_sheet&fiscal_year="
									+ fiscalYear + "&" + fiscalQuarter,
							HttpMethod.GET, request, StandardIncomeStatment.class);

					String tesrtUrl3 = "https://api.intrinio.com/financials/standardized?identifier=EOG&statement=balance_sheet&fiscal_year="
							+ fiscalYear + "&" + fiscalQuarter;
					System.out.println(tesrtUrl3);
					StandardIncomeStatment data3 = result3.getBody();
					crrentPage = data3.getCurrent_page();
					totalPage = data3.getTotal_pages();
					List<FinancialIncomeStatmentDTO> IncomeStatment3 = data3.getData();
					
					for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : IncomeStatment3) {
						
					
						String tagName=financialIncomeStatmentDTO.getTag();
						String tag=financialIncomeStatmentDTO.getValue();				
							switch(tagName) {
							
							//need to define all case for all instance parameter
							
							
							case "cashandequivalents":{common_finance_DTO.setCashandequivalents(tag);break;}
							case "accountsreceivable":{common_finance_DTO.setAccountsreceivable(tag);break;}
							case "netinventory":{common_finance_DTO.setNetinventory(tag);break;}
							case "othercurrentassets":{common_finance_DTO.setOthercurrentassets(tag);break;}
							case "totalcurrentassets":{common_finance_DTO.setTotalcurrentassets(tag);break;}
							case "grossppe":{common_finance_DTO.setGrossppe(tag);break;}
							case "accumulateddepreciation":{common_finance_DTO.setAccumulateddepreciation(tag);break;}
							case "netppe":{common_finance_DTO.setNetppe(tag);break;}
							case "othernoncurrentassets":{common_finance_DTO.setOthernoncurrentassets(tag);break;}
							case "totalnoncurrentassets":{common_finance_DTO.setTotalnoncurrentassets(tag);break;}
							case "totalassets":{common_finance_DTO.setTotalassets(tag);break;}
							case "shorttermdebt":{common_finance_DTO.setShorttermdebt(tag);break;}
							case "accountspayable":{common_finance_DTO.setAccountspayable(tag);break;}
							case "othercurrentliabilities":{common_finance_DTO.setOthercurrentliabilities(tag);break;}
							case "totalcurrentliabilities":{common_finance_DTO.setTotalcurrentliabilities(tag);break;}
							case "longtermdebt":{common_finance_DTO.setLongtermdebt(tag);break;}
							case "othernoncurrentliabilities":{common_finance_DTO.setOthernoncurrentliabilities(tag);break;}
							case "totalnoncurrentliabilities":{common_finance_DTO.setTotalnoncurrentliabilities(tag);break;}
							case "totalliabilities":{common_finance_DTO.setTotalliabilities(tag);break;}
							case "commitmentsandcontingencies":{common_finance_DTO.setCommitmentsandcontingencies(tag);break;}
							case "commonequity":{common_finance_DTO.setCommonequity(tag);break;}
							case "retainedearnings":{common_finance_DTO.setRetainedearnings(tag);break;}
							case "treasurystock":{common_finance_DTO.setTreasurystock(tag);break;}
							case "aoci":{common_finance_DTO.setAoci(tag);break;}
							case "totalcommonequity":{common_finance_DTO.setTotalcommonequity(tag);break;}
							case "totalequity":{common_finance_DTO.setTotalequity(tag);break;}
							case "totalequityandnoncontrollinginterests":{common_finance_DTO.setTotalequityandnoncontrollinginterests(tag);break;}
							case "totalliabilitiesandequity":{common_finance_DTO.setTotalliabilitiesandequity(tag);break;}
							case "currentdeferredtaxassets":{common_finance_DTO.setCurrentdeferredtaxassets(tag);break;}
							case "noncurrentdeferredtaxassets":{common_finance_DTO.setNoncurrentdeferredtaxassets(tag);break;}
							case "dividendspayable":{common_finance_DTO.setDividendspayable(tag);break;}
							case "currentdeferredtaxliabilities":{common_finance_DTO.setCurrentdeferredtaxliabilities(tag);break;}
							case "noncurrentdeferredtaxliabilities":{common_finance_DTO.setNoncurrentdeferredtaxliabilities(tag);break;}
										
							}
							
						}
					
					 delegate.saveFinancialCommonData(common_finance_DTO);
					
				}
			}
		

			
		
			// System.out.println(data);
			printMap(financialObjecTmap);
			// delegate.saveFinancialIncomeData(factIngredientDTOs);
			return "save done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
	
// Common daily Script news	
	@RequestMapping(value = "/common/dailyscript/news", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getdailyscriptNews() {
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
	
	
	
	// common institutional ownership
		@RequestMapping(value = "/common/biweeklyscript/instuitional/ownership", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String getBiWeeklyInstuitional() {
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
						"https://api.intrinio.com/securities/institutional_ownership?identifier=EOG", HttpMethod.GET,
						request, StandardInstuitionalOwnershipDTO.class);
				StandardInstuitionalOwnershipDTO data = result.getBody();
				crrentPage = data.getCurrent_page();
				totalPage = data.getTotal_pages();
				List<IntiutionalOwnershipDTO> factIngredientDTOs = data.getData();
				for (IntiutionalOwnershipDTO indata: factIngredientDTOs) {
					indata.setTicker("EOG");
				}
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
					for (IntiutionalOwnershipDTO indata: IncomeStatments) {
						indata.setTicker("EOG");
					}
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
		@RequestMapping(value = "/common/biweeklyscript/quaterly/script/companies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
				List<Common_CompDTO> companiesData = data.getData();
				for (Common_CompDTO cdata: companiesData) {
					cdata.setTicker("EOG");
				}
				delegate.saveQuaterlyComapniesData(companiesData);

				if ((crrentPage != totalPage) && (totalPage > 1)) {
					crrentPage += 1;
					String urlAttr = ("page_index=" + crrentPage);
					ResponseEntity<HistoricaldataDTO> results = restTemplate.exchange(
							"https://api.intrinio.com/companies/filings?identifier=EOG", HttpMethod.GET, request,
							HistoricaldataDTO.class);
					data = result.getBody();
					crrentPage = data.getCurrent_page();
					List<Common_CompDTO> compnaie = data.getData();
					for (Common_CompDTO cdata: compnaie) {
						cdata.setTicker("EOG");
					}
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
		
		
		
		
		
		
		// bi weekly script short interest
		@RequestMapping(value = "/common/biweeklyscript/shortinterest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String getBiWeeklyShortInterest() {
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
						"https://api.intrinio.com/historical_data?identifier=EOG&item=short_interest", HttpMethod.GET,
						request, StandardHistoricalData.class);
				StandardHistoricalData data = result.getBody();
				crrentPage = data.getCurrent_page();
				totalPage = data.getTotal_pages();
				List<HistoricaldataDTO> factIngredientDTOs = data.getData();
				for (HistoricaldataDTO shortdata: factIngredientDTOs) {
					shortdata.setTicker("EOG");
				}
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
					for (HistoricaldataDTO shortdata: IncomeStatments) {
						shortdata.setTicker("EOG");
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

		}



}
