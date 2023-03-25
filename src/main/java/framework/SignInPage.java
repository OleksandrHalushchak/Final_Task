package framework;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class SignInPage extends BasePage {

  // 'No account? Create one here' link
  private final By createAccountLocator = By.xpath(
      "//div[@class='no-account']//a");
  //name near cart button
  private final By nameNearCartButtonLocator = By.xpath(
      "//a[@class='account']//span[@class='hidden-sm-down']");

  public CreateAccountPage clickCreateAccount() {
    waitUntilVisible(createAccountLocator, 10);
    log.info("Wait until text 'No account? Create one here' will visible");
    find(createAccountLocator).click();
    log.info("Click on link 'No account? Create one here'");
    return new CreateAccountPage();
  }

  public String getUserNameNearCartButton() {
    waitUntilVisible(nameNearCartButtonLocator, 5);
    log.info("Wait until name near cart button will visible");
    String name = find(nameNearCartButtonLocator).getText();
    log.info("Get name? which appear near cart button");
    return name;
  }

}
