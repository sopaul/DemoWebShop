package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);  // invoke parent class (BasePage) constructors
	}
	
	//Web Elements / Locators
	
	// This is the locator for 'Email' link in the home page (Top Right)
		@FindBy(xpath="//input[@id='Email']")
		WebElement txtEmailAddress;
		
	// This is the locator for 'Password' link in the home page (Top Right)
		@FindBy(xpath="//input[@id='Password']")
		WebElement txtPassword;
		
	// This is the locator for 'Log In' button in the home page (Top Right)
		@FindBy(xpath="//input[@value='Log in']")
		WebElement btnLogIn;
	
	

		// Action Methods
		
		public void setEmail(String email)
		{
			txtEmailAddress.sendKeys(email);
		}
		
		public void setPassword(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		
		public void clickLogin()
		{
			btnLogIn.click();
		}
		
	

}
