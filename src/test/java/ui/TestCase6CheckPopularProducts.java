package ui;

import components.Products;
import framework.Helpers;
import framework.MainPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class TestCase6CheckPopularProducts extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkPopularProducts() {
    SoftAssertions softAssertions = new SoftAssertions();

    //Check that 8 products exist in 'POPULAR PRODUCTS' section
    int expctedNumberOfProducts = 8;

    int actualNumberOfProducts = Helpers.getAllProducts().size();

    softAssertions.assertThat(actualNumberOfProducts)
        .as("EXPECTED" + expctedNumberOfProducts)
        .isEqualTo(expctedNumberOfProducts);

    // Get product list
    List<Products> products = Helpers.getAllProducts();

    // Check that  product list not empty
    softAssertions.assertThat(products)
        .as("EXPECTED that list not empty")
        .isNotNull();

    for (Products product : products) {

      // Check that every product has name
      String actualProductName = product.getName();
      softAssertions.assertThat(actualProductName)
          .as("EXPECTED that field not empty")
          .isNotNull();

      // Check that every product has price
      String actualProductPrice = product.getPrice();
      softAssertions.assertThat(actualProductPrice)
          .as("EXPECTED that field not empty")
          .isNotNull();

      // Check that every product  price bigger than 0.00
      actualProductPrice = actualProductPrice.substring(1);
      double actualProductPriceDouble = Double.parseDouble(actualProductPrice);
      softAssertions.assertThat(actualProductPriceDouble)
          .as("EXPECTED that all prices bigger than 0.00")
          .isGreaterThan(0);
    }

    softAssertions.assertAll();
  }
}
