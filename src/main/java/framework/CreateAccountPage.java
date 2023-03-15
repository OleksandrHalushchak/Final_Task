package framework;

import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage{
  private final By createAccountSocialTitleLocator = By.id("id('field-id_gender-1')");
  private final By createAccountFirstNameFieldLocator = By.id("id('field-firstname')");
  private final By createAccountLastNameFieldLocator = By.id("id('field-lastname')");
  private final By createAccountEmailFieldLocator = By.id("id('field-email')");
  private final By createPasswordFieldLocator = By.id("id('field-password')");
  private final By createBirthdateFieldLocator = By.id("id('field-birthday')");
  private final By createCustomerPrivacyLocator = By.xpath(
      "//input[@name='customer_privacy']");
  private final By createCustomerIAgreeLocator = By.xpath(
      "//input[@name='psgdpr']");
  //name near cart button
  private final By nameNearCartButtonLocator = By.xpath(
      "//a[@class='account']//span[@class='hidden-sm-down']");




}
