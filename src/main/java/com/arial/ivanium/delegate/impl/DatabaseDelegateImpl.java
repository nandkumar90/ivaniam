package com.arial.ivanium.delegate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.arial.ivanium.dao.IvaniamFinanceDao;
import com.arial.ivanium.delegate.DatabaseDelegate;
import com.arial.ivanium.dto.CompaniesDTO;
import com.arial.ivanium.dto.FactIngredientDTO;
import com.arial.ivanium.dto.FinancialIncomeStatmentDTO;
import com.arial.ivanium.dto.HistoricaldataDTO;
import com.arial.ivanium.dto.IntiutionalOwnershipDTO;
import com.arial.ivanium.dto.NewsDTO;


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
	public void saveFinancialIncomeData(List<FinancialIncomeStatmentDTO> factIngredients) throws Exception {
		 ivaniamFinanceDao.saveFactIngedient(factIngredients);
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

	
	
	
	
	
//	
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public boolean createUser(User user) {
//		return userDao.createUser(user);
//	}
//	
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public boolean createAddress(UserAddress address) {
//		return userDao.createAddress(address);
//	}
//	
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS)
//	public int getTotalAddress() {
//		return userDao.getTotalAddress();
//	}
//	
//	@Transactional(propagation=Propagation.REQUIRED)
//	public boolean createReferralCashBack(User user) {
//		User refereeUser = userDao.getUserByRefereeCode(user.getRefereeCode());
//		try {
//			Transaction transaction = new Transaction();
//			transaction.setTransactionId(generateTransactionId(refereeUser));
//			transaction.setWallet(refereeUser.getPhone());
//			transaction.setAmount(TransactionConstants.REFERRAL_BONUS_AMOUNT);
//			transaction.setTransactionType(TransactionType.CREDIT);
//			transaction.setTransactionCategory(TransactionCategory.REFERRAL_BONUS);
//			transaction.setComment("Referral Bonus for User:"+user.getName());
//			transactionDao.createTransaction(transaction);
//			return true;
//		} catch (Exception e) {
//			System.out.println("failed to create transaction");
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public Wallet getUserWallet(String userId) {
//		return userDao.getUserWallet(userId);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public List<UserAddress> getUserAddress(String userId) {
//		return userDao.getUserAddress(userId);
//	}
//	
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public List<UserActivity> getUserActivity(String userId) {
//		return userDao.getUserActivity(userId);
//	}
//	
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public UserAddress getAddressById(String addressId) {
//		return userDao.getAddressById(addressId);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public Menu getMenuItemById(String menuItem) {
//		return menuDao.getMenuById(menuItem);
//	}
//	
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public boolean createOrderWithTransactions(Order orderObj,
//			List<Transaction> transactions) {
//		try {
//			orderDao.createOrder(orderObj);
//			transactions.forEach(t->{
//				transactionDao.createTransaction(t);
//				Wallet wallet = userDao.getUserWallet(t.getWallet());
//				if(t.getTransactionCategory().equals(TransactionCategory.PROMOTIONAL.name())) {
//					wallet.setPromotionalBalance((int)(wallet.getPromotionalBalance()-t.getAmount()));
//				}
//				if(t.getTransactionCategory().equals(TransactionCategory.WALLET.name())) {
//					wallet.setWalletBalance(((int)(wallet.getWalletBalance()-t.getAmount())));
//				}
//				userDao.updateWallet(wallet);				
//			});
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Exception while creating order and transactions");
//			return false;
//		}
//	}
//	
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public boolean createOrder(Order order) {
//		orderDao.createOrder(order);
//		return true;
//	}
//	
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public Order getOrder(String orderId) {
//		return orderDao.getOrder(orderId);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public List<Order> getOrdersByCustomer(String userId) {
//		return orderDao.getOrdersByCustomer(userId);
//	}
//	
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public String updateOrderStatus(String orderId, String status) {
//		return orderDao.updateOrderStatus(orderId, status);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public User getUser(String userId) {
//		return userDao.getUser(userId);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public List<Transaction> getTransactionsByWallet(String walletId) {
//		return transactionDao.getTransactionsByWallet(walletId);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public List<Transaction> getTransactionsByWallet(String walletId,
//			TransactionType debit) {
//		return transactionDao.getTransactionsByWallet(walletId,debit);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
//	public List<Transaction> getTransactionsByWallet(String walletId,
//			TransactionCategory promotional) {
//		return transactionDao.getTransactionsByWallet(walletId,promotional);
//	}
//	
//	/**
//	 * Generates transactionId based on currentTimestamp sandwiched in first and last digit of mobile number
//	 * @param user
//	 * @return
//	 */
//	public String generateTransactionId(User user) {
//		StringBuffer sb = new StringBuffer();
//		sb.append(user.getPhone().charAt(0));
//		sb.append(Instant.now().toEpochMilli());
//		sb.append(user.getPhone().charAt(9));
//		return sb.toString();
//	}
//
//	@Override
//	public Transaction createTransaction(Transaction transaction) {
//		return null;
//	}
//
//	@Override
//	public String updateTransaction(Transaction transaction) {
//		return null;
//	}
//	
//	public MenuDao getMenuDao() {
//		return menuDao;
//	}
//
//	public void setMenuDao(MenuDao menuDao) {
//		this.menuDao = menuDao;
//	}
//
//	public UserDao getUserDao() {
//		return userDao;
//	}
//
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
//	
//	public OrderDao getOrderDao() {
//		return orderDao;
//	}
//
//	public void setOrderDao(OrderDao orderDao) {
//		this.orderDao = orderDao;
//	}
//
//	public TransactionDao getTransactionDao() {
//		return transactionDao;
//	}
//
//	public void setTransactionDao(TransactionDao transactionDao) {
//		this.transactionDao = transactionDao;
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public void saveFeedback(Feedback feedback) {
//		userDao.saveFeedback(feedback);
//		
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public Order getOrderByTransaction(String transactionId) {
//		return orderDao.getOrderByTransaction(transactionId);
//	}

}
