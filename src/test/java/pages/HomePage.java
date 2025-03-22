package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	// Objects

	@FindBy(xpath = "(//div[@class='Dropdown__InputContent-sc-16g04av-6 dDSLaj']/input)[1]")
	private WebElement fromlocationTab;

	@FindBy(xpath = "(//div[@class='Dropdown__InputContent-sc-16g04av-6 dDSLaj']/input)[2]")
	private WebElement tolocationTab;

	@FindBy(xpath = "//div[@class='FlightSearchWidget__USWContent-sc-9n630u-3 cTxCTl']/span/a")
	private WebElement homesearchBtn;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	public String  getcurrenturl() {
		 return driver.getCurrentUrl();
	}
	 
	public HomePage setLocation(String label, String value) {
		try {
	        // Handle the AirAsia promo notification popup
	        WebElement denyButton = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[contains(@class,'wzrk-button-container')]//button[text()='Deny']")
	        ));
	        
	        denyButton.click();
	        
	    } catch (Exception e) {
	        System.out.println("No promo alert to dismiss.");
	    }
		
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("wzrk-overlay")));
		} catch (TimeoutException ignored) {
			System.out.println("Overlay did not disappear in time, proceeding anyway.");
		}

		WebElement labelInput = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='" + label + "']")));

//	 	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", labelInput);
//	 	    labelInput.click();
		for (int i = 0; i < 20; i++) {
			labelInput.sendKeys(Keys.BACK_SPACE);
		}

		labelInput.click(); // Focus the input

		// Clear using BACK_SPACE multiple times
		for (int i = 0; i < 20; i++) {
			labelInput.sendKeys(Keys.BACK_SPACE);
		}

		// Now type the value and select suggestion
		Actions actions = new Actions(driver);
		actions.sendKeys(value)
		.pause(Duration.ofSeconds(1))
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER)
		.build()
	    .perform();

		return this;
	}
     
	public HomePage setdate(String label, String value) throws InterruptedException {
	    // Locate the date input field by label
	    WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	        "//input[@label='" + label + "' and @placeholder]"
	    )));

	    // Focus and enter the date
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].focus();", dateInput);
	    dateInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    dateInput.sendKeys(Keys.BACK_SPACE);
	    dateInput.sendKeys(value);

	    // Wait for and click the Confirm button
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	        "//div[@class='calendarfooter__FooterElements-sc-1pqsoxb-1 koGMcN']/div[2]/a[contains(text(),'Confirm')]"
	    ))).click();

	    return this;
	}

	public void clickhomepagesearchbtn() {
	    // Close calendar if open
	    Actions actions = new Actions(driver);
	    actions.sendKeys(Keys.ESCAPE).perform();

	    // Wait for Search button to be clickable
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(homesearchBtn));
	    homesearchBtn.click();
	}

   
}
