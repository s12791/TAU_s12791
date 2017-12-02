package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	private final WebDriver driver;

	@FindBy(id = "customer_firstname")
	private WebElement firstName;

	@FindBy(id = "customer_lastname")
	private WebElement lastName;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "address1")
	private WebElement address;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "id_state")
	private WebElement state;

	@FindBy(id = "postcode")
	private WebElement postcode;

	@FindBy(id = "phone_mobile")
	private WebElement mobilePhone;

	@FindBy(id = "submitAccount")
	private WebElement buttonSubmit;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createAccount(String setFirstName, String setLastName, String setPassword, String setAddress,
			String setCity, String setState, String setPostcode, String setMobilePhone) {
		firstName.sendKeys(setFirstName);
		lastName.sendKeys(setLastName);
		password.sendKeys(setPassword);
		address.sendKeys(setAddress);
		state.sendKeys(setState);
		postcode.sendKeys(setPostcode);
		mobilePhone.sendKeys(setMobilePhone);
		city.sendKeys(setCity);
		buttonSubmit.click();
	}

	public WebElement getErrorMessagePostalCode() {
		WebElement eerror = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div"));
		return eerror;
	}
}
