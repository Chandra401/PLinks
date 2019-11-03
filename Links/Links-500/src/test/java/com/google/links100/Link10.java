package com.google.links100;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.excelreader.ExcelReader;
import com.google.objectreader.ObjectReader;
import com.google.utility.Utility;

public class Link10 {
	ExcelReader e;ObjectReader o;WebDriver links;
@BeforeTest
public void setUP() {
	e=new ExcelReader("./ExcelRepository/PopularLinksList.xlsx");
	o=new ObjectReader();
	System.setProperty("webdriver.chrome.driver", o.chromePath());
	links=new ChromeDriver();
	links.manage().window().maximize();	
}
@Test
public void navigateURL() {
	Utility.wait_Statement(3000);
	links.get(e.getExcelData(0, 10, 1));
	Utility.wait_Statement(3000);
    Utility.screenShots(links, "10.link10-Homepage");
}
@AfterMethod
public void tearDown(ITestResult fail) {
if(ITestResult.FAILURE==fail.getStatus()) {
	Utility.screenShots(links, fail.getName());
}
}
@AfterTest
public void CloseBrowser() throws Exception{
Thread.sleep(3000);	
links.quit();	
}
}