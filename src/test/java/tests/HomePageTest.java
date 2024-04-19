package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configReader.ConfigPropReader;
import factory.DriverFactory;
import pages.HomePage;

public class HomePageTest {

	DriverFactory df;
	ConfigPropReader cp;
	Properties prop;
	WebDriver driver;
	HomePage homePage;
	
	@BeforeTest
	public void setup() {
		cp = new ConfigPropReader();
		prop = cp.initLangProp();
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		homePage = new HomePage(driver);
	}
	
	@Test
	public void doesHeaderExistTest() {
		Assert.assertTrue(homePage.doesHeaderExist(prop.getProperty("header")));
	}
	
	@Test
	public void doesContactExistTest() {
		Assert.assertTrue(homePage.doesContactExist(prop.getProperty("contact")));
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
