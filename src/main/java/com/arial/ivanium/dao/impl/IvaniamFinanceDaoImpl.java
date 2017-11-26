package com.arial.ivanium.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arial.ivanium.dao.AbstractDao;
import com.arial.ivanium.dao.IvaniamFinanceDao;
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

public class IvaniamFinanceDaoImpl extends AbstractDao implements IvaniamFinanceDao {
	Session session = null;
	Transaction tx = null;



	public List<FactIngredientDTO> getAllFactFragment() throws Exception {
		try {
			System.out.println("Fetching all user fragments ");
			
			Query query = getSession().createQuery("from FactIngredientDTO");
			return (List<FactIngredientDTO>) query.list();
		} catch (Exception ex) {
			
			throw new Exception(ex.getMessage().toString());

		}
	}

	public void saveFactIngedient(StandardFinancialIncomeStatmentDTO factIngredient) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			session.save(factIngredient);
		
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
	}

	
	@Override
	public void saveCashFlow(CashFlowStatementDTO cashflow) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			session.save(cashflow);
		
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}

	@Override
	public void saveBalanceSheet(BalanceSheetDTO balanceSheetDTO) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			session.save(balanceSheetDTO);
		
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}
	
	
	@Override
	public void saveCalculationSheet(CalculationsDTO financialIncomedto) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			session.save(financialIncomedto);
		
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}

	@Override
	public void saveFactHistory(List<HistoricaldataDTO> incomeStatments) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			for (HistoricaldataDTO historyDTO : incomeStatments) {
				
				session.save(historyDTO);
			}

			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}
	
	
	@Override
	public void saveFactHistorycom(List<Historical_data_Common_DTO> incomeStatmentcom) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			for (Historical_data_Common_DTO historyDTO : incomeStatmentcom) {
				
				session.save(historyDTO);
			}

			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}
	
	
	@Override
	public void saveFinancialCommonData(Common_financial_data_DTO financialcom) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			session.save(financialcom);
		
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}
		


	@Override
	public void saveFactCompnaies(List<Common_CompDTO> incomeStatments) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			for (Common_CompDTO companiesDTO : incomeStatments) {
				
				session.save(companiesDTO);
			}

			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}

	@Override
	public void saveFactIntiutionalOwnership(List<IntiutionalOwnershipDTO> incomeStatments) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			for (IntiutionalOwnershipDTO intiutionalOwnershipDTO : incomeStatments) {
				
				session.save(intiutionalOwnershipDTO);
			}

			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}

	@Override
	public void saveFactNews(List<NewsDTO> news) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			for (NewsDTO newsDTO : news) {
				
				session.save(newsDTO);
			}

			
		} catch (Exception ex) {
	        session.clear();

			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
		
	}

	@Override
	public List<Historical_data_Common_DTO> getFinancialCommonData(String ticker) throws Exception {
		try {
			System.out.println("Fetching all user com_historical_data ");
			
			Query query = getSession().createQuery("from com_historical_data where Ticker= :Ticker");
			query.setString("Ticker", ticker);
			return (List<Historical_data_Common_DTO>) query.list();
		} catch (Exception ex) {
			
			throw new Exception(ex.getMessage().toString());

		}
	}
	
	//quarter not avialable in Common_financial_data_DTO

	@Override
	public List<Common_financial_data_DTO> getFinancialCommonData(String ticker, String quarter, int fiscal_Year) throws Exception {
		try {
			System.out.println("Fetching all user com_financial_statement ");
			
			Query query = getSession().createQuery("from com_financial_statement where ticker= :ticker and fiscal_Year= :fiscal_Year");
			
			query.setString("ticker", ticker);
			//query.setString("fiscal_Year", fiscal_Year);
			return (List<Common_financial_data_DTO>) query.list();
		} catch (Exception ex) {
			
			throw new Exception(ex.getMessage().toString());

		}
	}

	
	

}
