package ui;

import static framework.AllProductsPage.*;
import static framework.AllProductsPage.SortEnum.NameAtoZ;
import static framework.AllProductsPage.SortEnum.NameZtoA;
import static framework.AllProductsPage.SortEnum.PriceHighToLow;
import static framework.AllProductsPage.SortEnum.PriceLowToHigh;

import components.Products;
import framework.MainPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import java.util.ArrayList;
import framework.AllProductsPage;


public class TestCase8SortingCheck extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkPopularProducts() {
    SoftAssertions softAssertions = new SoftAssertions();

    // Check that sorting 'Name, A to Z' is correct
    List<String> listNamesAZ = new ArrayList<>();
    List<Products> productsAZ = mainPage.clickAllProductsLink().sortByArgument(NameAtoZ).getAllProducts();
    for (Products product : productsAZ) {
      String name = product.getName();
      listNamesAZ.add(name);
      listNamesAZ.add("; ");
    }

    List<String> sortListNamesAZ = sortProductsListAZ(listNamesAZ);
    String stringNamesAZ = String.join(" ", listNamesAZ);
    String stringSortNamesAZ = String.join(" ", sortListNamesAZ);
    softAssertions.assertThat(stringNamesAZ)
        .as("EXPECTED sorted list")
        .isEqualTo(stringSortNamesAZ+"1");

    // Check that sorting 'Name, Z to A' is correct
    List<String> listNamesZA = new ArrayList<>();
    List<Products> productsZA = mainPage.clickAllProductsLink().sortByArgument(NameZtoA).getAllProducts();
    for (Products product : productsZA) {
      String name = product.getName();
      listNamesZA.add(name);
      listNamesZA.add("; ");
    }

    List<String> sortListNamesZA = sortProductsListAZ(listNamesZA);
    String stringNamesZA = String.join(" ", listNamesZA);
    String stringSortNamesZA = String.join(" ", sortListNamesZA);
    softAssertions.assertThat(stringNamesZA)
        .as("EXPECTED sorted list")
        .isEqualTo(stringSortNamesZA+"1");

    // Check that sorting 'Price, low to high' is correct
    List<String> listPriceLowHigh = new ArrayList<>();
    List<Products> productsLowHigh = mainPage.clickAllProductsLink().sortByArgument(PriceLowToHigh).getAllProducts();
    for (Products product : productsLowHigh) {
      String name = product.getName();
      listPriceLowHigh.add(name);
      listPriceLowHigh.add("; ");
    }

    List<String> sortListPriceLowHigh = sortProductsListAZ(listPriceLowHigh);
    String stringPriceLowHigh = String.join(" ", listPriceLowHigh);
    String stringSortPriceLowHigh = String.join(" ", sortListPriceLowHigh);
    softAssertions.assertThat(stringPriceLowHigh)
        .as("EXPECTED sorted list")
        .isEqualTo(stringSortPriceLowHigh+"1");

// Check that sorting 'Price, high to low' is correct
    List<String> listPriceHighLow = new ArrayList<>();
    List<Products> productsHighLow = mainPage.clickAllProductsLink().sortByArgument(PriceHighToLow).getAllProducts();
    for (Products product : productsHighLow) {
      String name = product.getName();
      listPriceHighLow.add(name);
      listPriceHighLow.add("; ");
    }

    List<String> sortListPriceHighLow = sortProductsListAZ(listPriceHighLow);
    String stringPriceHighLow = String.join(" ", listPriceHighLow);
    String stringSortPriceHighLow = String.join(" ", sortListPriceHighLow);
    softAssertions.assertThat(stringPriceHighLow)
        .as("EXPECTED sorted list")
        .isEqualTo(stringSortPriceHighLow+"1");

 softAssertions.assertAll();
  }
}
