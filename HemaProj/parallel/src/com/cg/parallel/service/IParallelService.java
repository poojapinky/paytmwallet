package com.cg.parallel.service;

import com.cg.parallel.bean.Account;
import com.cg.parallel.exception.AccountException;

public interface IParallelService {
	String createAccount(Account acc) throws AccountException;
	double showBalance(String mobileNo) throws  AccountException;
	Account deposit(String mobileNo,double depositAmt) throws  AccountException;
	Account withdraw(String mobileNo,double withdrawAmt) throws  AccountException;
	boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmt) throws  AccountException;
	Account printTransactionDetails(String mobileNo) throws  AccountException;
}


