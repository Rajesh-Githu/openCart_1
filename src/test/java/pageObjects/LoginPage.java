package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	  @FindBy(xpath="//input[@id='input-email']")
	   WebElement txtEmailAddress;
	   
	   @FindBy(xpath="//input[@id='input-password']")
	   WebElement txtPassWord;
	   
	   @FindBy(xpath="//button[normalize-space()='Login']")
	   WebElement btnLogin;
	   
	  // Acton Methods
	   public void setEmail(String email) {
		   
		   txtEmailAddress.sendKeys(email);
	   }
	   public void setPassword(String pwd) {
		   
		   txtPassWord.sendKeys(pwd);
		 	   
	   }
      public void ClickLogin() {
		   
    	  btnLogin.click(); 
	
      }
}

	
	


