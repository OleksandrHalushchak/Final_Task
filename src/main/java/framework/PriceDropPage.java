package framework;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceDropPage extends BasePage {

  public static String calculatePromoPrice(String oldPriceStr, String discountPercentageStr) {

    oldPriceStr = oldPriceStr.substring(1);
    discountPercentageStr = discountPercentageStr.substring(1, (discountPercentageStr.length() - 1));

    BigDecimal oldPrice = new BigDecimal(oldPriceStr);
    BigDecimal discountPercentage = new BigDecimal(discountPercentageStr);

    BigDecimal discount = new BigDecimal(String.valueOf((oldPrice.multiply(discountPercentage)).
        multiply(BigDecimal.valueOf(0.01))));
    BigDecimal price = oldPrice.subtract(discount);

    return (price.setScale(2, RoundingMode.HALF_UP).toString());
  }
}
