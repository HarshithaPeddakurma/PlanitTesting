package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
	WebDriver driver;

	@FindBy(css = "a.btn-contact.btn.btn-primary")
	WebElement Submit;
	@FindBy(id = "forename-err")
	WebElement ForenameError;
	@FindBy(id = "email-err")
	WebElement EmailError;
	@FindBy(id = "message-err")
	WebElement MessageError;
	@FindBy(id = "forename")
	WebElement Forename;
	@FindBy(id = "email")
	WebElement Email;
	@FindBy(id = "message")
	WebElement Message;
	@FindBy(css = "div.alert.alert-success")
	WebElement AlertSuccess;
	@FindBy(xpath = "//a[contains(text(),'« Back')]")
	WebElement InvalidEmail;
	

	public Contact(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement Submit() {
		return Submit;
	}

	public WebElement ForenameError() {
		return ForenameError;
	}

	public WebElement EmailError() {
		return EmailError;
	}

	public WebElement MessageError() {
		return MessageError;
	}

	public WebElement Forename() {
		return Forename;
	}
	public WebElement Email() {
		return Email;
	}
	public WebElement Message() {
		return Message;
	}
	public WebElement AlertSuccess() {
		return AlertSuccess;
	}
	public WebElement InvalidEmail() {
		return InvalidEmail;
	}
}