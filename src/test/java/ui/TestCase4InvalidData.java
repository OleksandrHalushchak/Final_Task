package ui;


import framework.Helpers;
import framework.MainPage;
import framework.CreateAccountPage;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

@Log4j2
public class TestCase4InvalidData extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

//Registration with invalid data
  public void checkNameNearCartButton() {
    log.info(" Test <Registration with invalid data> will run");
    String expectedText = "Invalid format.";
    String expectedLineColor = "rgb(255, 76, 76)";

    mainPage.clickSignIn()
        .clickCreateAccount()
        .createAccount("James8", Helpers.generateValidLastName(),
            Helpers.generateValidEmail(), Helpers.generateValidPassword(),
            Helpers.generateValidBirthdate())
        .clickSaveButtonInvalidData();

    CreateAccountPage createAccountPage = new CreateAccountPage();

    //Check that pop-up with text 'Invalid name' appear under field
    String actualText = createAccountPage.getPopUpText();
    log.info("Check that pop-up with text 'Invalid name' appear under field");
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(actualText)
        .as("EXPECTED " + expectedText)
        .isEqualTo(expectedText);

    //Check that 'First name' higlighted in red
    String actualLineColor = createAccountPage.getLineColor();
    log.info("Check that 'First name' higlighted in red");
    softAssertions.assertThat(actualLineColor)
        .as("EXPECTED " + expectedLineColor)
        .contains(expectedLineColor);

    softAssertions.assertAll();
  }
}
