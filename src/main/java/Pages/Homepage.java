package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basemethod.base;

public class Homepage extends base{
	
	//new user register link
	//a[@href='Register.php']
	
	@FindBy(xpath="//a[@href='Register.php']")
	WebElement homeregistrationlink;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public Newregisterpage homeregisterbtn() {
		clickbtn(homeregistrationlink);
		return new Newregisterpage(driver);
		
	}
	
	@FindBy(id="username")
	WebElement loginusername;
	
	public loginpage homeloginusername(String name) {
		idandsendkeys("username",name);
		return new loginpage(driver);
	}
	
	@FindBy(id="password")
	WebElement loginpassword;
	
	public loginpage homeloginpassword(String password) {
		idandsendkeys("password",password);
		return new loginpage(driver);
		
	}

	
}
