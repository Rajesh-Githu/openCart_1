package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	
	public AccountRegistrationPage(WebDriver driver){
		
		super(driver);
	}
	
	
	@FindBy(name = "First Name")
	WebElement txtFirstName; 
	@FindBy(name = "Last Name")
	WebElement txtLastName;
	@FindBy(name = "E-Mail")
	WebElement txtEmail;
	@FindBy(name = "Password")
	WebElement txtPassword;
	@FindBy(name = "agree")
	WebElement chkdpolicy;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btncontinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		
		txtFirstName.sendKeys(fname);
		
	}
	
	public void setLastName(String lname) {
		
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		
		txtEmail.sendKeys(email);
	
	}
	
	public void setPassword(String Password) {
		
		txtPassword.sendKeys(Password);
		
	}
	
	public void setPrivacypolicy() {
		
		chkdpolicy.click();
		
	}
	
	public void clickContinue() {
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btncontinue);
	
		
	}
    
	public String getConfirmationMsg() {
		
		try {
			
			return(msgConfirmation.getText());
		}
		
		catch (Exception e) {
			
			return(e.getMessage());
		}
	}
}
