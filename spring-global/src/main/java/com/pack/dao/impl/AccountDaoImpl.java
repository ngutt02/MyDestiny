package com.pack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.IAccountDao;
import com.pack.global.exceptions.AmountOverFlowException;
import com.pack.global.exceptions.InsufficientFundsException;
@Repository
public class AccountDaoImpl implements IAccountDao {

	@Autowired
	JdbcTemplate jdbcTemplate1;
	@Autowired
	JdbcTemplate jdbcTemplate2;
	private static String ACC1_BALANCE="select balance from iciciaccounts where accountnumber=?";
	private static String ACC2_BALANCE="select balance from hdfcaccounts where  accountnumber=?";
	private static String ACC1_UPDATE_QUERY="update iciciaccounts set balance=? where accountnumber=?";
	private static String ACC2_UPDATE_QUERY="update hdfcaccounts set balance=? where accountnumber=?";


	@Transactional(timeout=30,propagation=Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public void transferMoney(Integer account1, Integer account2, Double amount) {
		if(amount>40000)
		{
			throw new AmountOverFlowException("Message:Amount > 40000 can't be transfered");
		}
		double account1_balance=jdbcTemplate1.queryForObject(ACC1_BALANCE,Double.class,account1);
		double account1_new_balance=account1_balance-amount;
		if(account1_new_balance>1000)
		{
			double account2_balance=jdbcTemplate2.queryForObject(ACC2_BALANCE, Double.class,account2);
			double account2_new_balance=account2_balance+amount;
			jdbcTemplate1.update(ACC1_UPDATE_QUERY,account1_new_balance,account1);
			jdbcTemplate2.update(ACC2_UPDATE_QUERY,account2_new_balance,account2);

		}
		else {
			throw new InsufficientFundsException("Message:Insufficient Money in the Account");
		}
	}

}
