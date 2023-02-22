package ui;

import framework.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SignTests2 extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
  public void signInWithInvalidCredentials() {
    String actualErrorMessage = mainPage.clickOnSignInLink()
        .enterEmail("roni_cost@example.com")
        .enterPassword("roni_cost@example.com")
        .clickSignInButtonWithExpectedFail()
        .getErrorMessage();

    Assertions.assertThat(actualErrorMessage)
        .as("Actual error message is not as expected")
        .isEqualTo("Incorrect CAPTCHA");
  }

}
