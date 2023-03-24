package ui;

import framework.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestCase1 extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkTextNearEmailField() {
    // On the buttom of the page check that text near the email field equals 'Get our latest news
    // and special sales'

    log.info("Test <Check that text near the email field equals 'Get our latest news and special "
        + "sales'> will run");
    String actualTextNearEmailField = mainPage.getButtomPageTextNearEmailField();

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(actualTextNearEmailField)
        .as("EXPECTED 'Get our latest news and special sales'")
        .isEqualTo("Get our latest news and special sales");

    // On the buttom of the page check that text under email field contains 'You may unsubscribe at
    // any moment. For that purpose, please find my contact info in the legal notice.'

    log.info("Test <Check that text under email field contains 'You may unsubscribe at any moment'>"
        + " will run");
    String actualTextUnderEmailField = mainPage.getButtomPageTextUnderEmailField();

    softAssertions.assertThat(actualTextUnderEmailField)
        .as("EXPECTED 'You may unsubscribe at any moment. For that purpose, please find "
            + "our contact info in the legal notice.'")
        .contains("You may unsubscribe at any moment. For that purpose, please find our contact "
            + "info in the legal notice.");

// Check that all characters on 'SUBSCRIBE' button in upper case
    log.info("Test <Check that all characters on 'SUBSCRIBE' button in upper case>  will run");
    String actualButtomName = mainPage.getSubscribeButtonName();
    String expectedText = actualButtomName.toUpperCase();

    softAssertions.assertThat(actualButtomName)
        .as("EXPECTED that button name in upper case")
        .isEqualTo(expectedText);

    softAssertions.assertAll();
  }

}
