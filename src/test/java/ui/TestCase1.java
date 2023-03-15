package ui;

import framework.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkTextNearEmailField() {
    // On the buttom of the page check that text near the email field equals 'Get our latest news
    // and special sales'
    String actualTextNearEmailField = mainPage.waitUntilHomePageLoad().
        getButtomPageTextNearEmailField();

    Assertions.assertThat(actualTextNearEmailField)
        .as("EXPECTED 'Get our latest news and special sales'")
        .isEqualTo("Get our latest news and special sales");

    // On the buttom of the page check that text under email field contains 'You may unsubscribe at
    // any moment. For that purpose, please find my contact info in the legal notice.'
    String actualTextUnderEmailField = mainPage.getButtomPageTextUnderEmailField();

    Assertions.assertThat(actualTextNearEmailField)
        .as("EXPECTED 'You may unsubscribe at any moment. For that purpose, please find "
            + "my contact info in the legal notice.'")
        .contains("You may unsubscribe at any moment. For that purpose, please find my contact info"
            + " in the legal notice.");

// Check that all characters on 'SUBSCRIBE' button in upper case
    String actualButtomName = mainPage.getSubscribeButtonName();
    String expectedText = actualButtomName.toUpperCase();

    Assertions.assertThat(actualButtomName)
        .as("EXPECTED that button name in upper case")
        .isEqualTo(expectedText);
  }

}
