package ui;

import framework.Helpers;
import framework.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestCase3ValidData extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
//Check your name appear near cart button after registration with valid data
  public void checkNameNearCartButton() {

    String expectedFirstName = Helpers.generateValidFirstName();
    String expectedLastName = Helpers.generateValidLastName();
    String expectedName = expectedLastName + " " + expectedFirstName;
    String actualName = mainPage.clickSignIn().clickCreateAccount()
        .createAccount(expectedFirstName, expectedLastName, Helpers.generateValidEmail(),
            Helpers.generateValidPassword(), Helpers.generateValidBirthdate())
        .clickSaveButtonValidData().getUserNameNearCartButton();
    Assertions.assertThat(actualName).as("EXPECTED" + expectedName).isEqualTo(expectedName);
  }
}
