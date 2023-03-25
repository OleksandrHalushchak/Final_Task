package ui;

import components.Products;
import framework.Helpers;
import framework.MainPage;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

@Log4j2
public class TestCase6CheckPopularProducts extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkPopularProducts() {
    SoftAssertions softAssertions = new SoftAssertions();

    //Check that 8 products exist in 'POPULAR PRODUCTS' section
    int expctedNumberOfProducts = 8;
    log.info("Check that {} products exist in 'POPULAR PRODUCTS' section",
        expctedNumberOfProducts);

    List<Products> products = Helpers.getAllProducts();
    int actualNumberOfProducts = products.size();

    softAssertions.assertThat(actualNumberOfProducts)
        .as("EXPECTED" + expctedNumberOfProducts)
        .isEqualTo(expctedNumberOfProducts);



    // Check that  product list not empty
    log.info("Check that  product list not empty");
    softAssertions.assertThat(products)
        .as("EXPECTED that list not empty")
        .isNotNull();

    log.info("Check that every product has name");
    log.info("Check that every product has price");
    log.info("Check that every product  price bigger than 0.00");

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
