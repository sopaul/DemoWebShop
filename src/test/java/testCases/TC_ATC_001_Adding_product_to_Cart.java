package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComputersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.NotebooksPage;
import pageObjects.Standard_Menu_Bar;
import testBase.BaseClass;

public class TC_ATC_001_Adding_product_to_Cart extends BaseClass
{
	@Test(groups={"regression", "master"})
	public void verify_login()
	{
	
	logger.info("******Starting TC_ATC_001_Adding_the_product_to_Cart******");
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
		
	}
	catch(Exception e)
	{
		Assert.fail();
	}	
		logger.info("******Finished TC_ATC_001_Adding_the_product_to_Cart******");
	}
}
