package framework;

import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j2
public class MainPage extends BasePage {

  // Loading Message
  private static final By loadingMessageLocator = By.id("loadingMessage");
//frame Locator
   private final By frameLocator = By.id("framelive");

  //text on the buttom of the page near the email field
  private final By buttomPageTextNearEmailFieldLocator = By.id("block-newsletter-label");

  //text on the buttom of the page under the email field
  private final By buttomPageTextUnderEmailFieldLocator = By.xpath(
      "//div[@class='col-xs-12']//p");

  //'SUBSCRIBE' button on the buttom of the page
  private final By SubscribeButtonLocator = By.xpath(
      "//input[@value='Subscribe']");

  //Language dropdown
  private final By languageDropdownLocator = By.id("_desktop_language_selector");

  //Language dropdown list
  private final By languageDropdownListLocator = By.xpath(
      "//ul[@class='dropdown-menu hidden-sm-down']");

  //SignIn Link
  private final By signInLinkLocator = By.xpath(
      "//span[@class='hidden-sm-down']");


  // wait while the home page loads
  public  MainPage waitUntilHomePageLoad() {
    waitUntilAppear(loadingMessageLocator, 10);
    log.info("The spinner appeared");
    waitUntilDisappear(loadingMessageLocator, 20);
    log.info("Tests waits while The spinner disappeared");
    return this;
  }

  // Get text  near the email field on the buttom of the page
  public String getButtomPageTextNearEmailField() {
      log.info("Page scrolls down");
   scrollPageBottom();
    scroll(2000);
    waitUntilVisible(buttomPageTextNearEmailFieldLocator, 20);
    log.info("Getting text near email field");
    return find(buttomPageTextNearEmailFieldLocator).getText();
  }

  // Get text  under the email field on the buttom of the page
  public String getButtomPageTextUnderEmailField() {
    log.info("Getting text under email field");
    return find(buttomPageTextUnderEmailFieldLocator).getText();
  }

  // Get text  under the email field on the buttom of the page
  public String getSubscribeButtonName() {
    log.info("Getting button name");
    return find(SubscribeButtonLocator).getText();
  }

  // public String clickLanguageDropdown() {
  //   return find(languageDropdownLocator).click();
//  }
  @SneakyThrows
  public List<WebElement> getLanguageList() {
    find(languageDropdownLocator).click();
    return findAll(languageDropdownListLocator);
  }
  @SneakyThrows
  public String isUkrainianLanguagePresent(String language1) {
    find(languageDropdownLocator).click();
    List<WebElement> languageList = getLanguageList();
    for (WebElement language : languageList) {
      if (language.getText().equals(language1)) {
        return "UkrainianLanguagePresent";
      }
    }
    return "UkrainianLanguageNotPresent";
  }
  // Click on 'Sign in' button at the right corner of the page

  public SignInPage clickSignIn() {
    find(signInLinkLocator).click();
    return new SignInPage();
  }


}

