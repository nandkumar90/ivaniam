package com.arial.ivanium.dao;

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

public interface IvaniamFinanceDao {
     public List<FactIngredientDTO> getAllFactFragment() throws Exception;

	public void saveFactIngedient(StandardFinancialIncomeStatmentDTO factIngredient)throws Exception;

	public void saveFactHistory(List<HistoricaldataDTO> incomeStatments) throws Exception;

	public void saveFactCompnaies(List<CompaniesDTO> incomeStatments) throws Exception;

	public void saveFactIntiutionalOwnership(List<IntiutionalOwnershipDTO> incomeStatments) throws Exception;

	public void saveFactNews(List<NewsDTO> news) throws Exception;

	public void saveCashFlow(CashFlowStatementDTO cashflow) throws Exception;

	public void saveBalanceSheet(BalanceSheetDTO balanceSheetDTO) throws Exception;

	public void saveCalculationSheet(CalculationsDTO financialIncomedto)throws Exception;
}
