package framework.pages.helpers;

import com.github.javafaker.Faker;
import java.io.FileNotFoundException;
import java.io.FileReader;
import lombok.SneakyThrows;

public class Helpers {

  private static Faker faker = new Faker();

  public static String generateInvalidPhone(int digits) {
    return faker.number().digits(digits);
  }

  @SneakyThrows
  public static void readDataFromFile()  {
    FileReader fileReader = new FileReader("src/test/resources/addresses.csv");
  }
}
