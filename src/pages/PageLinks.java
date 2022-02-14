package pages;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;

public class PageLinks {

	WebDriver driver;
	public PageLinks(WebDriver driver) {
		this.driver=driver;
	}
	
	By foter = By.id("gf-BIG");
	By aLinks = By.tagName("a");
	By firstColumn = By.xpath("//table/tbody/tr/td[1]/ul");
	
	// Open the links of the first column
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
	//Take Screenshot
	public void Screenshot () throws IOException, InterruptedException {		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/wilson.sacnhezm/Desktop"));
	}
	
	//Call URL's and get you status code
	By links = By.cssSelector("li[class='gf-li'] a");
	
	public void worksLinks () throws MalformedURLException, IOException {
		List<WebElement> lsitAs =driver.findElements(links);
		SoftAssert a = new SoftAssert();
		for (WebElement link : lsitAs) {
			String url = driver.findElement(links).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with text "+link.getText()+" is broke with code "+respCode);

		}
		a.assertAll();
		
	}
	
	
	
}
