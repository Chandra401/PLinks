package com.google.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wbk;XSSFSheet sheets;Cell cv;String data;
	public ExcelReader(String filePath){
		try{
		File file=new File(filePath);
		FileInputStream fis=new FileInputStream(file);
		wbk=new XSSFWorkbook(fis);
		sheets=wbk.getSheetAt(0);
		Iterator<Row>rows=sheets.rowIterator();
		while(rows.hasNext()){
			Row firstrow=rows.next();
			Iterator <Cell>ce=firstrow.cellIterator();
			while(ce.hasNext()){
				cv=ce.next();
			}
		}
		}catch(Exception e){
			System.out.println("The Uncaught Exception is=="+e.getMessage());
		}
	}
	public String getExcelData(int sheetNum,int rowNum,int colNum){
		String data=sheets.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
}
