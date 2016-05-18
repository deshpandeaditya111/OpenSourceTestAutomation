package OpenSource.Selenium;
import Handlers.RadioHandler;
import Handlers.WindowHandler;
import Handlers.AlertHandler;
import Handlers.MouseHoverHandler;
import Handlers.DropDownHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;  
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;  


public class ReflectionClass {  
	public static Properties OR;
	 static ExtentReports extent;
	 static ExtentTest test;
	 
	//public static WebDriver driver; 
	
	ReflectionClass() throws IOException   
	{ 
		 
		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		//driver= new ChromeDriver();      
		FileInputStream fs = new FileInputStream("D:/WorkSpace/Selenium/src/test/java/Config/OR.properties");
		OR = new Properties(System.getProperties());
		OR.load(fs);
	}    
	  
	public static void callMethods(String Action, String Property, String PropertyValue, String RealValue, ReportBuilder ext, RemoteWebDriver driver) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
	
		Method methods =  ReflectionClass.class.getMethod(Action, String.class,String.class,String.class, ReportBuilder.class,RemoteWebDriver.class);
	    methods.invoke(Action,Property, PropertyValue,RealValue,ext,driver);
	}
		
	public static void getURL(String Property,String PropertyValue, String RealValue, ReportBuilder ext,RemoteWebDriver driver) throws IOException
 	{
	     try{
	    	 
			  driver.get(OR.getProperty(RealValue));
		      String ExpectedTitle="aaaaaaaa";
		      String ActualTitle= driver.getTitle(); 
		      
		 	}
		catch(Exception e) 
		{
			   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		       FileUtils.copyFile(scrFile, new File("D:\\screenshotNew.png"));
		}
 	}
	
	
  public static void enterText(String Property,String PropertyValue, String RealValue, ReportBuilder ext,RemoteWebDriver driver) throws IOException
	{
		
		    if(Property.equalsIgnoreCase("name")) 
		     {
		    	try{ 
		    	    driver.findElement(By.name(OR.getProperty(PropertyValue))).sendKeys(OR.getProperty(RealValue)); 
                   
                    } 
		    	catch(Exception e) 
				{ 
					 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			         
		             FileUtils.copyFile(scrFile, new File("D:\\screenshotNew1.png"));
				} 
	          }
		    

		    else if(Property.equalsIgnoreCase("xpath")) 
		     {
		    	try{ 
		    	    driver.findElement(By.xpath(OR.getProperty(PropertyValue))).sendKeys(OR.getProperty(RealValue)); 
                   
                    } 
		    	catch(Exception e) 
				{ 
					 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			         
		             FileUtils.copyFile(scrFile, new File("D:\\screenshotNew1.png"));
				} 
	          }
		    

		    else  if(Property.equalsIgnoreCase("id")) 
		     {
		    	try{ 
		    	    driver.findElement(By.id(OR.getProperty(PropertyValue))).sendKeys(OR.getProperty(RealValue)); 
                   
                    } 
		    	catch(Exception e) 
				{ 
					 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			         FileUtils.copyFile(scrFile, new File("D:\\screenshotNew1.png"));
				} 
	          }
		 
	}   
   
	public static  void verifyLogIn(String Property,String PropertyValue, String RealValue,ReportBuilder ext,RemoteWebDriver driver) throws IOException
	{
		System.out.println("I am inside Verify LogIn");

		 String ExpectedTitleLogin= "Find a Flight: Mercury Tours:";
		System.out.println("Actual Title is"+driver.getTitle());
		 try
		 {
			 if(driver.getTitle().equals(ExpectedTitleLogin))
			 {
		       ext.DisplayResult("Pass", "verifyLogIn", "RegressionTest--LogIn");
			 }
			 else
			 {
		      ext.DisplayResult("Fail", "verifyLogIn", "RegressionTest--LogIn");
			 }
		 }
		catch(Exception e)
		 {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         FileUtils.copyFile(scrFile, new File("D:/screenshotNew2.png"));
	         ext.DisplayResult("Fail", "verifyLogIn", "RegressionTest->verifyLogIn");
		 }
		
	}    
	 
	public static void selectRadio(String Property,String PropertyValue, String RealValue,ReportBuilder ext,RemoteWebDriver driver)
	{
		RadioHandler rdo= new RadioHandler();
		if(Property.equals("name")) 
		{
			rdo.selectRadiobuttonByName(driver, PropertyValue, RealValue);
		 
		}  
		else if(Property.equals("xpath"))
		{
		  
		 rdo.selectRadiobuttonByxpath(driver, PropertyValue, RealValue);
		}
		
	}
	public static void selectDropDown(String Property,String PropertyValue, String RealValue,ReportBuilder ext,RemoteWebDriver driver)
	{
		DropDownHandler drp = new DropDownHandler();
		if(Property.equals("name"))
		{
			drp.selectDropDownValueByName(driver, PropertyValue, RealValue);
		}
		else if(Property.equals("xpath"))
		{
			drp.selectDropDownValueByXpath(driver, PropertyValue, RealValue);
		} 
		 
	}  
	
	public static void clickButton(String Property,String PropertyValue, String RealValue,ReportBuilder ext,RemoteWebDriver driver)
	{  
		if(Property.equals("name"))   
		{    
		 driver.findElement(By.name(OR.getProperty(PropertyValue))).click();
		 }
		else if(Property.equals("xpath"))  
		{ 
		 driver.findElement(By.xpath(OR.getProperty(PropertyValue))).click();
		 }
		else if(Property.equals("id"))  
		{ 
		 driver.findElement(By.id(OR.getProperty(PropertyValue))).click();
		 }
				 
	} 	   
	
	public static void selectSecondWindow(String Property,String PropertyValue, String RealValue,ReportBuilder ext,RemoteWebDriver driver) throws InterruptedException
	{
		WindowHandler wnd= new WindowHandler(); 
		wnd.selectWindow(driver, PropertyValue, RealValue);	
	}  
	
	public static void alertHandling(String Property,String PropertyValue, String RealValue,ReportBuilder ext,RemoteWebDriver driver)
	{
		AlertHandler alrt= new AlertHandler(); 
		alrt.alerthandle(driver, PropertyValue, RealValue); 
	}
	
	public static void mouseHover(String Property,String PropertyValue, String RealValue,ReportBuilder ext,RemoteWebDriver driver)
	{
		if(Property.equals("xpath"))  
		{ 
			MouseHoverHandler mhndl= new MouseHoverHandler();
			mhndl.mouseHandling(driver, PropertyValue, RealValue); 
		}
	} 

}     
      
       

