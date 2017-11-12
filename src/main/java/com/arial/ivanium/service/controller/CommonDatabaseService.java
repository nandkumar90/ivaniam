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
public class CommonDatabaseService {

	
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
			histomryObjecTmap=setValuesInMap(volume,histomryObjecTmap, "close_price" ,"EOG");


			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_number=" + crrentPage);
				ResponseEntity<StandardHistoricalData> resultss = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=volume"+urlAttr, HttpMethod.GET, request,
						StandardHistoricalData.class);
				StandardHistoricalData dataVolumes = resultVOlume.getBody();

				crrentPage = dataVolumes.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = dataVolumes.getData();
				histomryObjecTmap=setValuesInMap(IncomeStatments,histomryObjecTmap, "close_price" ,"EOG");

			}
			
			//for beta 
			ResponseEntity<StandardHistoricalData> resultBeta = restTemplate.exchange(
					"https://api.intrinio.com/historical_data?identifier=EOG&item=beta", HttpMethod.GET, request,
					StandardHistoricalData.class);
			StandardHistoricalData datas = resultBeta.getBody();
			crrentPage = datas.getCurrent_page();
			totalPage = datas.getTotal_pages();
			List<HistoricaldataDTO> beta = datas.getData();
			histomryObjecTmap=setValuesInMap(beta,histomryObjecTmap, "close_price" ,"EOG");

			if ((crrentPage != totalPage) && (totalPage > 1)) {
				crrentPage += 1;
				String urlAttr = ("page_number=" + crrentPage);
				ResponseEntity<StandardHistoricalData> results = restTemplate.exchange(
						"https://api.intrinio.com/historical_data?identifier=EOG&item=beta"+urlAttr, HttpMethod.GET, request,
						StandardHistoricalData.class);
				StandardHistoricalData dataClosedPrice = results.getBody();
				crrentPage = dataClosedPrice.getCurrent_page();
				List<HistoricaldataDTO> IncomeStatments = dataClosedPrice.getData();
				histomryObjecTmap=setValuesInMap(IncomeStatments,histomryObjecTmap, "close_price" ,"EOG");

			}
			
			
			// System.out.println(data);
			printMap(histomryObjecTmap);
			// delegate.saveFinancialIncomeData(factIngredientDTOs);
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
					
					case "close_price":
						common_DTO.setVolume(value);
						break;
					case "volume":
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
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}

	

}
