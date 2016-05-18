package ExcelCommunication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

public class ReadExcel {
	private static org.apache.poi.ss.usermodel.Cell Cell;
	static HashMap<String , List<String>> mymap= new HashMap<String , List<String>>();
	
	public HashMap<String , List<String>> readExcel() throws IOException 
	{
		System.out.println("I am inside");
				 
		File myfile = new File("D:/WorkSpace/Selenium/src/test/java/DataEngine/Data_Sheet.xls");
		
		int count=0;   
		 
		try 
		{
			FileInputStream streamobject = new FileInputStream(myfile);				
			HSSFWorkbook myworkbook = new HSSFWorkbook (streamobject);
			Row myrow;   
		    Sheet mysheet = myworkbook.getSheet("TestCases");
		    
		   
		    for(int i=2; i<=(mysheet.getLastRowNum()-mysheet.getFirstRowNum());i++)
		    { 
		    	myrow = mysheet.getRow(i); 
		    	List<String> mylist= new ArrayList<String>();// always new list is created 
		    	    	
		    	for(int j=1; j<((myrow.getLastCellNum()-myrow.getFirstCellNum())+1);j++)
		    	{ 
		    		 mylist.add(myrow.getCell(j).getStringCellValue());
		    	//myrow.getCell(i).getNumericCellValue(); if u want to read number from excel.
		    	
		    	}
		   
		    	   mymap.put("STEP_0" +i, mylist);
		   		        
		    }    
		    
		}
		catch(FileNotFoundException e)  
		{
			e.printStackTrace();
		}
		//	System.out.println(mymap);
		return mymap;

	}


}
