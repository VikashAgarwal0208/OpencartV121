package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void verifyRegistration()
	{
		logger.info("Starting Test");
		HomePage hp=new HomePage(driver);
		hp.clkAccount();
		hp.clkRegister();
		AccountRegistration ac=new AccountRegistration(driver);
		ac.setFirstname(randomString());
		ac.setLastname(randomString());
		ac.setEmail(randomString()+"@gmail.com");
		ac.setTel(randomNumber());
		String s=randomString();
		ac.setPassword(s);
		ac.setCfmPassword(s);
		ac.clkAgree();
		ac.clkContinue();
		Assert.assertEquals(ac.getConfirmation(),"Your Account Has Been Created!!");
		logger.info("Test Ends");
	}

}
