package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
    @Test(groups= {"Regression","Master"})
	public void test_account_Registration() {
    	
    	try {
		
    	logger.debug("Application logs..........");	
        logger.info("****Starting TC_001_AccountRegistrationTest*****");
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		
		logger.info("clicked my account");
		
		hp.ClickRegister();
		
		logger.info("clicked my Registration");
		
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		
		logger.info("providing customer data");
		repage.setFirstName(randomString());
		repage.setLastName(randomString());
		repage.setEmail(randomString()+ "@gmail.com");
		repage.setPassword(randomAlphaNumeric());
		repage.setPrivacypolicy();
		repage.clickContinue();
		
		logger.info("clicked on continue");
		
		String confmsg = repage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		logger.info("validating expected message");
	}
    	
    	catch(Exception e) {
    		
    		logger.error("test failed");
    		Assert.fail();
    	}
    	
    	logger.info("****Finished TC_001_AccountRegistrationTest*****");
    }
	
}
