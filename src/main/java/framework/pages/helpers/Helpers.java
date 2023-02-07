package framework.pages.helpers;

import com.github.javafaker.Faker;

public class Helpers {

  private static Faker faker = new Faker();

  public static String generateInvalidPhone(int digits) {
    return faker.number().digits(digits);
  }

}
