package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basemethod.base;

public class loginpage extends base{

	public loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}

	@FindBy(xpath="//div[.='Error: Pending Email Verification']")
	WebElement errorread;
	
	public String readerror() {
		return errorread.getText();
	}
	
	@FindBy(id="login")
	WebElement homeloginbtn;
	
	public void loginbtn() {
		clickbtn(homeloginbtn);
		
	}

}
