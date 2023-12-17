package TestC;


import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import PageO.HomeP;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseC
{
	public ResourceBundle rb;
	public static WebDriver driver;
    public  Logger logger;
	@BeforeClass
	@Parameters("browser")
	public  void main(String br)
	{
		rb=ResourceBundle.getBundle("Config");
		//ChromeOptions option=new ChromeOptions();
		//option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		logger=LogManager.getLogger(this.getClass());
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.edgedriver().setup();
		// driver=new EdgeDriver();
		//driver=new ChromeDriver(option);
		
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//driver.get("https://demo.opencart.com/");
		driver.get(rb.getString("appURL"));		
		
	}
	
	public String captureScreen(String tname)
	{
		// java.txt
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		//java.util
		Date dt=new Date();
		String timestamp=df.format(dt);
		
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		//import java.io.File;
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshot\\"+tname+"_"+timestamp+".png";
		try
		{
			//org.apache.commons.io.FileUtils;
			FileUtils.copyFile(source, new File(destination));
			
		}
		catch(Exception e)
		{
			e.getMessage();
			
		}
		return destination;
	}

}
