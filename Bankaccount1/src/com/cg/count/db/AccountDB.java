package com.cg.count.db;

import java.time.LocalDateTime;

import java.util.HashMap;

import com.cg.count.bean.Account;

public class AccountDB {
	private static HashMap<String,Account> AccountDB=new HashMap<String,Account>();
	public static HashMap<String,Account>	getAccountDB(){
	return AccountDB;	
	}

   static
{
	AccountDB.put("9966864339", new Account("9966864339","Paddu","paddu@capgemini.com",12000,LocalDateTime.now()));
	AccountDB.put("9966065155", new Account("9966065155","Ram","ram@capgemini.com",14000,LocalDateTime.now()));
	AccountDB.put("9864854785", new Account("9864854785","Anil","anil@capgemini.com",13000,LocalDateTime.now()));
	AccountDB.put("9954598903", new Account("9954598903","Sony","sony@capgemini.com",17000,LocalDateTime.now()));
	AccountDB.put("9877733333", new Account("9877733333","Amith","amith@capgemini.com",15000,LocalDateTime.now()));
	
}
}
