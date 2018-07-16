package com.cg.count.dao;

import java.util.HashMap;

import com.cg.count.bean.Account;
import com.cg.count.db.AccountDB;
import com.cg.count.exception.AccountException;

public class Accountcdao implements IAccountDao {
	private static HashMap<String,Account> AccountMap=AccountDB.getAccountDB();
	@Override
	public String CreateAccount(Account acc) throws AccountException {
		AccountMap.put(acc.getMobileNo(), acc);
		return acc.getMobileNo();
	}

	@Override
	public double showBalance(String mobileno) throws AccountException {
		Account acc=AccountMap.get(mobileno);
		if(acc==null){
			throw new AccountException("The mobile number does not exist");
		}
		return acc.getBalance();
	}

	@Override
	public Account deposit(String mobileno) throws AccountException {
		Account acc=AccountMap.get(mobileno);
		if(acc==null){
			throw new AccountException("The mobile number does not exist");
		}
		return acc;
	}

	@Override
	public Account withdraw(String mobileno) throws AccountException {
		Account acc=AccountMap.get(mobileno);
		if(acc==null){
			throw new AccountException("The mobile number does not exist");
		}
		return acc;
	}

	

	@Override
	public Account printTransactionDetails(String mobileno)
			throws AccountException {
		Account acc=AccountMap.get(mobileno);
		if(acc==null){
			throw new AccountException("The mobile number does not exist");
		}
		return null;
	}

	
}

	



