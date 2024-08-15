package Basemethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import Utility.utils;

public class base extends utils{
	
	@BeforeMethod
	public void lanunchingbrowserandurl() {
		launchbrowser("chrome");
		launchurl("https://adactinhotelapp.com/");
	}
	
	@AfterMethod
	public void closedriver() {
		closebrowser();
	}
	
	@DataProvider(name="Readexcelfile")
	public String[][] readexcel() throws IOException{
		String[][] excelread=excelread(excelfile,excelsheet);
		return excelread;
	}
}
