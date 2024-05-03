package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletedPage extends BasePage
{
	WebDriver driver;
	public CompletedPage (WebDriver driver)
	{
		super(driver); // invoke parent class (BasePage) constructors

	}
	
	//Web Elements / Locators
	
	
	// This is the locator for the continue button after confirming the order on the thank you page
	@FindBy(xpath="//input[@value='Continue']")
	WebElement ThankYouContinueBtn_item;
	
	// This is the locator for the thank you messages displayed after purchasing the order
	@FindBy(xpath="//strong[normalize-space()='Your order has been successfully processed!']")
	WebElement thankyouMessage_item;
	
		
	
	
	// Action Methods
	
	public void ThankYouContinueBtn()
	{
		ThankYouContinueBtn_item.click();
	}
	
	public String thankyouMessage()
	{
		return thankyouMessage_item.getText();
		

	}
	
	

}
