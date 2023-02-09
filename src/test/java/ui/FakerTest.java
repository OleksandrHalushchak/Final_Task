package ui;

import com.github.javafaker.Faker;
import framework.pages.MainPage;
import org.testng.annotations.Test;

public class FakerTest {

  private final Faker faker = new Faker();

  @Test
  public void fakerTest() {
    MainPage mainPage = new MainPage();
    mainPage.selectFromPriceDropdown("Price low to high");

    String valueFromCountDropDown = mainPage.getValueFromCountDropDown();
    String valueFromPriceDropDown = mainPage.getValueFromPriceDropDown();

  }
}
