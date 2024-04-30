package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;



public class TC_RF_003_AccountRegistrationwithIncorrectSucessMsg extends BaseClass
{
	
	
	@Test(groups={"regression", "master"})
	public void verify_account_registration()
	{
		logger.info("******Starting TC_RF_003_AccountRegistrationwithIncorrectSucessMsg******");
		
		logger.debug("Capturing application debug logs....");
		try 
		{
		HomePage hp=new HomePage(driver); // Create an object from HomePage page object class
		hp.clickRegister();
		logger.info("Clicked on registration link");
		
		logger.info("Entering customer info");
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());//Randomly generated FirstName
		regpage.setLastName(randomeString().toUpperCase());//Randomly generated LastName
		regpage.setEmail(randomeString()+"@gmail.com"); //Randomly generated email
		
		String password=randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.clickRegister();
		logger.info("clicked on Register button..");
		
		String confmsg=regpage.getConfirmationMsg(); // To Validate the success message
		logger.info("Validating expected message..");
			if(confmsg.equals("Your registration"))
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
			logger.error("Test Failed....");
			Assert.fail();
		}
		
		logger.debug("Capturing application debug logs end....");
		logger.info("******Finished TC_RF_003_AccountRegistrationwithIncorrectSucessMsg******");
	}
	
	
}
