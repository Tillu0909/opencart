package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass
{
    
    @Test(groups= {"Regression","Master"})
    void test_account_Registration() throws InterruptedException
  {
    	logger.debug("appication logs.....");
    	
    	logger.info("*** Staring TC_001_AccountRegistrationTest***");
   try
  {
    	HomePage hp=new HomePage(driver);
    	hp.clickMyAccount();
    	logger.info("Clicked on MyAccount link");
    	hp.clickRegister();
    	logger.info("Clicked on register link");
    	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
    	logger.info("Providing customer data");
    	
        regpage.setFirstName(randomeString().toUpperCase());
        
        regpage.setLastName(randomeString().toUpperCase());
        
        regpage.setEmail(randomeString()+"@gmail.com");//randomly generated the email
        
        
        String password=randomeAlphaNumeric();
        regpage.setPassword(password);
        
        regpage.setPrivacyPolicy();
        
        regpage.clickContinue();
        
        logger.info("Clicked on continue");
       
        String confmsg=regpage.getConfirmationMsg();
       
        logger.info("Validating expected message");
        Assert.assertEquals(confmsg, "Your Account Has Been Created!","not getting expected message");
    
   }
    catch(Exception e)
    {
    	logger.error("test faileed");
    	Assert.fail();
    }
       logger.info("*** finished TC_001_AccountRegistrationTest***" );
    }
    
    
    
    
    
    
}
