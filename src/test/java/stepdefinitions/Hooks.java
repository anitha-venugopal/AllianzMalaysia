package stepdefinitions;

import org.openqa.selenium.WebDriver;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	WebDriver driver;

	@Before
	public void setUp() {
	    System.out.println("Run Before Scenario");
		BaseTest.initializeDriver();
	    driver = BaseTest.getDriver();
	    System.out.println(driver);
	    if (driver == null) {
	        throw new IllegalStateException("WebDriver is not initialized.");
	    }
	}

	@After
	public void tearDown() {
	    System.out.println("Run After Scenario");
		if (driver != null) {
			driver.quit();
		}
	}
}