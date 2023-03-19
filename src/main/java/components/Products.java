package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class Products {

  private final WebElement nameWeb;
  private final String name;
  private final String price;
  private final String oldPrice;
  private final String discount;

  // private WebElement CompareThisProduct;

  public Products(WebElement container) {
    this.nameWeb = container.findElement(By.xpath("//*[@class='h3 product-title']//a"));
    this.name = nameWeb.getText();
    this.price = container.findElement(By.xpath("//span[@class='price']")).getText();

 //   try {
      this.oldPrice = container.findElement(By.xpath("//span[@class='regular-price']"))
          .getText();
  //  } catch (NoSuchElementException e) {
  //    this.oldPrice = null;
 //   }
  //  try {
      this.discount = container.findElement(By.xpath("//li[@class='product-flag "
          + "discount']")).getText();
 //   } catch (NoSuchElementException e) {
 //     this.discount = null;
  //  }

  }


}
