package OpenSource.Selenium;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExcelCommunication.ReadExcel; 
public class TestInitiate { 
	//public static ReportBuilder report= new ReportBuilder();
	@Test
  public static void TestCase_01() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException
	{
		ExecuteTest e= new ExecuteTest();
		e.executeTestMethod(2, 7);
	}
	@Test
  public static void TestCase_02() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException
	{		
		ExecuteTest e= new ExecuteTest();
		e.executeTestMethod(8, 13);
	}  
	@Test 
  public static void TestCase_03() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException
	{		
		ExecuteTest e= new ExecuteTest();
		e.executeTestMethod(14, 19);
	}
   @Test
  public static void TestCase_04() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException
	{		
		ExecuteTest e= new ExecuteTest();
		e.executeTestMethod(20, 25);
	}
   
}            
   
             