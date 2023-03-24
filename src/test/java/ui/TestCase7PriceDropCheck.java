package ui;

import components.Products;
import framework.Helpers;
import framework.MainPage;
import framework.PriceDropPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class TestCase7PriceDropCheck extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkPriceDrop() {
    SoftAssertions softAssertions = new SoftAssertions();

    //Check that every product has old and new price
    mainPage.clickPricesDrop();
    List<Products> products = Helpers.getAllProducts();

    // Check that  product list not empty
    softAssertions.assertThat(products)
        .as("EXPECTED that list not empty")
        .isNotEmpty();

    for (Products product : products) {

      // Check that every product has old price
      String actualProductOldPrice = product.getOldPrice();
      softAssertions.assertThat(actualProductOldPrice)
          .as("EXPECTED that product has old price")
          .isNotEmpty();

      // Check that every product  has new price
      String actualProductPrice = product.getPrice();
      softAssertions.assertThat(actualProductPrice)
          .as("EXPECTED that product has new price")
          .isNotEmpty();

      // Check that promo price for every product calculates correct
      String actualProductDiscount = product.getDiscount();
      String expectedProductPrice = PriceDropPage.calculatePromoPrice(actualProductOldPrice,
          actualProductDiscount);

      actualProductPrice = actualProductPrice.substring(1);

      softAssertions.assertThat(actualProductPrice)
          .as("EXPECTED " + expectedProductPrice)
          .isEqualTo(expectedProductPrice);

    }

    softAssertions.assertAll();
  }
}
