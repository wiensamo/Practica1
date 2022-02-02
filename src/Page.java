import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Page {
	
	//classes y methods to completed the form
	public static void ingreso() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/wilson.sacnhezm/Documents/Selenium tools/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	public static void completeCalendar(WebDriver driver, String frm, String toc) throws InterruptedException {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='"+frm+"']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@value='"+toc+"'])[2]")).click();
	}
	
	public static void selectDates(WebDriver driver, String mes, String dia) throws InterruptedException {
		while(!driver.findElement(By.className("ui-datepicker-title")).getText().contains(mes)) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			Thread.sleep(2000);
		}
		WebElement table = driver.findElement(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-first"));
		List<WebElement> days = table.findElements(By.cssSelector("a[class='ui-state-default']"));
		int count = days.size();
		System.out.println(days.size());
		for (int i = 0 ; i<= days.size(); i++) {
			String textDay = days.get(i).getText();
			if (textDay.equalsIgnoreCase(dia)) {
				days.get(i).click();
				break;
			}
		}
	}
	
	public static void selectPasajeros(WebDriver driver, int adul, int joven, int niño) throws InterruptedException {
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i = 0; i <(adul-1); i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		for (int i = 0; i <=joven; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		for (int i = 0; i <=niño; i++) {
			driver.findElement(By.id("hrefIncInf")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();		
	}
	
	public static void selectCurrency(WebDriver driver, String moneda) {
		WebElement staticDropDown	=	driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDwon = new Select(staticDropDown);
		dropDwon.selectByVisibleText(moneda);
	}
	
	public static void selectTrip(WebDriver driver, String trip) throws InterruptedException {
		if(trip== "OneWay") {
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
			}else if(trip=="RoundTrip") {
				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			}else if(trip=="TripPlanner") {
				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_2")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("MultiCityModelAlert")).click();
				Thread.sleep(2000);
			}
	}
	
	public static void searchTrip(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
	
	public static void selectSpeciAssistance (WebDriver driver, int numSpecialAssist) {
		switch(numSpecialAssist) {
		case 1:
			driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
			break;
		case 2:
			driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
			break;
		case 3:
			driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
			break;
		case 4:
			driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
			break;
		case 5:
			driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).click();
			break;
			
		}
	}
	
	public static void selectMultitrip(WebDriver driver, int numTrip, String tripfrom1,String tripto1, String tripfrom2
			,String tripto2, String tripfrom3,String tripto3, String tripfrom4,String tripto4, String tripfrom5,String tripto5) throws InterruptedException {
		switch(numTrip) {
		case 1: 	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
					driver.findElement(By.xpath("//a[@value='"+tripfrom1+"']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("(//a[@value='"+tripto1+"'])[2]")).click();
					break;
					
		case 2:		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
					List <WebElement>citys = driver.findElements(By.cssSelector("div[id='ctl00_mainContent_ddl_originStation1_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[href='#']"));
					for (int i = 0; i < citys.size(); i++) {
						if(tripfrom1 ==citys.get(i).getText()) {
							citys.get(i).click();
							Thread.sleep(1500);
						}else 
						if(tripto1== citys.get(i).getText()) {
							citys.get(i).click();
							Thread.sleep(1500);
						}
					}
					
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation2_CTXT")).click();
//					List <WebElement>citys2 = driver.findElements(By.cssSelector("div[id='ctl00_mainContent_ddl_originStation2_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[href='#']"));
//					for (int i = 0; i < citys2.size(); i++) {
//						if(tripfrom2 ==citys2.get(i).getText()) {
//							citys2.get(i).click();
//							Thread.sleep(1500);
//						}else 
//						if(tripto2== citys2.get(i).getText()) {
//							citys2.get(i).click();
//							Thread.sleep(1500);
//						}
//					}
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom1+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto1+"'])[2]")).click();
//					
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation2_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom2+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto2+"'])[2]")).click();
//					break;
//		case 3:		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom1+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto1+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation2_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom2+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto2+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation3_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom3+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto3+"'])[2]")).click();
//					break;
//		case 4: 	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom1+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto1+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation2_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom2+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto2+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation3_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom3+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto3+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation4_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom4+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto4+"'])[2]")).click();
//					break;
//		case 5:		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom1+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto1+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation2_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom2+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto2+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation3_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom3+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto3+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation4_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom4+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto4+"'])[2]")).click();
//					driver.findElement(By.id("ctl00_mainContent_ddl_originStation5_CTXT")).click();
//					driver.findElement(By.xpath("//a[@value='"+tripfrom5+"']")).click();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("(//a[@value='"+tripto5+"'])[2]")).click();
//					break;
//		default: 	System.out.println("the number of trips exceeds the maximum");
					break;
				
		}
		
	}

	public static void assitancepart (WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='Special Assistance']")).click();
		List <WebElement>linkDownLoad = driver.findElements(By.className("pdf-download-icon"));
		for (int i = 0; i < linkDownLoad.size(); i++) {
			linkDownLoad.get(0).click();
			break;
		}
		driver.findElement(By.className("popup-close2")).click();
	}
}
