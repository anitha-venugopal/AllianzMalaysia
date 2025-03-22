package testcases;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class InsuranceTest extends BaseTest {
	HomePage homepage;

	@Test(priority =1)
	public void InsuranceAddonsavailablewhilecheckout() throws TimeoutException, InterruptedException {
	    homepage = new HomePage(driver);
	    homepage.setLocation("From" , "Kuala Lumpur International Airport");
	    homepage.setLocation("To", "Don Mueang International Airport");
	    homepage.setdate("Depart", "30/03/2025");
	    homepage.setdate("Return", "05/04/2025");
	    homepage.clickhomepagesearchbtn();	    
	}
}
