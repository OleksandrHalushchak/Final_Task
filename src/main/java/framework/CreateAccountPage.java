package framework;

import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {

  private final By createAccountSocialTitleLocator = By.id("id('field-id_gender-1')");
  private final By createAccountFirstNameFieldLocator = By.id("id('field-firstname')");
  private final By createAccountLastNameFieldLocator = By.id("id('field-lastname')");
  private final By createAccountEmailFieldLocator = By.id("id('field-email')");
  private final By createAccountPasswordFieldLocator = By.id("id('field-password')");
  private final By createAccountBirthdateFieldLocator = By.id("id('field-birthday')");
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
    return this;
  }

  // Click SAVE (valid data)
  public SignInPage clickSaveButtonValidData() {
    find(createAccountSaveButtonLocator).click();
    return new SignInPage();
  }
  // Click SAVE (invalid data)
  public CreateAccountPage clickSaveButtonInvalidData() {
    find(createAccountSaveButtonLocator).click();
    return this;
  }

  public String getPopUpText() {
    return find(popUpFieldLocator).getText();
  }

  public String getLineColor() {
   return find(createAccountFirstNameFieldLocator).getCssValue(getLineColor());
  }
}
