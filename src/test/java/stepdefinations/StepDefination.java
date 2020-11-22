package stepdefinations;

//import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Contact;
import PageObjects.HomePage;
import PageObjects.SuccessfulMessagePage;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;
import resources.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(Cucumber.class)
public class StepDefination extends Base {
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	public static HomePage h;
	public static Contact c;
	public static StepDefination s;
	public String ActualInvalidEmail;

	String ExpectedForeNameerror = "Forename is required";
	String ExpectedEmailerror = "Email is required";
	String ExpectedMessagerror = "Message is required";

	@Given("^Open Chrome and navigate to \"([^\"]*)\"$")
	public void open_chrome_and_navigate_to_something(String homePageURL) throws Throwable {
		// Login into the Jupitor toys application
		driver = intializeDriver();
		driver.get(homePageURL);
		driver.manage().window().maximize();
		Log.info("Login in to the jupiter toys application");
	}

	@When("^Go to contact page from home page and click on submit button$")
	public void go_to_contact_page_from_home_page_and_click_on_submit_button() throws Throwable {
		// Click on submit button in the Contacts Page without entering the data in the
		// field of Contacts Page
		h = new HomePage(driver);
		h.clickContact().click();
		Log.info("Successfully clicked on ContactsPage");
		c = new Contact(driver);
		c.Submit().click();
		Log.info("Successfully clicked on ContactsPage Submit Button");

	}

	@Then("^Validate Errors$")
	public void validate_errors() throws Throwable {
		// Check there are errors after not entering the data in the fields of contact
		// page and clicking on submit button
		String ActualForenameError = c.ForenameError().getText();
		assertEquals(ActualForenameError, ExpectedForeNameerror);
		String ActualEmailError = c.EmailError().getText();
		assertEquals(ActualEmailError, ExpectedEmailerror);
		String ActualMessageError = c.MessageError().getText();
		assertEquals(ActualMessageError, ExpectedMessagerror);
		Log.info("Validate Errors");
	}

	@And("^Populate Mandatory fields \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void populate_mandatory_fields_somethingsomethingsomething(String forename, String email, String message)
			throws Throwable {
		// Enter valid data in the mandatory fields of Contacts Page
		c.Forename().sendKeys(forename);
		c.Email().sendKeys(email);
		c.Message().sendKeys(message);
		Log.info("Enter data in forname,Email,Message");

	}

	@Then("^Validate Errors are gone$")
	public void validate_errors_are_gone() throws Throwable {
		// Check there are no errors after entering the data in the fields of contact
		// page
		assertFalse(driver.getPageSource().contains(ExpectedForeNameerror));
		assertFalse(driver.getPageSource().contains(ExpectedEmailerror));
		assertFalse(driver.getPageSource().contains(ExpectedMessagerror));
		Log.info("Validate if Errors are gone after Entering valid data in mandatory fields");
	}

	@Given("^Populate Mandatory fields$")
	public void populate_mandatory_fields() throws Throwable {
		// Enter valid data in the mandatory fields of Contacts Page
		s = new StepDefination();
		s.populate_mandatory_fields_somethingsomethingsomething("Harshitha", "harshitha.t@gmail.com", "Hi");
	}

	@When("^Click submit after entering the data in the Contacts Page$")
	public void click_submit_after_entering_the_data_in_the_contacts_page() throws Throwable {
		c.Submit().click();
		Log.info("Click on Submit button");

	}

	@Then("^Validate successful submission$")
	public void validate_successful_submission() throws Throwable {
		// Validate successful submission after entering data and clicking on submit
		// button
		Thread.sleep(5000);
		String ActualAlertSuccess = c.AlertSuccess().getText();
		System.out.println(ActualAlertSuccess);
		assertEquals(ActualAlertSuccess, "Thanks HarshithaHarshitha, we appreciate your feedback.");
		if (ActualAlertSuccess.equalsIgnoreCase("Thanks HarshithaHarshitha, we appreciate your feedback.")) {
			Log.info("Validate successfull message");
		}
	}

	@Given("^Click Back button on the successful submission of Contacts page$")
	public void click_back_button_on_the_successful_submission_of_contacts_page() throws Throwable {
		// Click on the back button od the successfull submission of Contact Page
		SuccessfulMessagePage message = new SuccessfulMessagePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(message.BackButton()));
		message.BackButton().click();
		Log.info("Click on the back button od the successfull submission of Contact Page");
	}

	@When("^Populate invalid data in the mandatory field of Contacts Page$")
	public void populate_invalid_data_in_the_mandatory_field_of_contacts_page() throws Throwable {
		// Enter invalid data in the mandatory fields of the Contact Page
		s.populate_mandatory_fields_somethingsomethingsomething("harshitha", "har", "Hi");

	}

	@Then("^Validate invalid data Errors$")
	public void validate_invalid_data_errors() throws Throwable {
		// Validata invalid data error after entering invalid data in the email field of
		// Contact Page
		ActualInvalidEmail = c.EmailError().getText();
		assertEquals(ActualInvalidEmail, "Please enter a valid email");
		if (ActualInvalidEmail.equalsIgnoreCase("Please enter a valid email")) {
			Log.info("Validate successfull message");
		}
		driver.close();
		driver = null;
	}
}
