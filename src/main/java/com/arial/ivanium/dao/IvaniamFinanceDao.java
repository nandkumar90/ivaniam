package com.arial.ivanium.dao;

import java.util.List;

import com.arial.ivanium.dto.CompaniesDTO;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;

public interface IvaniamFinanceDao {
     public List<FactIngredientDTO> getAllFactFragment() throws Exception;

	public void saveFactIngedient(List<FinancialIncomeStatmentDTO> factIngredient)throws Exception;

	public void saveFactHistory(List<HistoricaldataDTO> incomeStatments) throws Exception;

	public void saveFactCompnaies(List<CompaniesDTO> incomeStatments) throws Exception;

	public void saveFactIntiutionalOwnership(List<IntiutionalOwnershipDTO> incomeStatments) throws Exception;

	public void saveFactNews(List<NewsDTO> news) throws Exception;
}
