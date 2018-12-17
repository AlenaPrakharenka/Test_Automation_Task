package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {
	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='booking-form--flight-tab']")
	private WebElement flight;

	@FindBy(how = How.XPATH, using = "//*[@id='air-city-departure']")
	private WebElement departureCity;

	@FindBy(how = How.XPATH, using = "//*[@id='air-city-arrival']")
	private WebElement arrivalCity;

	public void checkURL(String URL) {

		Assert.assertEquals(URL, "https://www.southwest.com/");
	}

	public void checkFlightTabIsSelected() {

		Assert.assertTrue(flight.getAttribute("aria-selected").contains("true"));
	}

	public void enterDapatureCity(String departureCity) {
		this.departureCity.sendKeys(departureCity);

		List<WebElement> data = driver.findElements(By
				.xpath("//ul[@id='air-city-departure-menu']/li"));

		for (int i = 0; i < data.size(); i++) {

			WebElement element = data.get(i);
			String text = data.get(i).getText();
			if (text.equals("San Francisco, CA - SFO")) {
				element.click();
				break;
			}
		}
	}

	public void enterArrivalCity(String arrivalCity) {
		this.arrivalCity.sendKeys(arrivalCity);

		List<WebElement> data = driver.findElements(By
				.xpath("//ul[@id='air-city-arrival-menu']/li"));

		for (int i = 0; i < data.size(); i++) {

			WebElement element = data.get(i);
			String text = data.get(i).getText();
			if (text.equals("Orlando, FL - MCO")) {
				element.click();
				break;
			}
		}
	}

	public void selectStartDate(String startDate) {
		/*Date d = new Date(startDate);

		SimpleDateFormat dt = new SimpleDateFormat("MMM-dd-yyyy");
		String date = dt.format(d);*/

		String[] split = startDate.split("-");
		String monthYear = split[0] + " " + split[2];

		WebElement startDateElement = driver
				.findElement(By
						.xpath("//*[@id='booking-form--flight-panel']/div[2]/div[2]/div[1]/a"));
		startDateElement.click();

		List<WebElement> twoCalendarsMonth = driver.findElements(By
				.xpath("//h4[@class='calendar-selector--watermark']"));

		List<WebElement> twoCalendarsYear = driver.findElements(By
				.xpath("//*[@class='calendar-selector--navigation']/h3/span"));
		
		
		while ((twoCalendarsMonth.get(0).getText() != split[0] && twoCalendarsYear
				.get(0).getText() != split[2])
				|| (twoCalendarsMonth.get(1).getText() != split[0] && twoCalendarsYear
						.get(1).getText() != split[2])) {
			driver.findElement(
					By.xpath("//a[@class='next js-next ' and @title='Next Month']"))
					.click();
		}

		driver.findElement(
				By.xpath("//*[@id='calendar-descendant']/div[2]/div[1]/div/table/tbody/tr/td[contains(text(),'"
						+ split[1] + "')]")).click();
	}
}
