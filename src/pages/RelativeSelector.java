package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.*;



public class RelativeSelector {

	WebDriver driver;
	public RelativeSelector (WebDriver driver) {
		this.driver=driver;
	}
	
	By nameSelector = By.cssSelector("[name='name']");
	By tgname = By.tagName("label");
	By birthTag = By.cssSelector("[for='dateofBirth']");
	By inpyTag = By.tagName("input");
	By checkLabelTag = By.xpath("//label[text()='Check me out if you Love IceCreams!']");
	
	public void ralativeLocator () {
		WebElement nameEdityBox = driver.findElement(nameSelector);
		System.out.println(driver.findElement(with(tgname).above(nameEdityBox)).getText());
		
		WebElement dateofBirth = driver.findElement(birthTag);
		driver.findElement(with(inpyTag).below(dateofBirth)).click();

		WebElement iceCreamLabel =driver.findElement(checkLabelTag);
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(tgname).toRightOf(rdb)).getText());


		
		
	}
	
}
