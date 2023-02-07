package ui;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerTest {

  private final Faker faker = new Faker();

  @Test
  public void fakerTest() {

    for (int i = 0; i < 20; i++) {
      System.out.println(faker.name().firstName());
    }
  }
}
