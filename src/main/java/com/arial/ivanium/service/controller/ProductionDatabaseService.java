package com.arial.ivanium.service.controller;

import com.arial.ivanium.delegate.DatabaseDelegate;
import com.arial.ivanium.dto.Common_financial_data_DTO;
import com.arial.ivanium.dto.CoverDetailDTO;
import com.arial.ivanium.dto.CoverSummary;
import com.arial.ivanium.dto.EVEBITDA;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.Historical_data_Common_DTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.PBDTO;
import com.arial.ivanium.dto.PCFDTO;
import com.arial.ivanium.dto.PEDTO;
import com.arial.ivanium.dto.StandardHistoricalData;
import com.arial.ivanium.dto.XesUsEquity;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	@RequestMapping(value = "/prod/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getFacts() {
	
		return "test";
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
		// hidtorical data
		return null;
	}

	// Return Financial data for quarter (Q1/Q2/Q3/Q4/FY) and year
	public Common_financial_data_DTO getFinancialData(String ticker, String quarter, int year) {
		// fetch data
		return null;
	}
	

	public double convertStringToDouble(String value) {
		return Double.parseDouble(value);
	}


	@RequestMapping(value = "/prod/coverSummary/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCoverSummary(@PathVariable("ticker") String  ticker) {
		try {
			List<Historical_data_Common_DTO> histDataList = delegate.getFinancialCommonData(ticker);
			Historical_data_Common_DTO histData = histDataList.get(0);
			float close_price = Float.parseFloat(histData.getClose_price());
			List<Common_financial_data_DTO> financial_dataList = delegate.getFinancialCommonData(ticker,
					getCurrentQuarter(), 2017);
			Common_financial_data_DTO financial_data = financial_dataList.get(0);

			CoverSummary coverSummary = new CoverSummary();
			coverSummary.setTicker(ticker);
			coverSummary.setYear(2017);
			coverSummary.setDiluted_Shares_out(convertStringToDouble(financial_data.getWeightedavedilutedsharesos()));
			coverSummary.setBasic_Shares_out(convertStringToDouble(financial_data.getWeightedavebasicsharesos()));
			coverSummary.setMarket_Cap(coverSummary.getBasic_Shares_out() * close_price);
			coverSummary.setTotal_debt(convertStringToDouble(financial_data.getShorttermdebt() + financial_data.getLongtermdebt()));
			coverSummary.setCash(convertStringToDouble(financial_data.getCashandequivalents()));
			coverSummary.setNetDebt(coverSummary.getTotal_debt() - coverSummary.getCash());
			coverSummary.setMinority_Interest(0);
			coverSummary.setEnterprises_Value(
					coverSummary.getMarket_Cap() + coverSummary.getNetDebt() + coverSummary.getMinority_Interest());
			coverSummary.setShare_Price(close_price);
			/*coverSummary.setPrice_Target_PE(convertStringToDouble(price_Target_PE));
			coverSummary.setPrice_Target_PCF(convertStringToDouble(price_Target_PCF));
			coverSummary.setPrice_Target_EVEBITDA(price_Target_EVEBITDA);
			coverSummary.setPrice_Target_3PNAV(price_Target_3PNAV);*/
			coverSummary.setOfficial_Price_Target_average(
					(coverSummary.getPrice_Target_PE() + coverSummary.getPrice_Target_PCF()
							+ coverSummary.getPrice_Target_EVEBITDA() + coverSummary.getPrice_Target_3PNAV()) / 4);
			coverSummary.setPotentialAppreciation((coverSummary.getOfficial_Price_Target_average() / close_price) - 1);
			coverSummary.setModel_View("N/A");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/prod/coverDetail/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCoverDetail(@PathVariable("ticker") String  ticker) {
		try {
			
			for (int year = 2008; year < 2018; year++) {
				List<Historical_data_Common_DTO> histDataList = delegate.getFinancialCommonData(ticker);
				
				// TODO: Get last closing price of the year
				Historical_data_Common_DTO histData = histDataList.get(0);
				double close_price = Double.parseDouble(histData.getClose_price());
				double beta = Double.parseDouble(histData.getBeta());
				String date ="17";
				List<HistoricaldataDTO> shortDataList = delegate.getYearlyLatestData(date, ticker); //= delegate.getFinancialCommonData(ticker);
				
				// TODO: Get last entry of the year
				HistoricaldataDTO shortData = shortDataList.get(0);				
				double short_interest = Double.parseDouble(shortData.getValue());
				
				List<Common_financial_data_DTO> financial_dataList = delegate.getFinancialCommonData(ticker,
						"FY", year);
				Common_financial_data_DTO financial_data = financial_dataList.get(0);

				// TODO: Get cover summary
				CoverSummary coverSummary = null;

				CoverDetailDTO coverDetail = new CoverDetailDTO();
				
				coverDetail.setTicker(ticker);
				coverDetail.setYear(year);
				coverDetail.setEPS(convertStringToDouble(financial_data.getDilutedeps()));
				coverDetail.setCFPS(convertStringToDouble(financial_data.getNetcashfromoperatingactivities()) / coverDetail.getEPS());
				coverDetail.setEBITDA(convertStringToDouble(financial_data.getEbitda()));
				coverDetail.setPE(close_price / coverDetail.getEPS());
				coverDetail.setPCFPS(close_price / coverDetail.getCFPS());
				
				coverDetail.setEV_EBITDA(coverSummary.getEnterprises_Value() / coverDetail.getEBITDA());
				//coverDetail.setProduction_MBOED(null);
				
				// TODO: Get coverDetail of previous year
				//coverDetail.setProduction_Growth_PER(coverDetail.getProduction_MBOED / D);
				//coverDetail.setConsensus_EPS(close_price / coverDetail.getCFPS());
				//coverDetail.setBeat_Miss_vs_Con(coverDetail.getEPS() / coverDetail.getConsensus_EPS());
				//coverDetail.setModel_EPS_CAGR(close_price / coverDetail.getCFPS());
				
				coverDetail.setFCF(convertStringToDouble(financial_data.getFreecashflow()));
				coverDetail.setFCF_per_share(coverDetail.getFCF()/convertStringToDouble(financial_data.getWeightedavedilutedsharesos()));
				coverDetail.setFCF_Yield(coverDetail.getFCF_per_share()/close_price );
				coverDetail.setDebt_to_Capital(convertStringToDouble(financial_data.getDebttototalcapital()));
				coverDetail.setCashshare(convertStringToDouble(financial_data.getCashandequivalents())/convertStringToDouble(financial_data.getWeightedavedilutedsharesos()));
				coverDetail.setBVshare(convertStringToDouble(financial_data.getBookvaluepershare()));
				coverDetail.setPBook(close_price / coverDetail.getBVshare());
				coverDetail.setDiv_Yield(convertStringToDouble(financial_data.getDividendyield()));
				coverDetail.setBeta_to_SPX(beta);
				
				//coverDetail.setBeta_to_XLE(null);
				
				coverDetail.setShares_Short_MM(convertStringToDouble(shortData.getValue()));
				coverDetail.setShort_Interest_Per_Float(coverDetail.getShares_Short_MM()/convertStringToDouble(financial_data.getWeightedavedilutedsharesos()));
				
				//coverDetail.setP(null);
				//coverDetail.setWACC(null));
				
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
	
	
	@RequestMapping(value = "/prod/XesUsEquity/{ticker}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getXesUsEquity(@PathVariable("ticker") String  ticker) {
		try {
			
			for (int year = 2008; year < 2018; year++) {
				String date="17";
				int week =10;
				List<Historical_data_Common_DTO> histDataList = delegate.getWeeklyLatestData(date, ticker, week);
				
				List<Common_financial_data_DTO> financial_dataList = delegate.getFinancialCommonData(ticker,
						"FY", year);
				Common_financial_data_DTO financial_data = financial_dataList.get(0);

				
				// Need to run weekly
				Calendar cal = Calendar.getInstance();
				cal.set(year, 1, 1);
				
				Calendar cal_now = Calendar.getInstance();
				
				// For previous years, the last date should be 31, Dec
				if (year < cal_now.get(Calendar.YEAR)) {
					cal_now.set(Calendar.YEAR, year+1);
					cal_now.add(Calendar.DAY_OF_MONTH, -1);
				}
				
				//System.out.println(cal_now.get(Calendar.YEAR) + "/" + cal_now.get(Calendar.MONTH) + "/" +  cal_now.get(Calendar.DAY_OF_MONTH));
				
				// Avgs:
				double M_FWD_EPS = 0;
				double M_FWD_CFPS = 0;
				double M_fwd_EBITDA = 0;
				double M_fwd_BVPS = 0;
				int count = 0;
				
				List<XesUsEquity> XesUsEquityList = new ArrayList<XesUsEquity>();
				
				while (cal.compareTo(cal_now) < 0 ) {
					count++;
					
					//int year = cal.get(Calendar.YEAR);
					//int month = cal.get(Calendar.MONTH);      // 0 to 11
					//int day = cal.get(Calendar.DAY_OF_MONTH);
					//System.out.println(year + "/" + month + "/" + day);
					
					// TODO: Get last closing price of the week ending date
					Historical_data_Common_DTO histData = histDataList.get(0);
					double close_price = Double.parseDouble(histData.getClose_price());
										
					XesUsEquity xesUsEquity = new XesUsEquity();
					
					xesUsEquity.setTicker(ticker);
					xesUsEquity.setDate(new Date(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)));

					xesUsEquity.setPX_LAST(close_price);
					xesUsEquity.setEQY_Diluted_SH_OUT(convertStringToDouble(financial_data.getWeightedavedilutedsharesos()));
					xesUsEquity.setFY_EPS(convertStringToDouble(financial_data.getDilutedeps()));
					M_FWD_EPS += xesUsEquity.getFY_EPS();
					
					xesUsEquity.setFY_CFPS(convertStringToDouble(financial_data.getNetcashfromoperatingactivities())/xesUsEquity.getEQY_Diluted_SH_OUT());
					M_FWD_CFPS += xesUsEquity.getFY_CFPS();
					
					//xesUsEquity.setFY_EV(convertStringToDouble(financial_data.getDilutedeps()));
					
					xesUsEquity.setFY_EBITDA(convertStringToDouble(financial_data.getEbitda()));
					M_fwd_EBITDA += xesUsEquity.getFY_EBITDA();
					
					xesUsEquity.setFY_BVPS(convertStringToDouble(financial_data.getBookvaluepershare()));
					M_fwd_BVPS += xesUsEquity.getFY_BVPS();
					
					XesUsEquityList.add(xesUsEquity);
					
					cal.add(Calendar.DAY_OF_MONTH, 7);
				}
				
				List<PEDTO> PEDTO_List = new ArrayList<PEDTO>();
				List<PCFDTO> PCFDTO_List = new ArrayList<PCFDTO>();
				List<EVEBITDA> EVEBITDA_List = new ArrayList<EVEBITDA>();
				List<PBDTO> PBDTO_List = new ArrayList<PBDTO>();
				
				double PEDTO_avg = 0;
				double PCFDTO_avg = 0;
				double EVEBITDA_avg = 0;
				double PBDTO_avg = 0;
				
				for (XesUsEquity xesUsEquity : XesUsEquityList) {
					xesUsEquity.setM_FWD_EPS(M_FWD_EPS/count);
					xesUsEquity.setM_FWD_CFPS(M_FWD_CFPS/count);
					xesUsEquity.setM_fwd_EBITDA(M_fwd_EBITDA/count);
					xesUsEquity.setM_fwd_BVPS(M_fwd_BVPS/count);
					
					// PE
					PEDTO PEDTO = new PEDTO();
					PEDTO.setTicker(xesUsEquity.getTicker());
					PEDTO.setDate(xesUsEquity.getDate());
					PEDTO.setActualePE(xesUsEquity.getPX_LAST() / xesUsEquity.getM_FWD_EPS());
					
					// Avg & STD
					PEDTO_avg += PEDTO.getActualePE();
					
					PEDTO_List.add(PEDTO);
					
					// PCF
					PCFDTO PCFDTO = new PCFDTO();
					PCFDTO.setTicker(xesUsEquity.getTicker());
					PCFDTO.setDate(xesUsEquity.getDate());
					PCFDTO.setActualPCF(xesUsEquity.getPX_LAST() / xesUsEquity.getM_FWD_CFPS());
					
					// Avg & STD
					PCFDTO_avg += PCFDTO.getActualPCF();
					
					PCFDTO_List.add(PCFDTO);
					
					// EVEBITDA
					EVEBITDA EVEBITDA = new EVEBITDA();
					EVEBITDA.setTicker(xesUsEquity.getTicker());
					EVEBITDA.setDate(xesUsEquity.getDate());
					EVEBITDA.setActualevEBITDA(xesUsEquity.getPX_LAST() / xesUsEquity.getM_fwd_EBITDA());
					
					// Avg & STD
					EVEBITDA_avg += EVEBITDA.getActualevEBITDA();
					
					EVEBITDA_List.add(EVEBITDA);
					

					// EVEBITDA
					PBDTO PBDTO = new PBDTO();
					PBDTO.setTicker(xesUsEquity.getTicker());
					PBDTO.setDate(xesUsEquity.getDate());
					PBDTO.setActualPB(xesUsEquity.getPX_LAST() / xesUsEquity.getM_fwd_BVPS());
					
					// Avg & STD
					PBDTO_avg += PBDTO.getActualPB();
					
					PBDTO_List.add(PBDTO);
					
				}
				
				
				
				// TODO Save XesUsEquityList
				
				
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	} 
	
	
	
	
	

}
