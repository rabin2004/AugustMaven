package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.MainClass;

public class HomePage extends MainClass {
	
	// 1. Create webElement -> @FindBy
	// 2. Initialize webElement to driver instance -> constructor of this class
	// 3. Define methods for the webElement
	
	// old way of creating webElement
//	driver.findElement(By.name("userName"));
//	driver.findElement(By.name("password"));
//	driver.findElement(By.name("submit"));
	
	// Using @FindBy
	@FindBy(name="userName")
	WebElement userNameTxtField;
	@FindBy(name="password")
	WebElement passwordTxtField;
	@FindBy(name="submit")
	WebElement submitBtn;
	@FindBy(linkText="REGISTER")
	WebElement registerLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username) {
		userNameTxtField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTxtField.sendKeys(password);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public void clickRegisterLink() {
		registerLink.click();
	}
	

}
