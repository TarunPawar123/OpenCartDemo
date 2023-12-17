package TestC;



import org.testng.annotations.Test;

import PageO.HomeP;

public class TC_01_login extends BaseC
{
	
	@Test
   public void lg()
   {
		
	   logger.info("***TC_01_login Start****");
	   HomeP p=new HomeP(driver);
		p.MyAcc();
		logger.info("Clicked on Account");
		p.login();
		logger.info("Clicked on Login");
		
		//p.username("hsv-rahulverma@yopmail.com");
		p.username(rb.getString("email"));
		logger.info("Entered Username successfully");
		//p.pass("Rdl@12345");
		p.pass(rb.getString("password"));
		logger.info("Successfully entered password");
		p.loginn();
		logger.info("Logged in successfully");
   }
}
