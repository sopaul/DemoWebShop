package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnePageCheckoutPage extends BasePage 
{
	WebDriver driver;
	public OnePageCheckoutPage(WebDriver driver) 
	{
		super(driver); // invoke parent class (BasePage) constructors
	
	}
	
	//Web Elements / Locators
	
	// This is the locator for continue button on billing section on onepagecheckout page 
		@FindBy(xpath="//input[@onclick='Billing.save()']")
		WebElement BtnContinueBilling_Item;
		
	// This is the locator for continue button on Shipping section on onepagecheckout page 
		@FindBy(xpath="//input[@onclick='Shipping.save()']")
		WebElement BtnContinueShipping_Item;
		
	// This is the locator for continue button on Shipping method on onepagecheckout page 
		@FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']")
		WebElement BtnContinueShippingMethod_Item;
		
	// This is the locator for credit card on onepagecheckout page 
		@FindBy(xpath="//input[@id='paymentmethod_2']")
		WebElement RdBtnCC_Item;
		
	// This is the locator for continue button on payment method on onepagecheckout page
		@FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
		WebElement BtnContinuePaymentMethod_Item;
		
	// This is the locator for continue button on payment info on onepagecheckout page
		@FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']")
		WebElement BtnContinuePaymentInfo_Item;
		
	// This is the locator for confirm button on confirm order on onepagecheckout page
	   @FindBy(xpath="//input[@value='Confirm']")
	   WebElement BtnConfirm_Item;	
				
		
		
		
		
	// Action Methods
		
	//Method to click on Continue button on Billing section
			public void BtnContinueBilling()
			{
				BtnContinueBilling_Item.click();
			}
			
	//Method to click on Continue button on Shipping section
			public void BtnContinueShipping()
			{
				BtnContinueShipping_Item.click();
			}
			
	//Method to click on Continue button on Shipping method
			public void BtnContinueShippingMethod()
			{
				BtnContinueShippingMethod_Item.click();
			}
			
	//Method to select credit card
			public void RdBtnCC()
			{
				RdBtnCC_Item.click();
			}
			
	//Method to click on Continue button on Shipping method
			public void BtnContinuePaymentMethod()
			{
				BtnContinuePaymentMethod_Item.click();
			}
			
	//Method to click on Continue button on Payment Info
			public void BtnContinuePaymentInfo()
			{
				BtnContinuePaymentInfo_Item.click();
			}
			
	//Method to click on Confirm button on Confirm Order
			public void BtnConfirm()
			{
				BtnConfirm_Item.click();
			}
}
