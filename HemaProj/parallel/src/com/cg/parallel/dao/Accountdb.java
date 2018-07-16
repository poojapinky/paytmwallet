package com.cg.parallel.dao;
import java.util.HashMap;
import com.cg.parallel.bean.Account;
public class Accountdb {
private static HashMap<String,Account> accdb = new HashMap<String,Account>();
public static HashMap<String,Account> getAccdb() {
	return accdb;
}
static{
	accdb.put("8056176824",  new Account("8056176824","hema14@gmail.com","Hema",3000.0));
	accdb.put("8056151078",  new Account("8056151078","priya4anand@gmail.com","Priya",4000.0));
	accdb.put("9444660822",  new Account("9444660822","priya14anand@gmail.com","Anand",1000.0));
	accdb.put("9790736981",  new Account("9790736981","hema10@gmail.com","Achu",1500.0));
}
}