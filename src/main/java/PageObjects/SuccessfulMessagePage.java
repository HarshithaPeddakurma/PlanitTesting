package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulMessagePage {
	WebDriver driver;

	By BackButton=By.xpath("//a[contains(text(),'« Back')]");
	
	public SuccessfulMessagePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement BackButton() {
	 return driver.findElement(BackButton);
	}

}
