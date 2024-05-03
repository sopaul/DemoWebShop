package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CompletedPage;
import pageObjects.ComputersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.NotebooksPage;
import pageObjects.OnePageCheckoutPage;
import pageObjects.ShoppingCartPage;
import pageObjects.Standard_Menu_Bar;
import testBase.BaseClass;

public class TC_CO_001_Checkout_as_SignedIn_User extends BaseClass
{
	@Test(groups={"regression", "master"})
	public void verify_login()
	{
	
	logger.info("******Starting TC_CO_001_Checkout_as_SignedIn_User******");
	logger.debug("Capturing application debug logs....");
	try
	{
	// Home Page
	HomePage hp=new HomePage(driver); // Create an object from HomePage page object class
	hp.clickLogin(); // HomePage login link 
	logger.info("Clicked on Login link");
	
	// Login Page
	LoginPage lp=new LoginPage(driver);
	logger.info("Entering valid email and password");
	lp.setEmail(p.getProperty("email")); // reading 'email' from the config.properties file
	lp.setPassword(p.getProperty("password")); // reading 'password' from the config.properties file
	lp.clickLogin(); // HomePage login button
	logger.info("Clicked on Login button");
	
	//My Account Page
	
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	
		if(targetPage==true)
			{
			Assert.assertTrue(true);
			}
		else
			{
			logger.error("Login test failed");
			Assert.fail();
			}
	//User to click on computer on Standard menu
	Standard_Menu_Bar SMB=new Standard_Menu_Bar(driver);
	logger.info("Click on Computer Menu");
	SMB.Computer_Menu();
		
	//User to click on Notebook on Standard menu
	ComputersPage CP=new ComputersPage(driver);
	CP.clickNotebook();
	logger.info("Click on Notebooks link");
		
	//User to click on 'Add to cart' on Notebook page
	NotebooksPage NP=new NotebooksPage(driver);
	NP.AddNotebook_1();
	Thread.sleep(3000);
	logger.info("NoteBook added to the cart");
	
	//User validate the pop message after adding to cart on Notebook page
	String popMsg= SMB.Find_Test_on_PopUp();
	System.out.println(popMsg);
		
		logger.info("Validating expected message the product is added to shopping cart");
		if(popMsg.equals("The product has been added to your shopping cart"))
		{
			logger.info("Test Passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			Assert.fail();
		}
	
	//User clicks on the popup message to goto shopping cart
	SMB.shopping_cart_link_on_PopUp();
	
	ShoppingCartPage SCP = new ShoppingCartPage(driver);
	
	//User to select the terms of service checkbox
	SCP.ChkBxTermsOfService();
	
	//User to click on Checkout Button
	SCP.BtnChkOut_Click();
		
	OnePageCheckoutPage OPCP = new OnePageCheckoutPage(driver);
	
	//User to confirm the billing address
	OPCP.BtnContinueBilling();
	
	//User to confirm the Shipping address
	OPCP.BtnContinueShipping();
	
	//User to confirm the Shipping Method
	OPCP.BtnContinueShippingMethod();
	
	//User to confirm the Payment Method
	OPCP.RdBtnCreditCard();
	OPCP.BtnContinuePaymentMethod();
	Thread.sleep(2000);
	
	//User to confirm the Payment Information and click on Continue button
	OPCP.setCardholdername(p.getProperty("Cardholder_name"));
	OPCP.setCardnumber(p.getProperty("Card_number"));
	OPCP.setCardCode(p.getProperty("Card_Code"));
	OPCP.BtnContinuePaymentInfo();
		
	//User to confirm the order by click on confirm button
	OPCP.BtnConfirm();
	Thread.sleep(3000);
	
	//User to confirm the order message after purchasing the product.
	CompletedPage ComePage= new CompletedPage(driver);
	String ShpCrtMsg= ComePage.thankyouMessage();
	System.out.println(ShpCrtMsg);
		
		logger.info("Validating expected message after purchasing the product");
		if(ShpCrtMsg.equals("Your order has been successfully processed!"))
		{
			logger.info("Test Passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			Assert.fail();
		}
		
	}
	catch(Exception e)
	{
		Assert.fail();
	}	
		logger.info("******Finished TC_CO_001_Checkout_as_SignedIn_User******");
	}
}
