package ui;

import com.github.javafaker.Faker;
import framework.pages.MainPage;
import framework.pages.components.ProductComponent;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class FakerTest {

  private final Faker faker = new Faker();

  @Test
  public void fakerTest() {
    MainPage mainPage = new MainPage();
    mainPage.selectFromPriceDropdown("Price low to high");

    String valueFromCountDropDown = mainPage.getValueFromCountDropDown();
    String valueFromPriceDropDown = mainPage.getValueFromPriceDropDown();

    List<ProductComponent> products = mainPage.getAllProductsFromMainPage();

    ProductComponent canon = mainPage.getProductByName(products, "Canon");

    ProductComponent nikon = mainPage.getProductByName(products, "Nikon");

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(canon.getPrice())
        .as("")
        .isEqualTo("122.00");
    softAssertions.assertThat(nikon.getPrice())
        .as("")
        .isEqualTo("99.00");
    softAssertions.assertAll();
    //assert price
    ;

  }
}
