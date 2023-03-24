package ui;

import framework.MainPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestCase2 extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test

  public void checkTextNearEmailField() {


    log.info("Test <Check languages> will run");
    int expectedNumberOfLanguages = 44;
    List<String> actualLanguages = mainPage.getAllLanguages();

    log.info("Test <Check that 44 langueges exists in 'Language' dropdown in the top menu> "
        + "will run");
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(actualLanguages)
        .as("EXPECTED '44'")
        .hasSize(expectedNumberOfLanguages);

    log.info("Test <Check that 'Українська' language exist in dropdown> will run");
    softAssertions.assertThat(actualLanguages)
        .as("EXPECTED 'Українська мова присутня'")
        .contains("Українська");

    softAssertions.assertAll();
  }
}
