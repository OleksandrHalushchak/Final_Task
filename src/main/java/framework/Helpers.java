package framework;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;

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

  @SneakyThrows
  public static String generateValidBirthdate(){
    LocalDate localDate = LocalDate.now().minusYears(RandomUtils.nextInt(18, 60));
    SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat toFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = originalFormat.parse(localDate.toString());
    return toFormat.format(date);

  }





}
