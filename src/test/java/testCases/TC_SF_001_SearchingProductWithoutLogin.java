package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

import testBase.BaseClass;

public class TC_SF_001_SearchingProductWithoutLogin extends BaseClass

{	@Test(groups={"regression", "master"})
	public void SearchingProduct()
	{
	
	logger.info("******Starting TC_SF_001_SearchingProductWithoutLogin******");
	logger.debug("Capturing application debug logs....");
	
	try
	{
	// Home Page
	HomePage hp=new HomePage(driver); // Create an object from HomePage page object class
	hp.setSearchText(p.getProperty("SearchProductName"));
	hp.clickSearch();
	Thread.sleep(2000);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
		
		logger.info("******Finished TC_SF_001_SearchingProductWithoutLogin******");
	}
}
