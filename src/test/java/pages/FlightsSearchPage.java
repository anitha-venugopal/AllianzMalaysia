package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsSearchPage {
	WebDriver driver;
	WebDriverWait wait;
	
	//Objects
	@FindBy(xpath="(//div[@class='JourneyPriceCTA__StyledCTAContainer-sc-84l2fp-7 cDALuS']/div/a[contains(text(),'Select')])[1]")
	private WebElement SelectBtn;
	
	@FindBy(xpath="//div[@class='aaw-container aaw-container-max-width']/div[@id='aaw-login-tab']/div/a[.='Continue as guest']")
	private WebElement Continueasguest;
	
	public FlightsSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public String getcurrenturl() {
		return driver.getCurrentUrl();
	}
  
	public void clickSelectBtn() {
     wait.until(ExpectedConditions.elementToBeClickable(SelectBtn)).click();
	  
	} 
	
	public void clickContinueasguestbtn() {
		Continueasguest.click();
	}	
}
