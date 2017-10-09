package com.arial.ivanium.delegate;

import java.util.List;

import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;

public interface DatabaseDelegate {

	List<FactIngredientDTO> getFactIngredient() throws Exception;
	
	public void saveFinancialIncomeData(List<FinancialIncomeStatmentDTO> factIngredients) throws Exception;
}
