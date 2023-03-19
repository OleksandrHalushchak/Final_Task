package framework;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import org.openqa.selenium.By;

public class AllProductsPage extends BasePage {

  // Sort products locator
  private final By sortProductsLocator = By.xpath(
      "//button[@class='btn-unstyle select-title']");
  // Sort products dropdown-menu locator
  private final By sortProductsDropdownMenuLocator = By.xpath(
      "//div[@class='dropdown-menu']");

  // Sort products as 'Name, A to Z' locator
  private final By byNameAZ = By.xpath(
      "//div[@class='dropdown-menu']//a[contains(text(),'Name, A to Z')]");

// Sort products as 'Name, Z to A' locator
  private final By byNameZA = By.xpath(
      "//div[@class='dropdown-menu']//a[contains(text(),'Name, Z to A')]");

  // Sort products as 'Price, low to high' locator
  private final By byPriceLowHigh = By.xpath(
      "//div[@class='dropdown-menu']//a[contains(text(),'Price, low to high')]");

  // Sort products as 'Price, high to low' locator
  private final By byPriceHighLow = By.xpath(
      "//div[@class='dropdown-menu']//a[contains(text(),'Price, high to low')]");


  // Click Sort products dropdown-menu
  public AllProductsPage clickSortProductsLocator() {
    find(sortProductsLocator).click();
    return this;
  }

  //Sort products as 'Argument'
  public AllProductsPage sortByArgument(SortEnum value) {

    switch (value){
      case "Name, A to Z":
        .....
        break;
      case "Name, A to Z":
        .....
        break;

    }
    scroll(300);
    find(sortProductsLocator).click();
    selectByText(sortProductsDropdownMenuLocator, argument);
    return this;
  }



//Sort products as  'Name, A to Z'
  public AllProductsPage sortByNameAZ() {
    scroll(300);
    waitUntilVisible(sortProductsLocator, 10);
    find(sortProductsLocator).click();
    find(byNameAZ).click();
    return this;
  }
//Sort products as  'Name, Z to A'
    public AllProductsPage sortByNameZA() {
      scroll(300);
      find(sortProductsLocator).click();
      find(byNameZA).click();
      return this;
  }

    //Sort products as  'Price, low to high '
  public AllProductsPage sortByPriceLowHigh() {
    scroll(300);
    find(sortProductsLocator).click();
    find(byPriceLowHigh).click();
    return this;
  }

    //Sort products as  'Price, high to low'
  public AllProductsPage sortByPriceHighLow() {
    scroll(300);
    find(sortProductsLocator).click();
    find(byPriceHighLow).click();
    return this;
  }

  public static List<String> sortProductsListAZ(List<String> ListNames) {
    List<String> sortListNamesAZ = new ArrayList<>();
    sortListNamesAZ = ListNames;
    Collections.sort(sortListNamesAZ);
    return sortListNamesAZ;

  }
  public static List<String> sortProductsListZA(List<String> ListNames) {
    List<String> sortListNamesZA = new ArrayList<>();
    sortListNamesZA = ListNames;
    Collections.sort(sortListNamesZA);
    Collections.reverse(sortListNamesZA);
    return sortListNamesZA;

  }


}
