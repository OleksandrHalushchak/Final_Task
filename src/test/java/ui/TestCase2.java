package ui;

import framework.MainPage;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkTextNearEmailField() {
    //
    int expectedNumberOfLanguages = 44;
    List<String> actualLanguages = mainPage.getAllLanguages();

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(actualLanguages)
        .as("EXPECTED '44'")
        .hasSize(expectedNumberOfLanguages);

    softAssertions.assertThat(actualLanguages)
        .as("EXPECTED 'Українська мова присутня'")
        .contains("Українська");

    softAssertions.assertAll();
  }
}
