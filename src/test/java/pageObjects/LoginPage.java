package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement passwd;
	
	@FindBy(xpath="//input[@value='Login']") WebElement login;
	
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setPassword(String pwd)
	{
		passwd.sendKeys(pwd);
	}
	
	public void clklogin()
	{
		login.click();
	}
	
	
	
	

}
