package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.MainClass;

public class RegistrationSuccessPage extends MainClass{
	@FindBy(xpath="//table[@width='492']/tbody/tr[3]/td/p[3]/font")
	WebElement registrationSuccessMsg;
	
	public RegistrationSuccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String captureRegistrationSuccessMsg() {
		String msg = registrationSuccessMsg.getText();
		return msg;
	}

}
