package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_LF_002_003_004_LoginDDT extends BaseClass
{
	
	@Test(groups={"regression", "master"},dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password , String exp)
	{
		logger.info("******Starting TC_LF_002_003_004_LoginDDT******");
		logger.debug("Capturing application debug logs....");
		
		  try {
			
					// Accessing Home page, page object.
					HomePage hp=new HomePage(driver);
										
					// HomePage login link 
					hp.clickLogin();
					logger.info("Clicked on Login link");
					
					// Accessing Login page, page object.
					LoginPage lp=new LoginPage(driver);
					
					// Enter email id in the login page from Excel file DemoWebShop_LoginData.xlsx' under testdata folder
					logger.info("Entering valid email id..");
					lp.setEmail(email);
					
					// Enter password in the login page from Excel file DemoWebShop_LoginData.xlsx' under testdata folder
					logger.info("Entering valid password..");
					lp.setPassword(password);
					
					// Click on Login button in the login page
					logger.info("Clicked on Login button..");
					lp.clickLogin();
					
					// Accessing My Account page, page object.
					MyAccountPage MyAP=new MyAccountPage(driver);
					boolean targetPage=MyAP.isMyAccountPageLogoutTextExists();
					
					if(exp.equalsIgnoreCase("Valid"))// To validate positive scenarios with valid data from DemoWebShop_LoginData.xlsx
					{
						if(targetPage==true)
						{
							MyAP.clickLogout();
							Assert.assertTrue(true);// Test Passed
							logger.info("Test Passed..");
						}
						else
						{
							Assert.assertTrue(false);// Test Failed
							logger.info("Test Failed..");
						}
					}
					
					if(exp.equalsIgnoreCase("Invalid"))// To validate negative scenarios with invalid data from DemoWebShop_LoginData.xlsx
					{
						if(targetPage==true)
						{
							MyAP.clickLogout();
							Assert.assertTrue(false);// Test Failed
							logger.info("Test Failed..");
						}
						else
						{
							Assert.assertTrue(true);// Test Passed
							logger.info("Test Passed..");
						}
					}

		    }
			catch (Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
			logger.info("******Finished TC_LF_002_003_004_LoginDDT******");
	}
}
