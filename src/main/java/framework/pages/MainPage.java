package framework.pages;

import framework.pages.components.ProductComponent;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

  private final By signLinkLocator = By.xpath(
      "//div[@class='panel header']//li[@class='authorization-link']/a");
  private final By productContainerLocator = By.xpath("//li[@class='product-item']");
  private final By priceDropdownLocator = By.id("input");
  private final By countDropdownLocator = By.id("input");

  public SignInPage clickOnSignInLink() {
    find(signLinkLocator).click();
    return new SignInPage();
  }


  @SneakyThrows
  public List<ProductComponent> getAllProductsFromMainPage() {
    List<ProductComponent> products = new ArrayList<>();
    List<WebElement> containers = findAll(productContainerLocator);
    for (WebElement container : containers) {
      ProductComponent productComponent = new ProductComponent(container);
      products.add(productComponent);
    }
    return products;
  }

  @SneakyThrows
  public ProductComponent getProductByName(List<ProductComponent> products,
      String nameToSearch) {

    for (ProductComponent product : products) {
      if (product.getName().equals(nameToSearch)) {
        return product;
      }
    }
    return new ProductComponent();
  }


  public void selectFromPriceDropdown(String value) {
    selectByText(priceDropdownLocator, value);
  }

  public String getValueFromPriceDropDown() {
    return getSelectedValue(priceDropdownLocator);
  }

  public String getValueFromCountDropDown() {
    return getSelectedValue(countDropdownLocator);
  }

}
