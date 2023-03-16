package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public class Products {

  private WebElement nameWeb;
  private String name;
  private String price;




  private WebElement CompareThisProduct;

  public Products(WebElement container) {
    this.nameWeb = container.findElement(By.xpath("//h3[@class='h3 product-title']//a"));
    this.name = nameWeb.getText();
    this.price= container.findElement(By.xpath("//span[@class='price']")).getText();

   }





}
