import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.parallel.bean.Account;
import com.cg.parallel.exception.AccountException;
import com.cg.parallel.service.IParallelService;
import com.cg.parallel.service.ParallelService;


public class ParallelTest {
	Account ac = new Account();
	private IParallelService service;
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
@Before
public void init() {
	service = new ParallelService();
}


@Test
public void testCreateAccountForMobile() {
	Account ac = new Account();
	ac.setMobileNo("1234");
	ac.setName("Hema");
	ac.setEmail("hema14@gmail.com");
	ac.setBalance(200.0);
	try {
		service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Mobile number should contain 10 digits", e.getMessage());
	}
}


@Test
public void testCreateAccountForName() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("hema34");
	ac.setEmail("hema1@gmail.com");
	ac.setBalance(500.0);
	try {
		service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
	}
}


@Test
public void testCreateAccountForNameIsEmpty() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("");
	ac.setEmail("anto70@gmail.com");
	ac.setBalance(200.0);
	try {
		service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Name cannot be empty", e.getMessage());
	}
}


@Test
public void testCreateAccountForEmailId() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("PiyushK");
	ac.setEmail("piyush@@97gmail.com");
	ac.setBalance(200.0);
	try {
		service.createAccount(ac);
	} catch ( AccountException e) {
		Assert.assertEquals("Enter valid emailid", e.getMessage());
	}
}


@Test
public void testCreateAccountForBalance() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("Priya");
	ac.setEmail("priya14@gmail.com");
	ac.setBalance(0);
	try {
		service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Balance should be greater than zero", e.getMessage());
	}
}


@Test
public void testCreateAccount() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("Acha");
	ac.setEmail("Acha06@gmail.com");
	ac.setBalance(200.0);
	
		try {
			String s=service.createAccount(ac);
			Assert.assertNotNull(s);
		} catch (AccountException e) {
			
			
		}
	
}


@Test
public void testShowBalanceForMobileNo() {
	
	try {
		service.showBalance("505059");
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
}




@Test
public void testShowBalanceForMobileNoDoesNotExist() {
	
	try {
		service.showBalance("1234561447");
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}




@Test
public void testShowBalanceForName() {
	Account ac=new Account();
	ac.setMobileNo("8056151678");
	try {
		service.showBalance(ac.getMobileNo());
		assertEquals("Priya", ac.getName());
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}


@Test
public void testDepositForMobileNo() {
	Account ac=new Account();
	ac.setMobileNo("78959345");
	try {
		service.deposit(ac.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
}
@Test
public void testDepositForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobileNo("7125652145");
	try {
		service.deposit(ac.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}
@Test
public void testDepositForDepositAmount() {
	Account ac=new Account();
	ac.setMobileNo("8056151078");
	try {
		service.deposit(ac.getMobileNo(), -230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Deposit amount must be greater than zero",e.getMessage());
	}
}


@Test
public void testDeposit() {
	Account ac=new Account();
	ac.setMobileNo("8056151078");
	try {
		Account ac1=service.deposit(ac.getMobileNo(), 230);
		assertNotNull(ac1);
	} catch (AccountException e) {
		
		System.out.println(e.getMessage());
	}
}


@Test
public void testWithDrawForMobileNo() {
	Account ac=new Account();
	ac.setMobileNo("7894545");
	try {
		service.withdraw(ac.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
}
@Test
public void testWithdrawForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobileNo("7895621445");
	try {
		service.withdraw(ac.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}
@Test
public void testWithdrawForAmount() {
	Account ac=new Account();
	ac.setMobileNo("8056151078");
	try {
		service.withdraw(ac.getMobileNo(), -230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
}




@Test
public void testFundTransferForMobileNo() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("80562345");
	ac2.setMobileNo("1234");
	try {
		service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
}
@Test
public void testFundTransferForMobileNoDoesNotExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("7895641235");
	ac2.setMobileNo("7896554445");
	try {
		service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}
@Test
public void testFundTransferForAmount() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("8056151078");
	ac2.setMobileNo("8056176824");
	try {
		service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  -230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
}
@Test
public void testFundTransfer() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("8056151078");
	ac2.setMobileNo("8056176824");
	try {
		assertTrue(service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230));
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
@Test
public void testPrinttransactionDetails() {
	Account ac=new Account();
	ac.setMobileNo("8056151078");
	try {
		Account acc=service.printTransactionDetails(ac.getMobileNo());
		assertNotNull(acc);
	} catch (AccountException e) {
		System.out.println(e.getMessage());
	}
	
}




}



