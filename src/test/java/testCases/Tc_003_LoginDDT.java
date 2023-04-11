package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;
import testBase.BaseClass;

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
   public  void test_LoginDDt(String email , String password, String exp)
    {
    	logger.info("*****Starting Tc_003_LoginDDT ***** ");
    	
    	try
       {
    	 
    	HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);//valid email get it from config.properties
		lp.setPassword(password);//valid password get it from config.properties
	    lp.clickLogin();
	   
 MyAccountPage macc=new MyAccountPage(driver);
	    
	    boolean targetpage =  macc.isMyAccountPageExists();
	    
	    if(exp.equals("Valid"))
	    {
	    	if(targetpage==true)
	    	{
	    		macc.clickLogout();
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    
	    if(exp.equals("Invalid"))
	    {
	    	if(targetpage==true)
	    	{
	    		macc.clickLogout();
	    		Assert.assertTrue(false);
	    	}
	     
	         else
    	    {
    		  Assert.assertTrue(true);
    	    }
	    }
       }
    	catch(Exception e)
    	{
    		Assert.fail();
    	}
	    logger.info("*****Finished Tc_003_LoginDDT ***** ");  
    }
}
