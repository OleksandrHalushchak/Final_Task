package framework;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  //container for driver
  private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

  public static ThreadLocal<WebDriver> getDriverThreadLocal() {
    return DRIVER_THREAD_LOCAL;
  }

  public static void setDriverThreadLocal(WebDriver driver) {
    DRIVER_THREAD_LOCAL.set(driver);
  }

  public static WebDriver getDriver() {
    return DRIVER_THREAD_LOCAL.get();
  }


  public static WebElement find(By locator) {
    return getDriver().findElement(locator);
  }

  public static List<WebElement> findAll(By locator) {
    return getDriver().findElements(locator);
  }

  public static void waitUntilVisible(By locator, int seconds) {
    new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public void waitUntilAppear(By locator, int seconds) {
    new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void waitUntilDisappear(By locator, int seconds) {
    new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public static void scroll(int pixels) {
    JavascriptExecutor jse = (JavascriptExecutor) getDriver();
    jse.executeScript("window.scrollBy(0," + pixels + ")");
  }

  public void scrollPageBottom() {
    JavascriptExecutor jse = (JavascriptExecutor) getDriver();
    jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
  }

  public void selectByText(By selectLocator, String text) {
    Select select = new Select(getDriver().findElement(selectLocator));
    select.selectByVisibleText(text);
  }

  public void hoverMouse(By locator) {
    Actions action = new Actions(getDriver());
    action.moveToElement(getDriver().findElement(locator)).build().perform();
  }

}
