package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class CheckOutPage {
	WebDriver driver;
	WebDriverWait wait;
	
	//objects
	@FindBy(xpath="//div[@aria-label='Insurance Add-ons']/div[2]/div[1]/div/div/div/div[@role='radio']/div/div[@class='Checkbox__OptionWrapper-sc-13gxc8j-0 pIMI check-box']/span")
	private WebElement InsurancePlusradiobtn;
	
	@FindBy(xpath="//div[@aria-label='Insurance Add-ons']/div[2]/div[2]/div/div/div/div[@role='radio']/div/div[@class='Checkbox__OptionWrapper-sc-13gxc8j-0 pIMI check-box']/span")
	private WebElement InsuranceLiteradiobtn;
	
	public CheckOutPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(5));	
	}
	
	public void getcheckoutpagecurrenturl() {
		driver.getCurrentUrl();
	} 
	
	public CheckOutPage SelectInsuranceAddons(String type) {
		switch(type.toLowerCase()) {
		  case "plus":
		    wait.until(ExpectedConditions.elementToBeClickable(InsurancePlusradiobtn)).click();
		    break;
		  case "lite":
		    wait.until(ExpectedConditions.elementToBeClickable(InsuranceLiteradiobtn)).click();
		    break;
		  default:
		    wait.until(ExpectedConditions.elementToBeClickable(InsurancePlusradiobtn)).click();
		    // code block
		}
		
		return this;
	}
	
	public String GetInsuranceAddonPrice(String type) {
		String insPrice = "";
		
		switch(type.toLowerCase()) {
		  case "plus":
		  	insPrice = driver.findElement(By.xpath("//div[@aria-label='Insurance Add-ons']/div[2]/div[1]/div/div/div/div[@role='radio']/div[3]/span/p[1]")).getText()
		  	.concat(driver.findElement(By.xpath("//div[@aria-label='Insurance Add-ons']/div[2]/div[1]/div/div/div/div[@role='radio']/div[3]/span/p[2]")).getText());
		    break;
		  case "lite":
			insPrice = driver.findElement(By.xpath("//div[@aria-label='Insurance Add-ons']/div[2]/div[2]/div/div/div/div[@role='radio']/div[3]/span/p[1]")).getText()
			.concat(driver.findElement(By.xpath("//div[@aria-label='Insurance Add-ons']/div[2]/div[2]/div/div/div/div[@role='radio']/div[3]/span/p[2]")).getText());
		    break;
		  default:
			  insPrice = "0";
		}

		return insPrice.trim(); 
	}
	
	public String GetAddOnPriceOnFareSummary() {
		return driver.findElement(By.xpath("//div[@class='FareSummary__MainWrapper-sc-o2oo2p-0 bLRSZp']/div/div[2]/div/div[3]/div/div/div/span/p")).getText().trim();
	}
	
	public String GetAddOnPriceOnFareDetails() {
		return driver.findElement(By.xpath("//div[@class='FareBreakdown__ToggleWrapper-sc-1a02g14-1 kxvMQh']/div[2]/div[last()-1]/div[2]/div/span/p")).getText().trim();
	}
	
	public String ToggleFare() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='FareSummary__MainWrapper-sc-o2oo2p-0 bLRSZp']/div/div[1]/div[2]"))).click();
		return driver.findElement(By.xpath("//div[@class='FareSummary__MainWrapper-sc-o2oo2p-0 bLRSZp']/div/div[1]/div[2]/div[1]/p")).getText();
	}
	
	
}
