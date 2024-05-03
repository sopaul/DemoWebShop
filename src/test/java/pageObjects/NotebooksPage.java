package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotebooksPage extends BasePage
{
	WebDriver driver;
	public NotebooksPage(WebDriver driver)
	{
		super(driver); // invoke parent class (BasePage) constructors

	}
	
	//Web Elements / Locators
	
	// This is the locator for 'Add to cart' link in the Notebooks page 
		@FindBy(xpath="	//input[@value='Add to cart']")
		WebElement lnkNotebooksAdd2Cart;
	
	
	// Action Methods
		
		public void AddNotebook_1()
		{
			lnkNotebooksAdd2Cart.click();
		}

}
