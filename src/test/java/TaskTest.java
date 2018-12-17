import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import testbase.TestBase;

public class TaskTest extends TestBase{
	MainPage mp;

	@Test
	public void checkURL() {
		driver = TestBase.openBrowser();
		mp = new MainPage(driver);
		
		mp.checkURL(driver.getCurrentUrl());
		mp.checkFlightTabIsSelected();
		mp.enterDapatureCity("San Francisco");
		mp.enterArrivalCity("Orlando");
		mp.selectStartDate("Feb-11-2019");
		
	}
	

}
