package framework;

import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
  private final By buttomPageTextUnderEmailFieldLocator = By.xpath("//div[@class='col-xs-12']//p");

  //'SUBSCRIBE' button on the buttom of the page
  private final By SubscribeButtonLocator = By.xpath("//input[@value='Subscribe']");

  //Language dropdown
  private final By languageDropdownLocator = By.id("_desktop_language_selector");

  //Language dropdown list
  private final By languageDropdownListLocator = By.xpath("//*[@class='dropdown-item']");

  //SignIn Link
  private final By signInLinkLocator = By.xpath("//span[@class='hidden-sm-down']");
  //Menu Clothes
  private final By menuClothesLocator = By.id("category-3");

  //Menu Accessories
  private final By menuAccessoriesLocator = By.id("category-6");

  //Menu Art
  private final By menuArtLocator = By.id("category-9");

  //sub menu items
  private final By subMenuClothesLocator = By.xpath("//*[@id='category-3']//li//a");
  private final By subMenuAccessoriesLocator = By.xpath("//*[@id='category-6']//li//a");
  private final By subMenuArtLocator = By.xpath("//*[@id='category-9']//li//a");

  // 'All products >' under the 'POPULAR PRODUCTS' section
  private final By allProductsLocator = By.xpath(
      "//a[@class='all-product-link float-xs-left float-md-right h4']");

  // Prices drop locator at the bottom of the page
  private final By pricesDropLocator = By.id("link-product-page-prices-drop-1");

  // Search field locator
  private final By searchFieldLocator = By.xpath("//input[@name='s']");

  //'Paper type' selector
  private final By paperTypeSelectorLocator = By.id("group_4");

  //'Quantity' Locator
  private final By quantityLocator = By.xpath("//i[@class='material-icons touchspin-up']");

  //'ADD TO CART' button
  private final By addToCartButtonLocator = By.xpath("//div[@class='add']//button");

  //shopping cart title 'Product successfully added to your shopping cart'
  private final By windowTitleLocator = By.id("myModalLabel");

  //shopping cart 'Paper Type'
  private final By paperTypeShoppingCartLocator = By.xpath("//span[@class='paper type']//strong");

  //shopping cart 'Quantity'
  private final By quantityShoppingCartLocator = By.xpath(
      "//span[@class='product-quantity']//strong");

  //shopping cart 'Total' price
  private final By totalPriceShoppingCartLocator = By.xpath("//span[@class='value']");

  // 'Product customization' field
  private final By productCustomizationFieldLocator = By.id("field-textField1");

  // 'SAVE CUSTOMIZATION' button
  private final By saveCustomizationButtonLocator = By.xpath(
      "//button[@name='submitCustomizedData']");

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
    log.info("Click on language dropdown");
    List<WebElement> languageList = findAll(languageDropdownListLocator);
    List<String> list = new ArrayList<>();
    for (WebElement webElement : languageList) {
      list.add(webElement.getText());
    }
    log.info("list of languages is collected");
    return list;
  }

  // Click on 'Sign in' button at the right corner of the page
  public SignInPage clickSignIn() {
    find(signInLinkLocator).click();
    log.info("Click on 'Sign in' button");
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
    find(pricesDropLocator).click();
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

  // In the search field enter text press 'Enter'
  public MainPage enterTextInSearchField(String productName) {
    WebElement searchField = find(searchFieldLocator);
    searchField.sendKeys(productName);
    searchField.sendKeys(Keys.RETURN);
    return this;
  }

  // Select 'Paper type'
  public MainPage selectPaperType(String paperType) {
    waitUntilVisible(paperTypeSelectorLocator, 5);
    selectByText(paperTypeSelectorLocator, paperType);
    return this;
  }

  // Change 'Quantity' to '5'
  public MainPage changeQuantity(int quantity) {

    for (int i = 1; i < quantity; i++) {
      find(quantityLocator).click();
    }
    return this;
  }

  // Click 'ADD TO CART' button
  public MainPage clickAddToCartButton() {
    find(addToCartButtonLocator).click();
    return this;
  }

  // Get shopping cart title
  public String getTitle() {
    waitUntilAppear(windowTitleLocator, 20);
    return find(windowTitleLocator).getText();
  }

  // Get shopping cart 'Paper Type'
  public String getPaperType() {
    return find(paperTypeShoppingCartLocator).getText();
  }

  // Get shopping cart 'Quantity'
  public String getQuantity() {
    return find(quantityShoppingCartLocator).getText();
  }

  // Get shopping cart 'Total' price
  public String getTotalPrice() {
    return find(totalPriceShoppingCartLocator).getText();
  }


  // Enter text in 'Product customization' field and save
  public MainPage enterTextProductCustomization(String text) {
    find(productCustomizationFieldLocator).sendKeys(text);
    find(saveCustomizationButtonLocator).click();
    return this;
  }

}

