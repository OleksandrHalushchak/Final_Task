package framework;

import com.github.javafaker.Faker;
import components.Products;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Helpers extends BasePage {

  // Product container locator
  private static final By productContainerLocator = By.xpath(
      "//article[@class='product-miniature js-product-miniature']");

  private static Faker faker = new Faker();

  public static String generateValidFirstName() {
    return faker.name().firstName();
  }

  public static String generateValidLastName() {
    return faker.name().lastName();
  }

  public static String generateValidEmail() {
    return faker.internet().emailAddress();
  }

  public static String generateValidPassword() {
    return faker.internet().password();
  }


  @SneakyThrows
  public static String generateValidBirthdate() {
    LocalDate localDate = LocalDate.now().minusYears(RandomUtils.nextInt(18, 60));
    SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat toFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = originalFormat.parse(localDate.toString());
    return toFormat.format(date);

  }

  // Get product list (containers) from page
  @SneakyThrows
  public static List<Products> getAllProducts() {
    waitUntilVisible(productContainerLocator, 20);
    List<Products> product = new ArrayList<>();
    List<WebElement> containers = findAll(productContainerLocator);
    for (WebElement container : containers) {
      Products productComponent = new Products(container);
      product.add(productComponent);
    }
    return product;
  }


}
