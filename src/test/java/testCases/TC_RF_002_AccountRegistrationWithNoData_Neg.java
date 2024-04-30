package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_002_AccountRegistrationWithNoData_Neg  extends BaseClass
{
	@Test(groups={"regression", "master"})
	public void verify_account_registration_no_data()
	{
		logger.info("******Starting TC_RF_002_AccountRegistrationWithNoData_Neg******");
		
		logger.debug("Capturing application debug logs....");
		
		HomePage hp=new HomePage(driver); // Create an object from HomePage page object class
		hp.clickRegister(); // Clicked on Register link on home page
		logger.info("Clicked on registration link");
		
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		regpage.clickRegister(); // Clicked on Register button on Account page
		logger.info("clicked on Register button..");
		
		String FirstNameconfmsg=regpage.FirstNamegetWarnConfirmationMsg(); // To Validate the success FirstName warn message
		logger.info("Validating expected First Name warning message..");
		
		if(FirstNameconfmsg.equals("First name is required."))
		{
			logger.info("Firstname warn message displayed - Test Passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("First Name warn message not displayed - Test Failed..");
			Assert.fail();
		}
		
		String LastNameconfmsg=regpage.LastNamegetWarnConfirmationMsg(); // To Validate the success LastName warn message
		logger.info("Validating expected Last Name warning message..");
		
		if(LastNameconfmsg.equals("Last name is required."))
		{
			logger.info("Last Name warn message displayed - Test Passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Last Name warn message not displayed - Test Failed..");
			Assert.fail();
		}
		
		String Emailconfmsg=regpage.EmailgetWarnConfirmationMsg(); // To Validate the success Email warn message
		logger.info("Validating expected Email warning message..");
		
		if(Emailconfmsg.equals("Email is required."))
		{
			logger.info("Email warn message displayed - Test Passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Email warn message not displayed - Test Failed..");
			Assert.fail();
		}
		
		String Pwdconfmsg=regpage.PasswordgetWarnConfirmationMsg(); // To Validate the success Password warn message
		logger.info("Validating expected Password warning message..");
		
		if(Pwdconfmsg.equals("Password is required."))
		{
			logger.info("Password warn message displayed - Test Passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Password warn message not displayed - Test Failed..");
			Assert.fail();
		}
		
		String ConfPwdconfmsg=regpage.ConfPasswordgetWarnConfirmationMsg(); // To Validate the success Confirm Password warn message
		logger.info("Validating expected Confim Password warning message..");
		
		if(ConfPwdconfmsg.equals("Password is required."))
		{
			logger.info("Confirm Password warn message displayed - Test Passed..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Confirm Password warn message not displayed - Test Failed..");
			Assert.fail();
		}
	
	}
}
