package framework;
import components.Products;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
      "//*[@class='dropdown-item']");

  //SignIn Link
  private final By signInLinkLocator = By.xpath(
      "//span[@class='hidden-sm-down']");
  //Menu Clothes
  private final By menuClothesLocator = By.id("category-3");

  //Menu Accessories
  private final By menuAccessoriesLocator = By.id("category-6");

  //Menu Art
  private final By menuArtLocator = By.id("category-9");

  //sub menu items
  private final By subMenuClothesLocator = By.xpath(
      "//*[@id='category-3']//li//a");
  private final By subMenuAccessoriesLocator = By.xpath(
      "//*[@id='category-6']//li//a");
  private final By subMenuArtLocator = By.xpath(
      "//*[@id='category-9']//li//a");

  // 'All products >' under the 'POPULAR PRODUCTS' section
  private final By allProductsLocator = By.xpath(
      "//a[@class='all-product-link float-xs-left float-md-right h4']");


  // Prices drop locator at the bottom of the page
  private final By PricesDropLocator = By.id("link-product-page-prices-drop-1");


  // wait while the home page loads
  public MainPage waitUntilHomePageLoad() {
    try {
      waitUntilAppear(loadingMessageLocator, 10);
    } catch (TimeoutException e) {
      log.info("There is no any spinner");
    }
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


  @SneakyThrows
  public List<String> getAllLanguages() {
    find(languageDropdownLocator).click();
    List<WebElement> languageList = findAll(languageDropdownListLocator);
    List<String> list = new ArrayList<>();
    for (WebElement webElement : languageList) {
      list.add(webElement.getText());
    }
    return list;
  }
  // Click on 'Sign in' button at the right corner of the page

  public SignInPage clickSignIn() {
    find(signInLinkLocator).click();
    return new SignInPage();
  }

  public List<String> getClothesCategoriesList() {
    hoverMouse(menuClothesLocator);
    waitUntilVisible(menuClothesLocator, 10);
    List<String> clothesCategories = new ArrayList<>();
    List<WebElement> category = findAll(subMenuClothesLocator);
    for (WebElement webElement : category) {
      clothesCategories.add(webElement.getText());
    }
    return clothesCategories;
  }

  public List<String> getAccessorCategoriesList() {
    hoverMouse(menuAccessoriesLocator);
    waitUntilVisible(menuAccessoriesLocator, 10);
    List<String> accessorCategories = new ArrayList<>();
    List<WebElement> category = findAll(subMenuAccessoriesLocator);
    for (WebElement webElement : category) {
      accessorCategories.add(webElement.getText());
    }
    return accessorCategories;
  }

  public List<String> getArtCategoriesList() {
    hoverMouse(menuArtLocator);
    waitUntilVisible(menuArtLocator, 10);
    List<String> artCategories = new ArrayList<>();
    List<WebElement> category = findAll(subMenuArtLocator);
    for (WebElement webElement : category) {
      artCategories.add(webElement.getText());
    }
    return artCategories;
  }


  // At the bottom of the page click on 'Prices drop' link
  public PriceDropPage clickPricesDrop() {
    scrollPageBottom();
    log.info("Page scrolls down");
    find(PricesDropLocator).click();
    log.info("click Prices drop");
    return new PriceDropPage();
  }

  // click on 'All products' link
  public AllProductsPage clickAllProductsLink() {
    scroll(1000);
    log.info("Page scrolls down");
    find(allProductsLocator).click();
    log.info("click on 'All products' link");
    return new AllProductsPage();
  }

}