package com.arial.ivanium.dao;

import java.util.List;

import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;

public interface IvaniamFinanceDao {
     public List<FactIngredientDTO> getAllFactFragment() throws Exception;

	public void saveFactIngedient(List<FinancialIncomeStatmentDTO> factIngredient)throws Exception;
}
