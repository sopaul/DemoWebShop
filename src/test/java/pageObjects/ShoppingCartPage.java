package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage 
{
	WebDriver driver;
	public ShoppingCartPage(WebDriver driver) 
	{
		super(driver); // invoke parent class (BasePage) constructors

	}
	
	//Web Elements / Locators
	
	// This is the locator to select the product in the cart page 
		@FindBy(xpath="//input[@name='removefromcart']")
		WebElement ChkBxRemoveFromCart_Item;
		
	// This is the locator for update shopping cart button in the cart page 
		@FindBy(xpath="//input[@name='updatecart']")
		WebElement UdtShopCartBtn_Item;
	
	// This is the locator for selecting 'termsofservice' in the cart page
		
		@FindBy(xpath="//input[@id='termsofservice']")
		WebElement ChkBxTermsOfService_Item;
	
	// This is the locator for 'check out' button in the cart page
		
		@FindBy(xpath="//button[@id='checkout']")
		WebElement BtnChkOut;
		
	// This is the locator for empty shopping cart messages when a product is removed from the cart
		@FindBy(xpath="//div[@class='order-summary-content']")
		WebElement ShpCrtMsg;
		
		
	// Action Methods
		
	//Method to select the product for remove the item from shopping cart
		public void ChkBxRemoveFromCart()
		{
			ChkBxRemoveFromCart_Item.click();
		}
		
	//Method to click 'Update Cart button' shopping cart
		public void UdtShopCartBtn()
		{
			UdtShopCartBtn_Item.click();
		}
		
	//Method to select terms of service in from shopping cart
		public void ChkBxTermsOfService()
		{
			ChkBxTermsOfService_Item.click();
		}
		
	//Method to click check out button from shopping cart
		public void BtnChkOut_Click()
		{
			BtnChkOut.click();
		}
		
	// This methods captures the message on shopping cart after the product is removed from the cart
		public String Find_Msg_on_ShoppingCrt()
		{
			return ShpCrtMsg.getText();
			
			
		}
		
}

