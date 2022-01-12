package basePkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MainClass {
	public static Properties prop;
	public static WebDriver driver;

	public void intialization() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace"
					+ "\\AugustMaven\\src\\main\\java\\properties\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
		System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ff")) {
		System.setProperty(prop.getProperty("ffKey"), prop.getProperty("ffPath"));
		driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
		System.setProperty(prop.getProperty("ieKey"), prop.getProperty("iePath"));
		driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("QAtestURL"));
	}
	
	public void tearDown() {
		driver.close();
	}
}
