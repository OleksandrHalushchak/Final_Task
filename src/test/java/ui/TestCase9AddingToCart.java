package ui;


import components.Products;
import framework.Helpers;
import framework.MainPage;
import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class TestCase9AddingToCart extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkPriceDrop() {
    SoftAssertions softAssertions = new SoftAssertions();

    //In the search field enter 'Bear' and press 'Enter'
    mainPage.enterTextInSearchField("Bear");
    List<Products> products = Helpers.getAllProducts();

//On the 'SEARCH RESULTS' page click on 'Brown Bear Notebook

    String name = "Brown Bear Notebook";
    String productPrice = null;

    for (Products product : products) {
      String actualName = product.getName();
      if (name.equals(actualName)) {
        productPrice = product.getPrice();
        product.getNameWeb().click();
      }
    }

    mainPage.selectPaperType("Doted")
        .changeQuantity(Integer.parseInt("5"))
        .clickAddToCartButton();

    //Check that new window with title 'Product successfully added to your shopping cart' appears
    String expectedTitle = "Product successfully added to your shopping cart";
    String actualTitle = mainPage.getTitle();
    if (actualTitle.isEmpty()) {
    } else {
      actualTitle = actualTitle.substring(1);
    }
    softAssertions.assertThat(actualTitle)
        .as("EXPECTED " + expectedTitle)
        .isEqualTo(expectedTitle);

    //Check that correct 'Paper Type' is shown on the left side of the window
    String expectedPaperTyp = "Doted";
    String actualPaperTyp = mainPage.getPaperType();

    softAssertions.assertThat(actualPaperTyp)
        .as("EXPECTED " + expectedPaperTyp)
        .isEqualTo(expectedPaperTyp);

    //Check that correct 'Quantity' is shown on the left side of the window
    String expectedQuantity = "5";
    String actualQuantity = mainPage.getQuantity();

    softAssertions.assertThat(actualQuantity)
        .as("EXPECTED " + expectedQuantity)
        .isEqualTo(expectedQuantity);

    //Check that Check that 'Total' calculated correct
    productPrice = productPrice.substring(1);
    BigDecimal productPriceBD = new BigDecimal(productPrice);
    BigDecimal actualQuantityBD = new BigDecimal(actualQuantity);

    BigDecimal expectedTotalPriceBD = productPriceBD.multiply(actualQuantityBD);
    String expectedTotalPrice = expectedTotalPriceBD.toString();
    String actualTotalPrice = mainPage.getTotalPrice();
    actualTotalPrice = actualTotalPrice.substring(1);

    softAssertions.assertThat(actualTotalPrice)
        .as("EXPECTED " + expectedTotalPrice)
        .isEqualTo(expectedTotalPrice);

    softAssertions.assertAll();
  }


}
