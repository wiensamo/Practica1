package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLinks {

	WebDriver driver;
	public PageLinks(WebDriver driver) {
		this.driver=driver;
	}
	
	By foter = By.id("gf-BIG");
	By aLinks = By.tagName("a");
	By firstColumn = By.xpath("//table/tbody/tr/td[1]/ul");
	
	public void linksFirstColumn () {
		WebElement footerdirver = driver.findElement(foter);
		WebElement columndriver = footerdirver.findElement(firstColumn);
		
		for (int i = 0; i < columndriver.findElements(aLinks).size(); i++) {
			String clickOnTap = Keys.chord(Keys.COMMAND, Keys.ENTER);	// Depends of the pc you use de Keys.Control in windows o Keys.COMMAND in MAC
			columndriver.findElements(aLinks).get(i).sendKeys(clickOnTap);	
		}
		Set<String> ab = driver.getWindowHandles();
		Iterator<String> it = ab.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
		}
	}
	
	
}
