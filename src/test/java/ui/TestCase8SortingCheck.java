package ui;

import components.Products;
import framework.MainPage;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class TestCase8SortingCheck extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkPopularProducts() {
    SoftAssertions softAssertions = new SoftAssertions();

    mainPage.clickAllProductsLink().sortByNameAZ();

    List<Products> products = mainPage.getAllProducts();

    // Check that  product list not empty
    softAssertions.assertThat(products)
        .as("EXPECTED that list not empty")
        .isNotEmpty();
    List<String> names = new ArrayList<>();

    for (Products product : products) {
      // Check that every product has name
      String name = product.getName();
      names.add(name);
    }

    String stringNames = String.join(" ", names);
    softAssertions.assertThat(stringNames)
        .as("EXPECTED")
        .isEqualTo("stringNames");


 softAssertions.assertAll();
  }
}
