package com.freeCRM.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	String excelPath = "E:\\Projects\\FreeCRM\\src\\main\\java\\com\\freeCRM\\testData\\TestData.xlsx";
	
	
	public void ReadLoginData(String excelPath) throws IOException
	{
		Workbook wb = null;
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		String ext = excelPath.substring(excelPath.indexOf("."));
		Sheet Worksheet;
		
		if(ext.equalsIgnoreCase(".xlsx"))
		{
			wb = new XSSFWorkbook(fis);
		}
		else
			if(ext.equalsIgnoreCase(".xsl"))
			{
				wb = new HSSFWorkbook(fis);
			}
		
		Worksheet = wb.getSheet("LoginTest");
		
		int firstRow = Worksheet.getFirstRowNum();
		int lastRow = Worksheet.getLastRowNum();
		
		for(int i = 0; i < lastRow; i++)
		{
			Row row = Worksheet.getRow(i);
			for(int j = 0; j < row.getLastCellNum(); j++)
			{
				
			}
		}
		
	}
	public static void main(String args[])
	{
		ReadExcel r = new ReadExcel();
		//System.out.println("First cell no :"+ Works);
	}

}
