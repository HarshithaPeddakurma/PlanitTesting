package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(id = "nav-contact")
	WebElement clickContact;
	@FindBy(xpath = "//*[@id=\"nav-shop\"]/a")
	WebElement clickShop;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement clickContact() {
		return clickContact;
	}
	public WebElement clickShop() {
		return clickShop;
	}
}
