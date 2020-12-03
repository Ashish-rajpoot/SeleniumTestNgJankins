package com.ecom.tests.SeleniumTestNGjankins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import okhttp3.OkHttpClient;

public class ApplicationTest {
	
	SoftAssert soft = new SoftAssert();
	final String siteUrl ="https://www.facebook.com/";
	final String driverPath = "F:\\Drivers\\driver\\chromedriver.exe";
	WebDriver driver;
  @Test
  public void testEasy() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  new OkHttpClient().newBuilder().connectTimeout(100, TimeUnit.SECONDS).build();
	  driver = new ChromeDriver();
	  driver.get(siteUrl);
	  soft.assertEquals("FB Login", driver.getTitle());
  }
  @BeforeTest
  public void beforeTest() {
	  Reporter.log("Before Test");
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
