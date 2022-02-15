import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.RelativeSelector;

public class RelativeSelectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/Users/wilson.sacnhezm/Documents/Selenium tools/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		RelativeSelector relatiSele = new RelativeSelector(driver);
		
		relatiSele.ralativeLocator();
		
	}

}
