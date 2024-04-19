package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil util;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	private WebElement getHeaderElement(String headerValue) {
		String headerXpath = "//a[contains(text(),'" + headerValue + "')]";
		return util.getElement("xpath", headerXpath);
	}
	
	public boolean doesHeaderExist(String headerValue) {
		String header = getHeaderElement(headerValue).getText();
		System.out.println(header);		
		return getHeaderElement(headerValue).isDisplayed();
	}
	
	public WebElement getContactElement(String contactValue) {
		String contactXpath = "//a[contains(text(),'" + contactValue + "')]";
		return util.getElement("xpath", contactXpath);
	}
	
	public boolean doesContactExist(String contactValue) {
		String header = getContactElement(contactValue).getText();
		System.out.println(header);		
		return getContactElement(contactValue).isDisplayed();
	}

}
