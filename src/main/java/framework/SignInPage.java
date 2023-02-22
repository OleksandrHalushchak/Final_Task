package framework;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

  private final By emailFieldLocator = By.id("email");
  private final By passwordFieldLocator = By.id("pass");
  private final By signInButtonLocator = By.xpath(
      "//button[@id='send2' and contains(@class,'primary')]");
  private final By errorMessageLocator = By.xpath("//div[@data-ui-id='message-error']/div");


  public SignInPage enterEmail(String email) {
    find(emailFieldLocator).sendKeys(email);
    return this;
  }

  public SignInPage enterPassword(String password) {
    find(passwordFieldLocator).sendKeys(password);
    return this;
  }

  public SignInPage clickSignInButtonWithExpectedFail() {
    find(signInButtonLocator).click();
    return this;
  }

  public String getErrorMessage() {
    return find(errorMessageLocator).getText();
  }


}
