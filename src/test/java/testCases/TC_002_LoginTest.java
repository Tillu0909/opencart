package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		try
		{
		
		logger.info("Staring TC_002_LoginTest *******");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my Account");
		hp.clickLogin();
		logger.info("Clicked on my Login link");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing Login details on my Account");
		lp.setEmail(rb.getString("email"));//valid email get it from config.properties
		lp.setPassword(rb.getString("password"));//valid password get it from config.properties
	    lp.clickLogin();
	    logger.info("Clicked on Login button ");
	    MyAccountPage macc=new MyAccountPage(driver);
	    
	    boolean targetpage =  macc.isMyAccountPageExists();
	    
	    Assert.assertEquals(targetpage, true,"invali Login data ");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****Finished TC_002_LoginTest *****");
	}
	
	
	
	
	
}
