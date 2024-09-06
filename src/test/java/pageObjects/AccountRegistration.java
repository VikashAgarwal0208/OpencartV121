package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {
	
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirm;
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")  WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement tel;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement passwd;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement cfmpasswd;
	
	@FindBy(xpath="//input[@name='agree']") WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement cntinue;
	
	public void setFirstname(String name)
	{
		firstname.sendKeys(name);
	}
	
	public void setLastname(String name)
	{
		lastname.sendKeys(name);
	}
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setTel(String phone)
	{
		tel.sendKeys(phone);
	}
	
	public void setPassword(String pwd)
	{
		passwd.sendKeys(pwd);
	}
	
	public void setCfmPassword(String pwd)
	{
		cfmpasswd.sendKeys(pwd);
	}
	
	public void clkAgree()
	{
		agree.click();
	}
	
	public void clkContinue()
	{
		cntinue.click();
	}
	
	public String getConfirmation()
	{
		try
		{
			return (confirm.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
}
