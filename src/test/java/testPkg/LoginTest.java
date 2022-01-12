package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePkg.MainClass;
import pages.HomePage;
import pages.LoginSuccessPage;

public class LoginTest extends MainClass {
	HomePage hp;
	LoginSuccessPage lsp;
	
	@BeforeMethod
	public void launchApp() {
		intialization();
		hp = new HomePage();
		lsp = new LoginSuccessPage();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	@Test (dataProviderClass=data.LoginData.class, dataProvider="positiveLoginData")
	public void positiveLoginFunctionalityTestClickingSubmitBtn(String username, String password) {
		hp.enterUserName(username);
		hp.enterPassword(password);
		hp.clickSubmitBtn();
		String expectedLoginSuccessPageMsg = prop.getProperty("expectedLoginSuccessMsg");
		String actualLoginSuccessMsg = lsp.captureLoginSuccessMsg(); 
		Assert.assertEquals(actualLoginSuccessMsg, expectedLoginSuccessPageMsg);
	}
}
