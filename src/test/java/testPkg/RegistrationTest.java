package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePkg.MainClass;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegistrationSuccessPage;

public class RegistrationTest extends MainClass{
	RegisterPage rp;
	RegistrationSuccessPage rsp;
	HomePage hp;
	
	@BeforeMethod
	public void launchApp() {
		intialization();
		hp = new HomePage();
		rp = new RegisterPage();
		rsp = new RegistrationSuccessPage();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	@Test(dataProviderClass=data.RegistrationData.class, dataProvider="positiveRegistrationData")
	public void positiveRegistrationFunctionality(String username, String passsword) {
		hp.clickRegisterLink();
		rp.submitRegistrationForm(username, passsword);
		String expectedRegisterSuccessMsg = "Note: Your user name is "+username+".";
		Assert.assertEquals(rsp.captureRegistrationSuccessMsg(), expectedRegisterSuccessMsg);
	}
}
