package ui;

import framework.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://magento.softwaretestingboard.com/");
    driver.manage().window().maximize();
    BasePage.setDriver(driver);
  }

  @AfterMethod(alwaysRun = true)
  public void quite() {
    BasePage.getDriver().quit();
  }

}
