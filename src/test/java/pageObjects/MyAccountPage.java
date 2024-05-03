package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	WebDriver driver;
	public MyAccountPage(WebDriver driver)
	{
		super(driver);  // invoke parent class (BasePage) constructors
	}
	
	//Web Elements / Locators
	
	// This is the locator for 'Log In' email id on the home page (Top Right)
			//@FindBy(xpath="//a[normalize-space()='TESTAA@TEST.com']")
			@FindBy(linkText="TESTAA@TEST.com")
			WebElement msgEmail;
			
			
	// This is the locator for 'Log out' button on the home page (Top Right)
			@FindBy(xpath="//a[normalize-space()='Log out']")
			WebElement lnkLogout;
			
	// This is the locator for 'Log out' button on the home page (Top Right)
			@FindBy(linkText="Log out")
			WebElement lnkLogoutTxt;
			
	public boolean isMyAccountPageExists()
	{
		try 
		{
			return (msgEmail.isDisplayed());
		}catch(Exception e)
		{
			return(false);
		}
	}
	
	public boolean isMyAccountPageLogoutTextExists()
	{
		try 
		{
			return (lnkLogoutTxt.isDisplayed());
		}catch(Exception e)
		{
			return(false);
		}
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
			
			
}
