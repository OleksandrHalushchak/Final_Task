package ui;

import framework.MainPage;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkTextNearEmailField() {
    //
    int expectedNumberOfLanguages = 44;
    List<WebElement> LanguageList = mainPage.getLanguageList();
    int actualNumberOfLanguages = LanguageList.size();
    String a = mainPage.isUkrainianLanguagePresent("Українська");

    Assertions.assertThat(actualNumberOfLanguages)
        .as("EXPECTED '44'")
        .isEqualTo(expectedNumberOfLanguages);

    Assertions.assertThat(a)
        .as("EXPECTED 'Українська мова присутня'")
        .isEqualTo("true");


  }
}
