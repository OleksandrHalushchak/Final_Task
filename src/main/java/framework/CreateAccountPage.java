package framework;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class CreateAccountPage extends BasePage {

  private final By createAccountSocialTitleLocator = By.id("field-id_gender-1");
  private final By createAccountFirstNameFieldLocator = By.id("field-firstname");
  private final By createAccountLastNameFieldLocator = By.id("field-lastname");
  private final By createAccountEmailFieldLocator = By.id("field-email");
  private final By createAccountPasswordFieldLocator = By.id("field-password");
  private final By createAccountBirthdateFieldLocator = By.id("field-birthday");
  private final By createAccountCustomerPrivacyLocator = By.xpath(
      "//input[@name='customer_privacy']");
  private final By createAccountCustomerIAgreeLocator = By.xpath(
      "//input[@name='psgdpr']");
  private final By createAccountSaveButtonLocator = By.xpath(
      "//footer[@class='form-footer clearfix']//button");
  // pop-up under field
  private final By popUpFieldLocator = By.xpath(
      "//div[@class='help-block']//li");

  // Create Account
  public CreateAccountPage createAccount(String FirstName, String LastName, String Email,
      String Password, String Birthdate) {
    waitUntilVisible(createAccountSocialTitleLocator, 5);
    find(createAccountSocialTitleLocator).click();
    // Fill first name
    find(createAccountFirstNameFieldLocator).sendKeys(FirstName);
    // Fill last name
    find(createAccountLastNameFieldLocator).sendKeys(LastName);
    // Fill Email
    find(createAccountEmailFieldLocator).sendKeys(Email);
    // Fill Password
    find(createAccountPasswordFieldLocator).sendKeys(Password);
    // Fill Birthdate
    find(createAccountBirthdateFieldLocator).sendKeys(Birthdate);
    // Сheckbox сustomer data privacy
    find(createAccountCustomerPrivacyLocator).click();
    // Сheckbox I agree
    find(createAccountCustomerIAgreeLocator).click();
    log.info("Account Created with FirstName - {}; LastName - {}; Email - {}; Password - {};"
        + " Birthdate - {}", FirstName, LastName, Email, Password, Birthdate);
    return this;
  }

  // Click SAVE (valid data)
  public SignInPage clickSaveButtonValidData() {
    find(createAccountSaveButtonLocator).click();
    log.info("Click save");
    return new SignInPage();
  }

  // Click SAVE (invalid data)
  public void clickSaveButtonInvalidData() {
    find(createAccountSaveButtonLocator).click();
    log.info("Click save");
  }

  // Get pop up text appear under field
  public String getPopUpText() {
    waitUntilVisible(popUpFieldLocator, 5);
    log.info("Get pop up text appear under field");
    return find(popUpFieldLocator).getText();
  }

  // Get higlighted colof of fild 'First name'
  public String getLineColor() {
    log.info("Get higlighted colof of fild 'First name'");
    return getDriver().findElement(createAccountFirstNameFieldLocator)
        .getCssValue("outline");
  }
}
