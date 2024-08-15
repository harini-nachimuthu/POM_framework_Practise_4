package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basemethod.base;

public class Newregisterpage extends base{

	public Newregisterpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	WebElement registername;
	
	@FindBy(id="password")
	WebElement registerpassword;
	
	@FindBy(id="re_password")
	WebElement registerre_password;
	
	@FindBy(id="full_name")
	WebElement registerfullname;
	
	@FindBy(id="email_add")
	WebElement registeremailid;
	
	@FindBy(id="tnc_box")
	WebElement registestermagree;
	
	@FindBy(id="Submit")
	WebElement registersubmit;
	
	public Newregisterpage newuser(String usernamemanual) {
		idandsendkeys("username",usernamemanual);
		return this;
	}
	
	public Newregisterpage newpassword(String passwordmanual) {
		idandsendkeys("password",passwordmanual);
		return this;
	}
	
	public Newregisterpage newrepassword(String repasswordmanual) {
		idandsendkeys("re_password",repasswordmanual);
		return this;
	}
	
	public Newregisterpage newfullname(String fullnamemanual) {
		idandsendkeys("full_name",fullnamemanual);
		return this;
	}
	
	public Newregisterpage newemail(String emailmanual) throws InterruptedException {
		idandsendkeys("email_add",emailmanual);
		Thread.sleep(40000);
		return this;
	}
	
	public void checkbox() {
		clickbtn(registestermagree);
	}
	
	public void submitregister() {
		clickbtn(registersubmit);

	}
	
	@FindBy(xpath="//td[@class='reg_success']")
	WebElement finaltext;
	
	public String gettingtext() {
		return finaltext.getText();
		
	}
	
	@FindBy(id="username_span")
	WebElement username_span;
	
	public String errorusername() {
		return username_span.getText();
	}

	@FindBy(id="email_add_span")
	WebElement email_add_span;
	
	public String email_add_span() {
		return email_add_span.getText();
	}
	//id="username_span"   This username is alredy available
	//id="email_add_span"   Email address is already in use
	// //a[normalize-space()='Go back to Login page']   Go back to Login page
	
	@FindBy(xpath="//a[normalize-space()='Go back to Login page']")
	WebElement loginpage;
	
	public void loginpage() {
		clickbtn(loginpage);
	}
	
}
