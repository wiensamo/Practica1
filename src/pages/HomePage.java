package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By calendarId 		= By.id("ctl00_mainContent_ddl_originStation1_CTXT"); 
	
	public  void completeCalendar (String frm, String toc) {
		By calendarFrom     = By.xpath("//a[@value='"+frm+"']");
		By calendarTo 		= By.xpath("(//a[@value='"+toc+"'])[2]");
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
	
	By tableTrip1 		= By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	By tableTrip2 		= By.id("ctl00_mainContent_ddl_originStation2_CTXT");
	By tableTrip3 		= By.id("ctl00_mainContent_ddl_originStation3_CTXT");
	By tableTrip4		= By.id("ctl00_mainContent_ddl_originStation4_CTXT");
	By tableTrip5 		= By.id("ctl00_mainContent_ddl_originStation5_CTXT");
	
	
	public void selectMultiTrip (int numtrip, String tripfrom1,String tripto1, String tripfrom2
			,String tripto2, String tripfrom3,String tripto3, String tripfrom4,String tripto4, String tripfrom5,String tripto5) {
		
		By selectCity1		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation1_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripfrom1+"']");
		By selectCity2		= By.cssSelector("td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripto1+"']");
		By selectCity21		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation2_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripfrom2+"']");
		By selectCity22		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation2_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripto2+"']");
		By selectCity31		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation3_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripfrom3+"']");
		By selectCity32		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation3_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripto3+"']");
		By selectCity41		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation4_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripfrom4+"']");
		By selectCity42		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation4_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripto4+"']");
		By selectCity51		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation5_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripfrom5+"']");
		By selectCity52		= By.cssSelector("div[id='ctl00_mainContent_ddl_originStation5_CTNR'] td[class='mapbg'] div[class='dropdownDiv'] a[value='"+tripto5+"']");
		By btnmore1 		= By.cssSelector("input[id='btnAddMore1']");
		switch(numtrip) {
		case 1: 
			driver.findElement(tableTrip1).click();
			driver.findElement(selectCity1).click();			
			driver.findElement(selectCity2).click();
			break;
		case 2:
			driver.findElement(tableTrip1).click();
			driver.findElement(selectCity1).click();			
			driver.findElement(selectCity2).click();
			driver.findElement(tableTrip2).click();			
			driver.findElement(selectCity21).click();	
			driver.findElement(selectCity22).click();
			break;
		case 3:
			driver.findElement(tableTrip1).click();
			driver.findElement(selectCity1).click();			
			driver.findElement(selectCity2).click();
			driver.findElement(tableTrip2).click();			
			driver.findElement(selectCity21).click();	
			driver.findElement(selectCity22).click();
			driver.findElement(tableTrip3).click();
			driver.findElement(selectCity31).click();
			driver.findElement(selectCity32).click();
			break;
		case 4:
			driver.findElement(tableTrip1).click();
			driver.findElement(selectCity1).click();			
			driver.findElement(selectCity2).click();
			driver.findElement(tableTrip2).click();			
			driver.findElement(selectCity21).click();	
			driver.findElement(selectCity22).click();
			driver.findElement(tableTrip3).click();
			driver.findElement(selectCity31).click();
			driver.findElement(selectCity32).click();
			driver.findElement(btnmore1);
			driver.findElement(tableTrip4).click();
			driver.findElement(selectCity41).click();
			driver.findElement(selectCity42).click();
			break;
		case 5: 
			driver.findElement(tableTrip1).click();
			driver.findElement(selectCity1).click();			
			driver.findElement(selectCity2).click();
			driver.findElement(tableTrip2).click();			
			driver.findElement(selectCity21).click();	
			driver.findElement(selectCity22).click();
			driver.findElement(tableTrip3).click();
			driver.findElement(selectCity31).click();
			driver.findElement(selectCity32).click();
			driver.findElement(btnmore1);
			driver.findElement(tableTrip4).click();
			driver.findElement(selectCity41).click();
			driver.findElement(selectCity42).click();
			driver.findElement(btnmore1);
			driver.findElement(tableTrip5).click();
			driver.findElement(selectCity51).click();
			driver.findElement(selectCity52).click();
			break;
			
		}
	}
	
}
