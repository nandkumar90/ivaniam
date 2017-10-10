package com.arial.ivanium.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arial.ivanium.dao.AbstractDao;
import com.arial.ivanium.dao.IvaniamFinanceDao;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;

public class IvaniamFinanceDaoImpl extends AbstractDao implements IvaniamFinanceDao {
	Session session = null;
	Transaction tx = null;

	// @Override
	// public List<Menu> getMenuByDate(Date date) {
	// System.out.println("Fetching menu for "+ date);
	// Criteria criteria = getSession().createCriteria(Menu.class);
	// criteria.add(Restrictions.eq("date", date));
	// return criteria.list();
	// }
	//
	// @Override
	// public List<Menu> getTodaysMenu() {
	// List<Menu> todayMenu = getMenuByDate(new Date(System.currentTimeMillis()));
	// if(todayMenu.size()>0 )
	// return todayMenu;
	// return getMenuByDate(Date.valueOf("2016-12-18"));
	// }
	//
	// @Override
	// public Menu getTodaysMenuByCuisine(int cuisine) {
	// List<Menu> todaysMenu = getTodaysMenu();
	// Optional<Menu> menu = todaysMenu.stream()
	// .filter(m -> m.getCuisine().getId() == cuisine).findAny();
	// return menu.get();
	// }
	//
	// @Override
	// public Menu getMenuById(String menuItem) {
	// System.out.println("Fetching menu for "+ menuItem);
	// Criteria criteria = getSession().createCriteria(Menu.class);
	// criteria.add(Restrictions.eq("id", Integer.parseInt(menuItem)));
	// return (Menu)criteria.uniqueResult();
	// }

	public List<FactIngredientDTO> getAllFactFragment() throws Exception {
		try {
			System.out.println("Fetching all user fragments ");
			
			Query query = getSession().createQuery("from FactIngredientDTO");
			return (List<FactIngredientDTO>) query.list();
		} catch (Exception ex) {
			
			throw new Exception(ex.getMessage().toString());

		}
	}

	/*
	 * public void saveFactIngedient(List<FinancialIncomeStatmentDTO>
	 * factIngredient) throws Exception { try { System.out.
	 * println("Saving all csv data into table financial_income_statement ");
	 * 
	 * Query query = getSession().createQuery("from FinancialIncomeStatmentDTO");
	 * return (List<FactIngredientDTO>) query.list(); } catch (Exception ex) {
	 * 
	 * throw new Exception(ex.getMessage().toString());
	 * 
	 * }
	 * 
	 * }
	 */


	public void saveFactIngedient(List<FinancialIncomeStatmentDTO> factIngredient) throws Exception {
		try {
			System.out.println("Saving all csv data into table financial_income_statement ");
			session = getSession();
			tx = getSession().beginTransaction();
			for (FinancialIncomeStatmentDTO financialIncomeStatmentDTO : factIngredient) {
				
				session.save(financialIncomeStatmentDTO);
			}

			tx.commit();
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage().toString());

		}
		finally {
			System.out.println("in finally");
		}
	}

}
