package ui;

import framework.MainPage;
import framework.ProductComponent;
import java.util.List;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ProductsTests2 extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
  public void checkProductPrice() {
    String expectedName = "Argus All-Weather Tank";
    String expectedPrice = "$22.00";

    List<ProductComponent> products = mainPage.getAllProductsFromMainPage();

    ProductComponent productToCheck = null;

    for (ProductComponent product : products) {
      if (product.getName().equals(expectedName)) {
        productToCheck = product;
      }
    }

    Assertions.assertThat(Objects.requireNonNull(productToCheck).getPrice())
        .as("Product price should be $22.00")
        .isEqualTo(expectedPrice);
  }


}
