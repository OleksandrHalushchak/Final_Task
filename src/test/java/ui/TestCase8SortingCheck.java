package ui;

import components.Products;
import framework.AllProductsPage;
import framework.AllProductsPage.SortEnum;
import framework.Helpers;
import framework.MainPage;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class TestCase8SortingCheck extends BaseTest {

  private final MainPage mainPage = new MainPage();
  private final AllProductsPage allProductsPage = new AllProductsPage();

  @Test

  public void checkPopularProducts() {
    SoftAssertions softAssertions = new SoftAssertions();

    //Check that sorting products as 'Name, A to Z' is correct
    mainPage.clickAllProductsLink().sortByArgument(SortEnum.NameAtoZ);
    List<Products> productsAZ = Helpers.getAllProducts();

    List<String> namesAZ = new ArrayList<>();
    for (Products productAZ : productsAZ) {
      String nameAZ = productAZ.getName();
      namesAZ.add(nameAZ);
    }
    List<String> sortNamesAZ = namesAZ;
    Collections.sort(sortNamesAZ);

    softAssertions.assertThat(namesAZ)
        .as("EXPECTED")
        .isEqualTo(sortNamesAZ);

//Check that sorting products as 'Name, Z to A' is correct
    AllProductsPage.sortByArgument(SortEnum.NameZtoA);
    List<Products> productsZA = Helpers.getAllProducts();

    List<String> namesZA = new ArrayList<>();
    for (Products product : productsZA) {
      String nameZA = product.getName();
      namesZA.add(nameZA);
    }
    List<String> sortNamesZA = namesZA;
    Collections.sort(sortNamesZA);
    Collections.reverse(sortNamesZA);

    softAssertions.assertThat(namesZA)
        .as("EXPECTED")
        .isEqualTo(sortNamesZA);

    //Check that sorting products as 'Price, low to high' is correct
   AllProductsPage.sortByArgument(SortEnum.PriceLowToHigh);
    List<Products> productsPL = Helpers.getAllProducts();

    List<String> prisesPL = new ArrayList<>();
    for (Products product : productsPL) {
      String prisePL = product.getPrice();
      prisesPL.add(prisePL);
    }
    List<String> sortprisesPL = prisesPL;
    Collections.sort(sortprisesPL);


    softAssertions.assertThat(prisesPL)
        .as("EXPECTED")
        .isEqualTo(sortprisesPL);

    //Check that sorting products as 'Price, high to low' is correct
    AllProductsPage.sortByArgument(SortEnum.PriceLowToHigh);
    List<Products> productsHL = Helpers.getAllProducts();

    List<String> prisesHL = new ArrayList<>();
    for (Products product : productsHL) {
      String priseHL = product.getName();
      prisesHL.add(priseHL);
    }
    List<String> sortprisesHL = prisesHL;
    Collections.sort(sortprisesHL);
    Collections.reverse(sortprisesHL);

    softAssertions.assertThat(prisesHL)
        .as("EXPECTED")
        .isEqualTo(sortprisesHL);

    softAssertions.assertAll();
  }
}
