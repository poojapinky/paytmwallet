package com.cg.count.dao;

import com.cg.count.bean.Account;
import com.cg.count.exception.AccountException;

public interface IAccountDao {
String CreateAccount(Account acc)throws AccountException;
double showBalance(String mobileno)throws AccountException;
Account deposit(String mobileno)throws AccountException;
Account withdraw(String mobileno)throws AccountException;
Account printTransactionDetails(String mobileno) throws AccountException;
}
