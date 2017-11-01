package com.arial.ivanium.delegate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.arial.ivanium.dao.IvaniamFinanceDao;
import com.arial.ivanium.delegate.DatabaseDelegate;
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


/**
 * @author ashus
 *
 */
public class DatabaseDelegateImpl implements DatabaseDelegate {

	@Autowired
	private IvaniamFinanceDao ivaniamFinanceDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<FactIngredientDTO> getFactIngredient() throws Exception {
		return ivaniamFinanceDao.getAllFactFragment();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveFinancialIncomeData(StandardFinancialIncomeStatmentDTO factIngredients) throws Exception {
		 ivaniamFinanceDao.saveFactIngedient(factIngredients);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveFinancialIncomeData(CashFlowStatementDTO cashflow) throws Exception {
		 ivaniamFinanceDao.saveCashFlow(cashflow);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveFinancialIncomeData(BalanceSheetDTO balanceSheetDTO)  throws Exception{
		 ivaniamFinanceDao.saveBalanceSheet(balanceSheetDTO);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveCalculationData(CalculationsDTO financialIncomedto) throws Exception {
		 ivaniamFinanceDao.saveCalculationSheet(financialIncomedto);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveDailyScriptClosedPriceData(List<HistoricaldataDTO> incomeStatments) throws Exception{
		 ivaniamFinanceDao.saveFactHistory(incomeStatments);		
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveQuaterlyComapniesData(List<CompaniesDTO> incomeStatments) throws Exception {
		 ivaniamFinanceDao.saveFactCompnaies(incomeStatments);		

	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveWeeklyTnstuitionalOwnership(List<IntiutionalOwnershipDTO> incomeStatments) throws Exception {
		ivaniamFinanceDao.saveFactIntiutionalOwnership(incomeStatments);				
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveDailyScriptNewsData(List<NewsDTO> news) throws Exception {
		ivaniamFinanceDao.saveFactNews(news);				
		
	}


	public IvaniamFinanceDao getIvaniamFinanceDao() {
		return ivaniamFinanceDao;
	}

	public void setIvaniamFinanceDao(IvaniamFinanceDao ivaniamFinanceDao) {
		this.ivaniamFinanceDao = ivaniamFinanceDao;
	}

	

	

	
}
