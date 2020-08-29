package com.vtiger.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.vtiger.utilities.Xls_Reader;

public class BaseMethods {
	
	public static void main(String[] args)
	{
		MapintoList();
	}
	
	public static void ListintoList()
	{
		Map<String,String> map ;
		List<List> dtlst = ReadExcelData(System.getProperty("user.dir")+"/src/test/java/com/vtiger/testdata/TestData.xlsx", "TCdata");
		for(List ls:dtlst)
		{
			
			for(int i=0;i<ls.size();i++)
			{
				System.out.println(ls.get(i)+"   ");
				
			}
		}
	}
	
	public static void MapintoList()
	{
		Map<String,String> map ;
		List<Map> dtlst = ReadExcelDataMap(System.getProperty("user.dir")+"/src/test/java/com/vtiger/testdata/TestData.xlsx", "TCdata");
		for(Map<String,String> m:dtlst)
		{
			
			for(Map.Entry<String,String> entry : m.entrySet())
			{
				System.out.println("Key = " + entry.getKey() + 
                        ", Value = " + entry.getValue());				
			}
			System.out.println("=========================================");
		}
	}
	
	public static List<List> ReadExcelData(String ExcelFile, String SheetName)
	{
		Map<String,String> map;
		Xls_Reader xr = new Xls_Reader(ExcelFile);
		int rowCount = xr.getRowCount(SheetName);
		int colCount = xr.getColumnCount(SheetName);
		List<List> lst = new ArrayList<List>();
		List<String> Sublst = null ;
		for(int i=1;i<=rowCount;i++)
		{
			Sublst = new ArrayList<String>();
			for(int j=0;j<=colCount;j++)
			{
				String cellVal = xr.getCellData(SheetName, j, i).trim();
				//System.out.print(cellVal + "  ");
				Sublst.add(cellVal);
			}
			lst.add(Sublst);
			//System.out.println("");
		}
		return lst;
	}
	
	public static List<Map> ReadExcelDataMap(String ExcelFile, String SheetName)
	{
		Map<String,String> map;
		Xls_Reader xr = new Xls_Reader(ExcelFile);
		int rowCount = xr.getRowCount(SheetName);
		int colCount = xr.getColumnCount(SheetName);
		List<Map> lst = new ArrayList<Map>();
		Map<String,String> mp = null ;
		for(int i=1;i<=rowCount;i++)
		{
			mp = new LinkedHashMap<String,String>();
			for(int j=0;j<colCount;j++)
			{
				String ColName = xr.getCellData(SheetName, j, 1).trim();
				String cellVal = xr.getCellData(SheetName, j, i).trim();
				//System.out.print(cellVal + "  ");
				mp.put(ColName, cellVal);
			}
			lst.add(mp);
			//System.out.println("");
		}
		return lst;
	}
	
	
	//Creating a method getScreenshot and passing two parameters 
	//driver and screenshotName
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	                //below line is just to append the date format with the screenshot name to avoid duplicate names		
	                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
	                //Returns the captured file path
			return destination;
	}

}
