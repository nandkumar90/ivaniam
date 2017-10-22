package com.arial.ivanium.delegate;

import java.util.List;

import com.arial.ivanium.dto.CompaniesDTO;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;

public interface DatabaseDelegate {

	List<FactIngredientDTO> getFactIngredient() throws Exception;
	
	public void saveFinancialIncomeData(List<FinancialIncomeStatmentDTO> factIngredients) throws Exception;

	public void saveDailyScriptClosedPriceData(List<HistoricaldataDTO> incomeStatments) throws Exception;

	void saveQuaterlyComapniesData(List<CompaniesDTO> incomeStatments) throws Exception;

	void saveWeeklyTnstuitionalOwnership(List<IntiutionalOwnershipDTO> incomeStatments)throws Exception;

	void saveDailyScriptNewsData(List<NewsDTO> news) throws Exception;
	
	
}
