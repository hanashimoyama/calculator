import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {
    private String num1, num2, op ;




    public static BigDecimal calculating(String num1, String num2, String op)  throws ArithmeticException{
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
                {
                    try {
                        result= value1.divide(value2,7, RoundingMode.DOWN);
                        break;
                    } catch (ArithmeticException e) {
                        System.out.println("0以外の数字で入力してください");
                        System.out.println(e);
                    }
                }

        }
        return result;

    }
}
