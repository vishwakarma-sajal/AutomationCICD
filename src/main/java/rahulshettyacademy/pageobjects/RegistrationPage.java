package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class RegistrationPage extends AbstractComponent {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstName")
	private WebElement firstNameEle;

	@FindBy(id = "lastName")
	private WebElement lastNameEle;

	@FindBy(id = "userEmail")
	private WebElement emailEle;

	@FindBy(id = "userPassword")
	private WebElement passwordEle;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPasswordEle;

	@FindBy(id = "login")
	private WebElement registerBtn;

	@FindBy(css = "[class*='flyInOut']")
	private WebElement errorMessage;

	private By successMessage = By.cssSelector(".hero-primary");

	public void registerUser(String firstName, String lastName, String email, String password,
			String confirmPassword) {
		firstNameEle.sendKeys(firstName);
		lastNameEle.sendKeys(lastName);
		emailEle.sendKeys(email);
		passwordEle.sendKeys(password);
		confirmPasswordEle.sendKeys(confirmPassword);
		registerBtn.click();
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public String getSuccessMessage() {
		waitForElementToAppear(successMessage);
		WebElement successEle = driver.findElement(successMessage);
		return successEle.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}

