import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GreenPage;

public class GreenPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/wilson.sacnhezm/Documents/Selenium tools/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
//		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
//		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
//		List<String> price;
//		do
//		{
//		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
//		price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
//		price.forEach(a -> System.out.println(a));
//		if(price.size()<1)
//		{
//		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
//		}
//		}while(price.size()<1);



		GreenPage greenPage = new GreenPage(driver);		
		greenPage.validateSearchField();
		
	}

	

}
	