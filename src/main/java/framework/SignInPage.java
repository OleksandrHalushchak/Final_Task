package framework;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

  // 'No account? Create one here' link
  private final By createAccountLocator = By.xpath(
      "//div[@class='no-account']//a");



  public SignInPage createAccount() {
    find(createAccountLocator).click();
    return this;
  }

}
