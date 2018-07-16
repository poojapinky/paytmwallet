package com.cg.parallel.dao;

import com.cg.parallel.bean.Account;
import com.cg.parallel.exception.AccountException;

public interface IParallelDao {
	String createAccount(Account acc) throws AccountException;
	double showBalance(String mobileNo) throws AccountException;
	Account deposit(String mobileNo) throws AccountException;
	Account withdraw(String mobileNo) throws AccountException;


Account printTransactionDetails(String mobileNo) throws AccountException;



}
