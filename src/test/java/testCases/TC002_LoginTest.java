package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_LoginTest extends BaseClass {
	
	@Test(dataProvider="logindata",dataProviderClass=DataProviders.class)
	public void verifyLogin(String email,String pwd,String res)
	{
		HomePage hp=new HomePage(driver);
		hp.clkAccount();
		hp.clkLogin();
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clklogin();
		
		MyAccount ac=new MyAccount(driver);
		//System.out.println(res);
		//System.out.println(ac.MyAccDisplay());
		if(res.equalsIgnoreCase("Valid"))
		{
			if(ac.MyAccDisplay())
			{
				ac.clklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		}
		else if(res.equalsIgnoreCase("Invalid"))
		{
			if(ac.MyAccDisplay())
			{
				ac.clklogout();
				Assert.fail();
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}

}
