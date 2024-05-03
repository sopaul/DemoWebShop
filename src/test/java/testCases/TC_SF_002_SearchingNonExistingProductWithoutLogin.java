package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC_SF_002_SearchingNonExistingProductWithoutLogin extends BaseClass

{	@Test(groups={"regression", "master"})
	public void SearchingProduct()
	{
	
	logger.info("******Starting TC_SF_002_SearchingNonExistingProductWithoutLogin******");
	logger.debug("Capturing application debug logs....");
	
	try
	{
	// Home Page
	HomePage hp=new HomePage(driver); // Create an object from HomePage page object class
	hp.setSearchText(p.getProperty("NonExitProduct"));
	hp.clickSearch();
	Thread.sleep(2000);
	
	SearchResultPage SRP=new SearchResultPage(driver);
	String popMsg= SRP.ResultPageMsg();
	System.out.println(popMsg);
	
	logger.info("Validating expected message if a nonexisting product is searched");
	if(popMsg.equals("No products were found that matched your criteria."))
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
		
		logger.info("******Finished TC_SF_002_SearchingNonExistingProductWithoutLogin******");
	}
}

