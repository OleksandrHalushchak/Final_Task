package ui;

import framework.Helpers;
import framework.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestCase4InvalidData extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
//Check that 'First name' higlighted in red--------------------------------
//Check that pop-up with text 'Invalid name' appear under field
  public void checkNameNearCartButton() {

    String expectedText  = "Invalid name";

    String actualText = mainPage.clickSignIn()
        .clickCreateAccount()
        .createAccount("James8", Helpers.generateValidLastName(), Helpers.generateValidEmail(),
            Helpers.generateValidPassword(), Helpers.generateValidBirthdate())
        .clickSaveButtonInvalidData()
        .getPopUpText();

    Assertions.assertThat(actualText)
        .as("EXPECTED" + expectedText)
        .isEqualTo(expectedText);
  }
}
// колір червоний