package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage 
{
	WebDriver driver;
	public SearchResultPage(WebDriver driver) 
	{
		super(driver); // invoke parent class (BasePage) constructors

	}
	
	//Web Elements / Locators
	
	// This is the locator to select the product in the cart page 
		@FindBy(xpath="//strong[@class='result']")
		WebElement ResultPageMsg_Item;
		
	// Action Methods
		
	//Method to select the product for remove the item from shopping cart
	public String ResultPageMsg()
	{
		return ResultPageMsg_Item.getText();
		
	}
	
	

}
