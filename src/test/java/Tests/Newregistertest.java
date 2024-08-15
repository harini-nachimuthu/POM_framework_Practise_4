package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basemethod.base;
import Pages.Homepage;
import Pages.Newregisterpage;
import Pages.loginpage;

public class Newregistertest extends base {
	
	@BeforeTest
	public void excelreads() {
		excelfile="Adactin_new_register";
		excelsheet="NewRegister";
	}
	//Adactin_new_register
	@Test(dataProvider="Readexcelfile")
	public void register(String username,String password,String re_password,String fullname,String email) throws InterruptedException {
		Homepage obj=new Homepage(driver);
		obj.homeregisterbtn()
		.newuser(username)
		.newpassword(re_password)
		.newrepassword(re_password)
		.newfullname(fullname)
		.newemail(email)
		.checkbox();
		
		Thread.sleep(1000);
		
		Newregisterpage regpage=new Newregisterpage(driver);
		regpage.submitregister();
		
		if(regpage.errorusername().equals("This username is alredy available") || regpage.email_add_span().equals("Email address is already in use") ) {
			regpage.loginpage();
			logintest logpage=new logintest(driver);
			logpage.login(username, password);
			System.out.println("User registered earlier so login is successfull...");
		}else {
			System.out.println("Registration is sucessfull...");
			System.out.println("After registration :"+regpage.gettingtext());
		}
		
		
	}
}
