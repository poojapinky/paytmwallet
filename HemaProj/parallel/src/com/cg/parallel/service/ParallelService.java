package com.cg.parallel.service;

import java.time.LocalDateTime;
import com.cg.parallel.bean.Account;
import com.cg.parallel.dao.IParallelDao;
import com.cg.parallel.dao.ParallelDao;
import com.cg.parallel.exception.AccountException;
public class ParallelService implements IParallelService {
	IParallelDao pdao = new ParallelDao();
	@Override
	public String createAccount(Account acc) throws AccountException {
		if (!acc.getMobileNo().matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
		}
		if (acc.getName().isEmpty() || acc.getName() == null) {
			throw new AccountException("Name cannot be empty");
		} else {
			if (!acc.getName().matches("[A-Z][A-Za-z]{3,}")) {
				throw new AccountException("Name should start with capital letter and should contain only alphabets");
			}
			
		}
		if (acc.getBalance() <= 0) {
			throw new AccountException("Balance should be greater than zero");
		}
		if (acc.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")) {
			throw new AccountException("Enter valid emailid");
		}
		
		return pdao.createAccount(acc);

	}

	@Override
	public double showBalance(String mobileNo) throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
		}
		return pdao.showBalance(mobileNo);

	}

	@Override
	public Account deposit(String mobileNo, double depositAmt)
			throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
		}
		Account acc = pdao.deposit(mobileNo);
		if (depositAmt <= 0) {
			throw new AccountException("Deposit amount must be greater than zero");
		}
		acc.setBalance(acc.getBalance() + depositAmt);
		acc.setDatet(LocalDateTime.now());
		return acc;

	}

	@Override
	public Account withdraw(String mobileNo, double withdrawAmt)
			throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
		}
		Account acc = pdao.withdraw(mobileNo);
		if (withdrawAmt > acc.getBalance() || withdrawAmt <= 0) {
			throw new AccountException(
					"The amount to be withdrawn should be greater than available balance and greater than zero");
		}
		acc.setBalance(acc.getBalance() - withdrawAmt);
		acc.setDatet(LocalDateTime.now());
		return acc;


	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmt) throws AccountException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
		}
		if (!destMobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
		}
		IParallelService service = new ParallelService();
		service.withdraw(sourceMobileNo, transferAmt);
		service.deposit(destMobileNo, transferAmt);
		return true;

	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws AccountException {
		return pdao.printTransactionDetails(mobileNo);
	}

}
