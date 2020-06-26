import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {
    private String num1, num2, op ;




    public static BigDecimal calculating(String num1, String num2, String op) {
        BigDecimal result = new BigDecimal(0);
        BigDecimal value1 = new BigDecimal(num1);
        BigDecimal value2 = new BigDecimal(num2);
        switch (op) {
            case "+":
                result = value1.add(value2);
                break;

            case "-":
                result = value1.subtract(value2);
                break;
            case "*":

                result = value1.multiply(value2);
                break;

            case "/":
                result= value1.divide(value2,7, RoundingMode.DOWN);

                break;
        }
        return result;

    }
}
