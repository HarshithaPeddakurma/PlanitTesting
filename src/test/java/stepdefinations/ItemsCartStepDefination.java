package stepdefinations;

//import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.Contact;
import PageObjects.HomePage;
import PageObjects.ShopPage;
import PageObjects.SuccessfulMessagePage;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;
import resources.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(Cucumber.class)
public class ItemsCartStepDefination extends Base {
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	public HomePage h;
	public static ShopPage shop;

	@Given("^Open Chrome and go to \"([^\"]*)\"$")
	public void open_chrome_and_go_to_something(String homePageURL) throws Throwable {
		// Login into the Jupitor toys application
		driver = intializeDriver();
		driver.get(homePageURL);
		driver.manage().window().maximize();
		Log.info("Login in to the jupiter toys application");
	}

	@When("^Go to shop page from home page and click two times on Funny Cow and one time on Fluffy Bunny$")
	public void go_to_shop_page_from_home_page_and_click_two_times_on_funny_cow_and_one_time_on_fluffy_bunny()
			throws Throwable {
		// Call the addItems function
		h = new HomePage(driver);
		h.clickShop().click();
		String[] itemsNeeded = { "Funny Cow", "Fluffy Bunny" };
		addItems(driver, itemsNeeded);
	}

	@Then("^Validate Items are in the Cart$")
	public void validate_items_are_in_the_cart() throws Throwable {
		// Check products that are added are same as products in the cart
		CartPage c = new CartPage(driver);
		String quantity1 = c.FluffyBunnyQuantity().getAttribute("value");
		int FluffyBunnyQuantity = Integer.parseInt(quantity1);
		assertEquals(FluffyBunnyQuantity, 1);
		Log.info("Check if the Fluffy Bunny quantity is 1");
		String quantity2 = c.FunnyCowQuantity().getAttribute("value");
		int FunnyCowQuantity = Integer.parseInt(quantity2);
		assertEquals(FunnyCowQuantity, 2);
		Log.info("Check if the FunnyCow quantity is 2");
		driver.close();
		driver = null;
	}

	@And("^Click on Cart Menu$")
	public void click_on_cart_menu() throws Throwable {
		// Click on the shop Cart Menu
		shop.Cart().click();
		Log.info("Click on the Cart Menu successfully");
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded)

	{
		// Double Click on Funny Cow and Click once on Fluffy Bunny in the products
		shop = new ShopPage(driver);
		int j = 0;

		List<WebElement> products = shop.ProductNames();
		Actions a = new Actions(driver);

		for (int i = 0; i < products.size(); i++)

		{

			String name = products.get(i).getText();

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(name))

			{
				j++;
				if (name.equalsIgnoreCase("Funny Cow")) {
					a.doubleClick((WebElement) shop.BuyButton().get(i)).build().perform();
				} else {
					shop.BuyButton().get(i).click();
				}

			}
			if (j == itemsNeeded.length)

			{

				break;

			}

		}

	}

}
