package PageO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

//import TestC.BaseC;

public class HomeP extends BasePage
{
     public HomeP(WebDriver driver)
     {
    	 super(driver);
     }
   
    @FindBy(xpath="//span[normalize-space()='My Account']")  
    WebElement myAcc;
    @FindBy(xpath="//a[normalize-space()='Login']")
    WebElement log;
    @FindBy(xpath="//input[@id='input-email']")
    WebElement EMail;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement pwd;
    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement logi;
	public void MyAcc()
	{
		myAcc.click();
		System.out.println("Clicked on My Account");
	}
	public void login()
	{
		log.click();
	}
	public void username(String name)
	{
		EMail.sendKeys(name);;
	}
	public void pass(String name)
	{
		pwd.sendKeys(name);	
	}
	public void loginn()
	{
		logi.click();
	}
}
