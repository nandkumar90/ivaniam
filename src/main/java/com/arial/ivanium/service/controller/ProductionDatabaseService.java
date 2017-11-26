package com.arial.ivanium.service.controller;


import com.arial.ivanium.delegate.DatabaseDelegate;
import com.arial.ivanium.dto.Common_financial_data_DTO;
import com.arial.ivanium.dto.CoverSummary;
import com.arial.ivanium.dto.Historical_data_Common_DTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.StandardHistoricalData;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
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


@Controller
public class ProductionDatabaseService {
	
	@Autowired
	private DatabaseDelegate delegate;

	
	
	private SecureRandom random = new SecureRandom();

	public String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}

	@SuppressWarnings("deprecation")
	private String getCurrentQuarter() {
		String quarter = "Q1";
		Date date = new Date();
		switch (date.getMonth()) {
		case 1:
		case 2:
		case 3:
			quarter = "Q1";
			break;
		case 4:
		case 5:
		case 6:
			quarter = "Q2";
			break;
		case 7:
		case 8:
		case 9:
			quarter = "Q3";
			break;
		case 10:
		case 11:
		case 12:
			quarter = "Q4";
			break;
		}
		return quarter;
	}
	
	public Historical_data_Common_DTO getLastHistData(String ticker) {
		// Fetch latest hist data for ticker
		return null;
	}
	
	// Return Financial data for quarter (Q1/Q2/Q3/Q4/FY) and year
	public Common_financial_data_DTO getFinancialData(String ticker, String quarter, int year) {
		
		return null;
	}
	

	// bi weekly script short interest
	@RequestMapping(value = "/prod/coverSummary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCoverSummary() {
		String ticker = "EOG";
		try {
			Historical_data_Common_DTO histData = getLastHistData(ticker);
			float close_price = Float.parseFloat(histData.getClose_price());
			
			Common_financial_data_DTO financial_data = getFinancialData(ticker, getCurrentQuarter(), 2017);
			
			CoverSummary coverSummary = new CoverSummary();
			coverSummary.setTicker(ticker);
			coverSummary.setYear(2017);
			coverSummary.setDiluted_Shares_out(financial_data.getWeightedavedilutedsharesos());
			coverSummary.setBasic_Shares_out(financial_data.getWeightedavebasicsharesos());
			coverSummary.setMarket_Cap(coverSummary.getBasic_Shares_out() * close_price);
			coverSummary.setTotal_debt(financial_data.getShorttermdebt() + financial_data.getLongtermdebt());
			coverSummary.setCash(financial_data.getCashandequivalents());
			coverSummary.setNetDebt(coverSummary.getTotal_debt() - coverSummary.getCash());
			coverSummary.setMinority_Interest(0);
			coverSummary.setEnterprises_Value(coverSummary.getMarket_Cap() + coverSummary.getNetDebt() + coverSummary.getMinority_Interest());
			coverSummary.setShare_Price(close_price);
			coverSummary.setPrice_Target_PE(price_Target_PE);
			coverSummary.setPrice_Target_PCF(price_Target_PCF);
			coverSummary.setPrice_Target_EVEBITDA(price_Target_EVEBITDA);
			coverSummary.setPrice_Target_3PNAV(price_Target_3PNAV);
			coverSummary.setOfficial_Price_Target_average((coverSummary.getPrice_Target_PE() + coverSummary.getPrice_Target_PCF() + coverSummary.getPrice_Target_EVEBITDA() + coverSummary.getPrice_Target_3PNAV()) / 4);
			coverSummary.setPotentialAppreciation((coverSummary.getOfficial_Price_Target_average() / close_price) - 1);
			coverSummary.setModel_View("");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


}
