package ui;


import components.Products;
import framework.MainPage;
import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class TestCase10CheckoutEndToEnd extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkEndToEnd() {
    SoftAssertions softAssertions = new SoftAssertions();

    List<Products> products = mainPage.enterTextInSearchField("Mug")
        .getAllProducts();

//On the 'SEARCH RESULTS' page click on 'Brown Bear Notebook

    String name = "Customizable Mug";

    for (Products product : products) {
      String actualName = product.getName();
      if (name.equals(actualName)) {
       product.getNameWeb().click();
      }
    }
//  mainPage.enterTextProductCustomization("Best mug ever")
//      .getQuantity();

//    Enter 'Best mug ever' in 'Product customization' field
//    Click 'SAVE CUSTOMIZATION'
//    Change 'Quantity' to '1' if not '1' already
//    Click 'ADD TO CART' button






    softAssertions.assertAll();
  }


}
