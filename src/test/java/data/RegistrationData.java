package data;

import org.testng.annotations.DataProvider;

public class RegistrationData {
	
	@DataProvider
	public Object[][] positiveRegistrationData() {
		Object[][] data = {	{"test", "123"},
							{"test12", "123"},
							{"test123", "123"},
							{"test1234", "12345"},
							{"test12345", "123"}};
		return data;
	}

}
