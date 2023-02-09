package framework.pages.components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class ProductComponent {

  private WebElement image;
  private WebElement nameWe;
  private String name;
  private String rating;
  private String price;
  private String reviews;

  public ProductComponent() {
  }

  public ProductComponent(WebElement container) {
    this.image = container.findElement(By.xpath(".//img[@class='product-image-photo']"));
    this.nameWe = container.findElement(By.xpath(".//a[@class='product-item-link']"));
    this.name = nameWe.getText();
    try {
      this.rating = container.findElement(By.xpath(".//div[@class='rating-result']"))
          .getAttribute("title");
    } catch (NoSuchElementException e) {
      this.rating = null;
    }
    this.price = container.findElement(By.xpath(".//span[@class='price']")).getText();
    try {
      this.reviews = container.findElement(By.xpath(".//a[@class='action view']")).getText();
    } catch (NoSuchElementException e) {
      this.reviews = null;
    }
  }
}
