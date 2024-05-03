/**
 * 
 */
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


/**
 * 
 */
public class TC_LG_001_Logout_Functionality  extends BaseClass
{  
	@Test(groups={"sanity", "master"})
	public void verify_login()
	{
	
	logger.info("******Starting TC_LG_001_Logout_Functionality ******");
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
	boolean logout_lnk=macc.isMyAccountPageLogoutTextExists();// Checking if logout link exist
	
	
		if(targetPage==true)
			{
			
			if(logout_lnk=true)
				{
				macc.clickLogout();// user to Logout 
				Assert.assertTrue(true);
				}
				else
				{
				logger.error("Logout test failed");
				Assert.fail();
				}
			}
		else
			{
			logger.error("Login test failed");
			Assert.fail();
			}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	 
	
		logger.info("******Finished TC_LG_001_Logout_Functionality ******");
	}
}
