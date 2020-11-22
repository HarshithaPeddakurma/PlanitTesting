package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	@FindBy(xpath = "//td[@class='ng-binding']/following-sibling::td[2]/input[@value='1']")
	WebElement FluffyBunnyQuantity;
	@FindBy(xpath = "//td[@class='ng-binding']/following-sibling::td[2]/input[@value='2']")
	WebElement FunnyCowQuantity;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement FluffyBunnyQuantity() {
		return FluffyBunnyQuantity;
	}
	public WebElement FunnyCowQuantity() {
		return FunnyCowQuantity;
	}

}
