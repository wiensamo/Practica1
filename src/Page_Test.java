import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class Page_Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/Users/wilson.sacnhezm/Documents/Selenium tools/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		HomePage homePage = new HomePage(driver);
		
		homePage.selectTrip("RoundTrip");
		homePage.selectSpeciAssistance(2);
		homePage.completeCalendar("VTZ", "DAC");
		homePage.selectDates("March", "30");
		homePage.selectPassengers(2, 1, 1);
		homePage.selectCurrency("USD");
		
		homePage.selectTrip("TripPlanner");
		homePage.selectMultiTrip(3, "VTZ", "DAC", "GOI", "IXJ", "ATQ", "CCU", null, null, null, null);
		
		
		
//		Page pag = new Page();
//		pag.selectTrip(driver, "OneWay");
//		pag.selectSpeciAssistance(driver, 1);
//		pag.completeCalendar(driver,"VTZ", "DAC");
//		pag.selectDates(driver, "March", "30");
//		pag.selectPasajeros(driver, 2, 1, 0);
//		pag.selectCurrency(driver, "USD");
//		pag.searchTrip(driver);
//		Thread.sleep(5000);
//		pag.selectTrip(driver, "RoundTrip");
//		pag.selectSpeciAssistance(driver, 3);
//		pag.completeCalendar(driver,"GOI", "IXJ");
//		pag.selectDates(driver, "March", "26");
//		pag.selectPasajeros(driver, 2, 1, 1);
//		pag.selectCurrency(driver, "INR");
//		pag.searchTrip(driver);
//		pag.assitancepart(driver);
//		
//		Thread.sleep(5000);
//		pag.selectTrip(driver, "TripPlanner");
//		pag.selectMultitrip(driver, 2, "VTZ", "DAC", "GOI", "IXJ", "ATQ", "COK", null, null, null, null);
//		
	}

}
