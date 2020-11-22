package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
	WebDriver driver;
	By ProductNames=By.cssSelector("h4.product-title.ng-binding");
	By BuyButton=By.cssSelector("a.btn.btn-success");
	By Cart=By.xpath("//li[@id='nav-cart']");
	

public ShopPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}

	public List<WebElement> ProductNames() {
		return driver.findElements(ProductNames);
	}

	public List<WebElement> BuyButton() {
		return driver.findElements(BuyButton);
	}
	public WebElement Cart() {
		return driver.findElement(Cart);
	}
	


}
