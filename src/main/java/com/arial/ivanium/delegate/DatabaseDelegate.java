package com.arial.ivanium.delegate;

import java.util.List;

import com.arial.ivanium.dto.BalanceSheetDTO;
import com.arial.ivanium.dto.CalculationsDTO;
import com.arial.ivanium.dto.CashFlowStatementDTO;
import com.arial.ivanium.dto.CompaniesDTO;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;
import com.arial.ivanium.dto.StandardFinancialIncomeStatmentDTO;

public interface DatabaseDelegate {

	List<FactIngredientDTO> getFactIngredient() throws Exception;
	
	public void saveFinancialIncomeData(StandardFinancialIncomeStatmentDTO financialIncomedto) throws Exception;

	public void saveDailyScriptClosedPriceData(List<HistoricaldataDTO> incomeStatments) throws Exception;

	void saveQuaterlyComapniesData(List<CompaniesDTO> incomeStatments) throws Exception;

	void saveWeeklyTnstuitionalOwnership(List<IntiutionalOwnershipDTO> incomeStatments)throws Exception;

	void saveDailyScriptNewsData(List<NewsDTO> news) throws Exception;

	void saveFinancialIncomeData(CashFlowStatementDTO cashflow)throws Exception;

	void saveFinancialIncomeData(BalanceSheetDTO balanceSheetDTO)throws Exception;

	void saveCalculationData(CalculationsDTO financialIncomedto) throws Exception;
	
	
}
