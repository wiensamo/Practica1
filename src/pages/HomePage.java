package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	private static final String frm = null;
	private static final String toc = null;
	
	WebDriver driver;
	
	public void Homepage(WebDriver driver) {
		this.driver=driver;
	}
	
	By calendarId 		= By.id("ctl00_mainContent_ddl_originStation1_CTXT"); 
	By calendarFrom 	= By.xpath("//a[@value='"+frm+"']");
	By calendarTo 		= By.xpath("(//a[@value='"+toc+"'])[2]");
	
	public  void completeCalendar () {
		driver.findElement(calendarId).click();
		driver.findElement(calendarFrom).click();
		driver.findElement(calendarTo).click();
	}
	
	By selectMount 		= By.className("ui-datepicker-title");
	By selectTblDays    = By.cssSelector(".ui-datepicker-group.ui-datepicker-group-first");
	By selectDays		= By.cssSelector("a[class='ui-state-default']");
	By nxtBtn 	  	    = By.xpath("//a[@title='Next']");
	
	public void selectDates(String mount, String day){
		while(!driver.findElement(selectMount).getText().contains(mount)) {
			driver.findElement(nxtBtn).click();
		}
		WebElement table = driver.findElement(selectTblDays);
		List<WebElement> days = table.findElements(selectDays);
		int count = days.size();
		System.out.println(days.size());
		for (int i = 0 ; i<= days.size(); i++) {
			String textDay = days.get(i).getText();
			if (textDay.equalsIgnoreCase(day)) {
				days.get(i).click();
				break;
			}
		}
	}
	
	By selectPassengers = By.id("divpaxinfo");
	By addAdult 		= By.id("hrefIncAdt");
	By addChdren		= By.id("hrefIncChd");
	By addInf			= By.id("hrefIncInf");
	By closeBtn 		= By.id("btnclosepaxoption");
	
	public void selectPassengers(int adul, int joven, int niño) {
		driver.findElement(selectPassengers).click();
		for (int i = 0; i <(adul-1); i++) {
			driver.findElement(addAdult).click();
		}
		for (int i = 0; i <=joven; i++) {
			driver.findElement(addChdren).click();
		}
		for (int i = 0; i <=niño; i++) {
			driver.findElement(addInf).click();
		}
		driver.findElement(closeBtn).click();	
	}

	By selecCurren =  By.id("ctl00_mainContent_DropDownListCurrency");
	
	public void selectCurrency(String currency) {
		WebElement staticDropDown	=	driver.findElement(selecCurren);
		Select dropDwon = new Select(staticDropDown);
		dropDwon.selectByVisibleText(currency);
	}

	By selectOneWay 	= By.id("ctl00_mainContent_rbtnl_Trip_0");
	By selectRaoundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
	By selectTripPlan	= By.id("ctl00_mainContent_rbtnl_Trip_2");
	By alrtBtn 			= By.id("MultiCityModelAlert");
	
	public void selectTrip(String trip)  {
		if(trip== "OneWay") {
			driver.findElement(selectOneWay).click();
			}else if(trip=="RoundTrip") {
				driver.findElement(selectRaoundTrip).click();
			}else if(trip=="TripPlanner") {
				driver.findElement(selectTripPlan).click();
				driver.findElement(alrtBtn).click();
			}
	}
	
	By selectFriendFmly = By.id("ctl00_mainContent_chk_friendsandfamily");
	By selectSenior 	= By.id("ctl00_mainContent_chk_SeniorCitizenDiscount");
	By selectIndArm 	= By.id("ctl00_mainContent_chk_IndArm");
	By selectStudent	= By.id("ctl00_mainContent_chk_StudentDiscount");
	By selectChrUmr		= By.id("ctl00_mainContent_chk_Unmr");
	
	
	public void selectSpeciAssistance (int numSpecialAssist) {
		switch(numSpecialAssist) {
		case 1:
			driver.findElement(selectFriendFmly).click();
			break;
		case 2:
			driver.findElement(selectSenior).click();
			break;
		case 3:
			driver.findElement(selectIndArm).click();
			break;
		case 4:
			driver.findElement(selectStudent).click();
			break;
		case 5:
			driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).click();
			break;
			
		}
	}
	
	By selectAssist 	= By.xpath("//*[text()='Special Assistance']");
	By downLoadPdf 		= By.className("pdf-download-icon");
	By closePopUp 		= By.className("popup-close2");
	
	public void assitancepart () {
		driver.findElement(selectAssist).click();
		List <WebElement>linkDownLoad = driver.findElements(downLoadPdf);
		for (int i = 0; i < linkDownLoad.size(); i++) {
			linkDownLoad.get(0).click();
			break;
		}
		driver.findElement(closePopUp).click();
	}
	
	
	
	
}
