package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersPage extends BasePage
{
	WebDriver driver;
	public ComputersPage(WebDriver driver)
	{
		super(driver); // invoke parent class (BasePage) constructors

	}
	
	//Web Elements / Locators
	
	// This is the locator for 'Notebooks' link in the computer page 
		@FindBy(xpath="//img[@title='Show products in category Notebooks']")
		WebElement lnkNotebooks;
	
	
	// Action Methods
		
		public void clickNotebook()
		{
			lnkNotebooks.click();
		}

}
