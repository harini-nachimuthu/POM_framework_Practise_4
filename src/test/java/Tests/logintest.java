package Tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Basemethod.base;
import Pages.Homepage;
import Pages.loginpage;

public class logintest extends base{

	public logintest(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@BeforeTest
	public void excelreads() {
		excelfile="Adactin_new_register";
		excelsheet="Login";
	}
	
	@Test(dataProvider="Readexcelfile")
	public void login(String username,String password) {
		Homepage obj1=new Homepage(driver);
		obj1.homeloginusername(username);
		obj1.homeloginpassword(password);
		loginpage log=new loginpage(driver);
		log.loginbtn();
		
		
		if(log.readerror().equals("Error: Pending Email Verification")) {
			System.out.println("Error message received is : "+log.readerror());
		}else {
			System.out.println("login is successfull");
		}
	}

	
}
