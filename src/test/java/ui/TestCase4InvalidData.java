package ui;


import framework.Helpers;
import framework.MainPage;
import framework.CreateAccountPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class TestCase4InvalidData extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
//Check that 'First name' higlighted in red
//Check that pop-up with text 'Invalid name' appear under field
  public void checkNameNearCartButton() {

    String expectedText = "Invalid format.";
    String expectedLineColor = "rgb(255, 76, 76)";

    mainPage.clickSignIn()
        .clickCreateAccount()
        .createAccount("James8", Helpers.generateValidLastName(), Helpers.generateValidEmail(),
            Helpers.generateValidPassword(), Helpers.generateValidBirthdate())
        .clickSaveButtonInvalidData();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    String actualText = createAccountPage.getPopUpText();
    String actualLineColor = createAccountPage.getLineColor();

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(actualText)
        .as("EXPECTED " + expectedText)
        .isEqualTo(expectedText);

    softAssertions.assertThat(actualLineColor)
        .as("EXPECTED " + expectedLineColor)
        .contains(expectedLineColor);

    softAssertions.assertAll();
  }
}
