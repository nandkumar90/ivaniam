package com.arial.ivanium.delegate;

import java.util.ArrayList;
import java.util.List;

import com.arial.ivanium.dto.BalanceSheetDTO;
import com.arial.ivanium.dto.CalculationsDTO;
import com.arial.ivanium.dto.CashFlowStatementDTO;
import com.arial.ivanium.dto.Common_CompDTO;
import com.arial.ivanium.dto.Common_financial_data_DTO;
import com.arial.ivanium.dto.CompaniesDTO;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.Historical_data_Common_DTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;
import com.arial.ivanium.dto.StandardFinancialIncomeStatmentDTO;

public interface DatabaseDelegate {

	List<FactIngredientDTO> getFactIngredient() throws Exception;
	
	public void saveFinancialIncomeData(StandardFinancialIncomeStatmentDTO financialIncomedto) throws Exception;

	public void saveDailyScriptClosedPriceData(List<HistoricaldataDTO> incomeStatments) throws Exception;

	void saveQuaterlyComapniesData(List<Common_CompDTO> incomeStatments) throws Exception;

	void saveWeeklyTnstuitionalOwnership(List<IntiutionalOwnershipDTO> incomeStatments)throws Exception;

	void saveDailyScriptNewsData(List<NewsDTO> news) throws Exception;

	void saveFinancialIncomeData(CashFlowStatementDTO cashflow)throws Exception;

	void saveFinancialIncomeData(BalanceSheetDTO balanceSheetDTO)throws Exception;

	void saveCalculationData(CalculationsDTO financialIncomedto) throws Exception;

	void saveFactHistorycom(List<Historical_data_Common_DTO> historical_data_list) throws Exception;

	void saveFinancialCommonData(Common_financial_data_DTO common_finance_DTO) throws Exception;
	
	public List<Historical_data_Common_DTO> getFinancialCommonData(String ticker) throws Exception;

	public List<Common_financial_data_DTO> getFinancialCommonData(String ticker, String quarter, int year) throws Exception;

	List<HistoricaldataDTO> getYearlyLatestData(String date, String ticker) throws Exception;

	List<Historical_data_Common_DTO> getWeeklyLatestData(String date, String ticker, int yeweekar) throws Exception;

	List<String> getLatestDate(String tableName) throws Exception;

	
}
