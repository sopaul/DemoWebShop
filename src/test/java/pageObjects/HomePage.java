package pageObjects;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//OR
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HomePage extends BasePage
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver); // invoke parent class (BasePage) constructors

	}
	
	//Web Elements / Locators
	
	// This is the locator for 'Register' link in the home page menu (Top Right)
	// Used Page Factory Model for @FindBy
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	// This is the locator for 'Log In' link in the home page (Top Right)
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement lnkLogin;
	
	
	//@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	//WebElement txtSearchbox;
	
	//@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	//WebElement btnSearch;
	
	// Action Methods
	
	//This method click on  'My Account'link in the home page menu (Top Right)
	/*public void clickMyAccount()
	{
		lnkMyaccount.click();
	}*/
	
	//This method click on 'Register'link in the home page menu (under My Account dropdown menu)
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	//This method click on 'Login'link in the home page menu (under My Account dropdown menu)
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	/*
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	*/
}
