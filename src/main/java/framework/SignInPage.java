package framework;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

  // 'No account? Create one here' link
  private final By createAccountLocator = By.xpath(
      "//div[@class='no-account']//a");
  //name near cart button
  private final By nameNearCartButtonLocator = By.xpath(
      "//a[@class='account']//span[@class='hidden-sm-down']");



  public CreateAccountPage clickCreateAccount() {
    waitUntilVisible(createAccountLocator, 10);
    find(createAccountLocator).click();
    return new CreateAccountPage();
  }
  public String getUserNameNearCartButton() {
    waitUntilVisible(nameNearCartButtonLocator, 5);
    return find(nameNearCartButtonLocator).getText();
  }

}
