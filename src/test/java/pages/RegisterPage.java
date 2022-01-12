package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.MainClass;

public class RegisterPage extends MainClass{
	@FindBy(name="email")
	WebElement usernameTxtField;
	@FindBy(name="password")
	WebElement passwordTxtField;
	@FindBy(name="confirmPassword")
	WebElement confirmPasswordTxtField;
	@FindBy(name="submit")
	WebElement submitBtn;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void submitRegistrationForm(String username, String password) {
		usernameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		confirmPasswordTxtField.sendKeys(password);
		submitBtn.click();
	}

}
