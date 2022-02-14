package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GreenPage {

	WebDriver driver;
	public GreenPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By elemt = By.xpath("//tr/th[1]");
	By nextTo = By.xpath("following-sibling::td[1]");
	By next = By.cssSelector("[aria-label='Next']");
	
	public void lamdaExpre() {
		List<WebElement> elementsList = driver.findElements(elemt);
		List<String> orignList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = orignList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignList.equals(sortedList));
	}

	
	public void findElement() {
		List<WebElement> elementsList = driver.findElements(elemt);
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> price;
		do{
			List<WebElement> rows = driver.findElements(elemt);
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1){
				driver.findElement(next).click();
				}
			}while(price.size()<1);
	}

	
	private  String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(nextTo).getText();
		return pricevalue;

	}
	
	
}
