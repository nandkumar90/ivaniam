package com.arial.ivanium.dao;

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

public interface IvaniamFinanceDao {
	public List<FactIngredientDTO> getAllFactFragment() throws Exception;

	public void saveFactIngedient(StandardFinancialIncomeStatmentDTO factIngredient) throws Exception;

	public void saveFactHistory(List<HistoricaldataDTO> incomeStatments) throws Exception;

	public void saveFactCompnaies(List<Common_CompDTO> incomeStatments) throws Exception;

	public void saveFactIntiutionalOwnership(List<IntiutionalOwnershipDTO> incomeStatments) throws Exception;

	public void saveFactNews(List<NewsDTO> news) throws Exception;

	public void saveCashFlow(CashFlowStatementDTO cashflow) throws Exception;

	public void saveBalanceSheet(BalanceSheetDTO balanceSheetDTO) throws Exception;

	public void saveCalculationSheet(CalculationsDTO financialIncomedto) throws Exception;

	public void saveFactHistorycom(List<Historical_data_Common_DTO> incomeStatmentcom) throws Exception;

	void saveFinancialCommonData(Common_financial_data_DTO financialcom) throws Exception;

	public List<Historical_data_Common_DTO> getFinancialCommonData(String ticker) throws Exception;

	public List<Common_financial_data_DTO> getFinancialCommonData(String ticker, String quarter, int year) throws Exception;

	List<HistoricaldataDTO> getLatestYearFinancialCommonData(String date, String ticker) throws Exception;

	List<Historical_data_Common_DTO> getLatestWeekFinancialCommonData(String date, String ticker, int week)
			throws Exception;

	List<String> getLatestDate(String tableName) throws Exception;

}
