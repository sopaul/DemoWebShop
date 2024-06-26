package utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

//import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
		// Below 3 classes are provided by ExtentReport
		public ExtentSparkReporter sparkReporter; // This class is responsible for the UI of the report(look & feel design)
		public ExtentReports extent; // Provide common info to the report
		public ExtentTest test; // For creating actual test in the report by updating the status and other information
		
		String repName;
		
		public void onStart(ITestContext testContext) // This method will create empty report/UI report
		{
			// to create a time stamp, 2 classes is used 'SimpleDateFormat' & 'Date'
				/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				  Date dt=new Date();
				  String currentdatetimestamp=df.format(dt);
				 */
			
			// since the above code has 3 steps , this can be achieved in 1 step as mentioned below
			
			String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
			
			repName="Test-Report-"+timeStamp+".html";
			sparkReporter= new ExtentSparkReporter(".\\reports\\"+repName); //'repName'Specify the location of the report along with the name
			/* Purpose of 'repName' : If the name of the report is hard coded, every time the program is run the report 
			 * is replaced with new report and hence cannot maintain the history of report which is mandatory to track 
			 * the traceability of the test performed. So for that purpose report is added with datetime stamp to maintain history.
			 */
			
			sparkReporter.config().setDocumentTitle("DemoWebShop Automation Report"); //Title of report
			sparkReporter.config().setReportName("DemoWebShop Functional Testing"); //name of the report
			sparkReporter.config().setTheme(Theme.STANDARD);
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application", "DemoWebShop");
			extent.setSystemInfo("Module", "Admin");
			extent.setSystemInfo("Sub Module", "Customers");
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Environemnt", "QA");
			
			//The below code takes parameter values of 'os' and 'browser' info from TestNG suite .xml file
			String os=testContext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System", os);
			
			String browser=testContext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);
			
			//The below code take groups info and displays in the report
			List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty())
			{
				extent.setSystemInfo("Groups", includedGroups.toString());
			}
		
		}
		
		public void onTestSuccess(ITestResult result)
		{
			test = extent.createTest(result.getTestClass().getName()); // This will display new testcase entry in the report
			test.assignCategory(result.getMethod().getGroups()); // To display groups in report
			test.log(Status.PASS,result.getName()+ " got sucessfully executed");
		}

		public void onTestFailure(ITestResult result) 
		{
			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			
			test.log(Status.FAIL,result.getName()+" got failed");
			test.log(Status.INFO, result.getThrowable().getMessage());
			
			try {
				String imgPath = new BaseClass().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgPath);
				
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		public void onTestSkipped(ITestResult result) 
		{
			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			
			test.log(Status.SKIP, result.getName()+" got skipped");
			test.log(Status.INFO, result.getThrowable().getMessage());
		}

		public void onFinish(ITestContext testContext) 
		{
			
			extent.flush();// This is a mandatory method for report to be generated.
			
			//The below code opens up the report automatically when the execution is done . This is optional
			String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
			File extentReport = new File(pathOfExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}


}
