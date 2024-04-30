package pageObjects;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);  // invoke parent class (BasePage) constructors
	}
	
	//Web Elements / Locators
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement radioGender;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
		
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@id='register-button']")
	WebElement btnRegister;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement msgConfirmation;
	
	// Below web elements are used for error warning messages
	
	@FindBy(xpath="//span[@for='FirstName']")
	WebElement first_name_warn_msg_Confirmation;
	
	@FindBy(xpath="//span[@for='LastName']")
	WebElement last_name_warn_msg_Confirmation;
	
	@FindBy(xpath="//span[@for='Email']")
	WebElement email_warn_msg_Confirmation;
	
	@FindBy(xpath="//span[@for='Password']")
	WebElement pwd_warn_msg_Confirmation;
	
	@FindBy(xpath="//span[@for='ConfirmPassword']")
	WebElement conf_pwd_warn_msg_Confirmation;
	
	
	
	// Action Methods
	
	public void setGender()
	{
		radioGender.click();
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void clickRegister()
	{
		//sol 1
		btnRegister.click();
		
		//sol 2
		//btnRegister.submit();
		
		//sol 3
		//Action act=new Action(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//sol 4
		//JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",btnContinue);
		
		//sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//sol 6
		//WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}
	
	public String getConfirmationMsg() 
	{
		try
		{
			return (msgConfirmation.getText());
		}catch (Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	public String FirstNamegetWarnConfirmationMsg() 
	{
		try
		{
			return (first_name_warn_msg_Confirmation.getText());
		}catch (Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	public String LastNamegetWarnConfirmationMsg() 
	{
		try
		{
			return (last_name_warn_msg_Confirmation.getText());
		}catch (Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	public String EmailgetWarnConfirmationMsg() 
	{
		try
		{
			return (email_warn_msg_Confirmation.getText());
		}catch (Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	public String PasswordgetWarnConfirmationMsg() 
	{
		try
		{
			return (pwd_warn_msg_Confirmation.getText());
		}catch (Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	public String ConfPasswordgetWarnConfirmationMsg() 
	{
		try
		{
			return (conf_pwd_warn_msg_Confirmation.getText());
		}catch (Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	
}
