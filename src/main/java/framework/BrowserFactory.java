package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {


  public static WebDriver getBrowser(Browsers browser) {
    switch (browser) {
      case CHROME:
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
      case SAFARI:
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
      default:
        throw new IllegalStateException("Unknown browser: " + browser);
    }
  }

  public enum Browsers {
    CHROME,
    FIREFOX,
    SAFARI
  }

}
