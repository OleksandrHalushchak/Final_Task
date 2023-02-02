package ui;

import framework.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SignTests extends BaseTest {

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
        .isEqualTo(
            "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
  }

}
