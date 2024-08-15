package Utility;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFChartSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utils {
	
	protected WebDriver driver;
	public String excelfile;
	public String excelsheet;
	
	public void launchbrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
	}
	
	public void launchurl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void webwaitdriver(WebElement element,int sec) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickbtn(WebElement element) {
		element.click();
	}
	
	public void idandsendkeys(String idname,String name) {
		driver.findElement(By.id(idname)).sendKeys(name);
	}
	
	public void xpathsend(String xpathname) {
		driver.findElement(By.xpath(xpathname));
	}
	
	public void closebrowser() {
		driver.close();
	}
	
	public void quitbrowser() {
		driver.quit();
	}
	
	public String[][] excelread(String excelfile,String excelsheet) throws IOException{
		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\harin\\eclipse-workspace\\Adactin_POM_hotel\\Excelsheet\\"+excelfile+".xlsx");
		XSSFSheet sheet=book.getSheet(excelsheet);
		int rowcount=sheet.getLastRowNum();
		int cellcount=sheet.getRow(0).getLastCellNum();
		String[][] exceldatas=new String[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++) {
			XSSFRow rownum=sheet.getRow(i);
			for(int j=0;j<cellcount;j++) {
				XSSFCell cellnum=rownum.getCell(j);
				exceldatas[i-1][j]=cellnum.getStringCellValue();
			}
		}
		book.close();
		return exceldatas;
		
	}
	
}
