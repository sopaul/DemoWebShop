package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	
public static WebDriver driver;
public Logger logger;// Predefined class which comes from log4j2
public Properties p; // used to access contents in the properties file
	
/*

@BeforeClass(groups={"sanity", "regression", "master"})
@Parameters({"os","browser"}) 
public void setup(String os,String br) throws IOException //Passing 'OS'and 'Browser' from TestNG.xml through @paramater annotation 
{
	//Loading Properties file
	FileReader file=new FileReader(".//src/test/resources/config.properties");
	p=new Properties();
	p.load(file);
	
	//Loading log4j2 file
	logger=LogManager.getLogger(this.getClass()); // getClass()returns the current(this) class name that is executed to generate logs.
	
	
	//launching browser based on condition - locally 
	switch(br.toLowerCase())
	{
	case "chrome": driver=new ChromeDriver();
	break;
	case "edge":driver=new EdgeDriver();
	break;
	default: System.out.println("No matching browser...");
	return;
	}
	
	
	driver.manage().deleteAllCookies(); //In order not to display default values from the previous run. 
									    //It is advisable to remove all the data stored in cookies, 
	                                    //so that a new test is run every time.
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("appURL")); // reading 'appURL' from the config.properties file
	driver.manage().window().maximize();
}

@AfterClass(groups={"sanity", "regression", "master"})
public void tearDown()
{
	//driver.close();
	driver.quit();
}

*/

	@SuppressWarnings("deprecation")
	@BeforeClass(groups={"sanity", "regression", "master"})
	@Parameters({"os","browser"}) 
	public void setup(String os,String br) throws IOException
	{
		//Loading Properties file
		FileReader file=new FileReader(".//src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		//Loading log4j2 file 
		logger=LogManager.getLogger(this.getClass()); //Log4j
		
		//URI url = URI.create(nodeURL).toURL();
		
		// The below code run for Selenium Grid (hub - node) based on the value passed from 
		//properties file is either 'remote' or 'local'
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else 
			{
				System.out.println("No matching os...");
				return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome"); 
			break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");
			break;
			default: System.out.println("No matching browser...");
			return;
			}
			
			//String nodeURL ="http://localhost:4444/wd/hub";
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			//Note : Instead is localhost , Local IP address can be added
		}
		else if (p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//Launching browser based on condition for cross browser & Parallel testing.
			switch(br.toLowerCase())
			{
			case "chrome":driver = new ChromeDriver();
			break;
			
			case "edge":driver = new EdgeDriver();
			break;
			
			default: System.out.println("No matching browser");
			return;         // if no matching browser found then the script is not executed.
			}	
		}
		
		
		driver.manage().deleteAllCookies(); //In order not to display default values from the previous run. 
									        //It is advisable to remove all the data stored in cookies, 
	                                        //so that a new test is run every time.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL")); // reading 'appURL' from the config.properties file
		driver.manage().window().maximize();
		System.out.println("Page Mazimized");
	}
	
	@AfterClass(groups={"sanity", "regression", "master"})
	
	public void tearDown()
	{
	 driver.quit();	
	}

	
	//Below method is provided by 3rd party outside Java which supports manipulation of data and other purposes
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5); //Creates random string of 5 Characters
		return generatedString;
	}
	
	//Below method is provided by 3rd party outside Java which supports manipulation of data and other purposes
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10); //Creates random string of 10 Characters
		return generatedString;
	}
	
	//Below method is provided by 3rd party outside Java which supports manipulation of data and other purposes
	public String randomeAlphaNumeric() //Creates random string of 3 Characters & random number of 3 Characters
	{
		String str=RandomStringUtils.randomAlphabetic(3); 
		String num=RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException 
	{

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}


