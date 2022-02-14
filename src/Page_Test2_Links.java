import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.PageLinks;

public class Page_Test2_Links {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/wilson.sacnhezm/Documents/Selenium tools/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		PageLinks pageLinks = new PageLinks(driver);
		
		//pageLinks.linksFirstColumn();
		//pageLinks.Screenshot();
		pageLinks.worksLinks();
		
	}

}
