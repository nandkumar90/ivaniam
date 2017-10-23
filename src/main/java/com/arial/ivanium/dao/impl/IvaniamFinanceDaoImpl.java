package com.arial.ivanium.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arial.ivanium.dao.AbstractDao;
import com.arial.ivanium.dao.IvaniamFinanceDao;
import com.arial.ivanium.dto.CompaniesDTO;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;

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

	public void saveFactIngedient(List<FinancialIncomeStatmentDTO> factIngredient) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : factIngredient) {
				
				session.save(financialIncomeStatmentDTO);
			}

			
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
	public void saveFactCompnaies(List<CompaniesDTO> incomeStatments) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			for (CompaniesDTO companiesDTO : incomeStatments) {
				
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

}
