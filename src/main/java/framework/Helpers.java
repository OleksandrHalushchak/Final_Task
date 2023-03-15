package framework;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;

public class Helpers {

  private static Faker faker = new Faker();

  public static String generateValidFirstName() {
    return faker.name().firstName();
  }

  public static String generateValidLastName() {
    return faker.name().lastName();
  }

  public static String generateValidEmail() {
    return faker.internet().emailAddress();
  }
  public static String generateValidPassword() {
    return faker.internet().password();
  }
  public static String generateValidBirthdate(){
    String birthdate = String.valueOf(faker.date().birthday());
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    return formatter.format(birthdate);
  }


}
