package OpenSource.Selenium;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ExcelCommunication.ReadExcel;

public class ExecuteTest {
	public static RemoteWebDriver driver;
	
	// @Parameters({"browser"})
	@BeforeTest
	public void initiateDriver() throws MalformedURLException
	{
		DesiredCapabilities dr=null;
			// System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		   	 dr= DesiredCapabilities.firefox();
			dr.setBrowserName("firefox");
			 dr.setPlatform(Platform.VISTA);
			 driver=new RemoteWebDriver(new URL("http://10.4.3.36:5555/wd/hub"), dr);
	}
	
	public static ReportBuilder report= new ReportBuilder();
	public void executeTestMethod(int p, int q) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		List<String> listFromExcel= new ArrayList<String>();
		HashMap<String, List<String>> mapFromExcel= new HashMap<String, List<String>>();
		ReadExcel myobj= new ReadExcel();  
		mapFromExcel=myobj.readExcel(); 
		ReflectionClass r= new ReflectionClass();
		for (int i=p; i<=q; i++)        
		{	
			listFromExcel = mapFromExcel.get("STEP_0"+i);   
			report.StartTestCase(listFromExcel.get(0), listFromExcel.get(0), "Regression");		
			if(listFromExcel.get(1).isEmpty())
			 {
				System.out.println("Starting Test Case:"+listFromExcel.get(0));
			 }
			else
			{		
				ReflectionClass.callMethods(listFromExcel.get(2), listFromExcel.get(3),listFromExcel.get(4),listFromExcel.get(5),report,driver);   
			}
		}  
		report.endTest();
		report.CloseReport();
	}
}
