package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Standard_Menu_Bar extends BasePage
{
	WebDriver driver;
	public Standard_Menu_Bar (WebDriver driver)
	{
		super(driver);  // invoke parent class (BasePage) constructors
	}
	
	//Web Elements / Locators
	
	// This is the locator for 'computer' menu  from the standard menu bar
				@FindBy(xpath="//a[normalize-space()='Computers']")
				WebElement lnkComputerMenu;
				
	// This is the locator for 'Notebooks' link under 'computer' menu  from the standard menu bar
				@FindBy(xpath="//a[@class='hover'][normalize-space()='Notebooks']")
				WebElement lnkNotebooks;
	
	// This is the locator for pop messages when a product is added to cart
				@FindBy(xpath="//p[@class='content']")
				WebElement popupMessage;
	
	// This is the locator for shopping cart link on  pop messages when a product is added to cart			
				@FindBy(xpath="//a[normalize-space()='shopping cart']")
				WebElement shopping_cart_link;
				
	// Action Methods
	// This methods click on Computer link on Computer page
				public void Computer_Menu()
				{
					lnkComputerMenu.click(); 
				}
				
	// This methods click on Notebook link on Notebooks page
				public void Notebooks_lnk()
				{
					lnkComputerMenu.click();  
				}
				
	// This methods captures the message on shopping cart PopUp (Green Banner) after the product is added to cart
				public String Find_Test_on_PopUp()
				{
					return popupMessage.getText();
					
				}
	// This methods click on shopping cart link on PopUp (Green Banner) after the product is added to cart
				public void shopping_cart_link_on_PopUp()
				{
					shopping_cart_link.click();
					
				}
}
