//1.四則演算の実装。(ex)1 + 1 + 1)
import java.util.Scanner;

public class Main {
    public static <string> void main(String[] args) {
        int value1 = 0;
        int value2 = 0;
        int total = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("式:");
        out:
        while (sc.hasNextLine()) {
            String line  = sc.nextLine();
            String formula = line.replace(" ", "");

            String operators[] = {"+", "-", "*", "/"}; //数値の取得
            for (String search : operators) {
                int operatorPosition = formula.indexOf(search);
                if (operatorPosition != -1) {
                    String operator = formula.substring(operatorPosition, operatorPosition + 1);
                    String num1 = formula.substring(0, operatorPosition);
                    String num2 = formula.substring(operatorPosition + 1);
                    value1 = Integer.parseInt(num1);
                    value2 = Integer.parseInt(num2);
                    switch (operator) {

                        case "+":
                            total = value1 + value2;
                            break;

                        case "-":
                            total = value1 - value2;
                            break;

                        case "*":
                            total = value1 * value2;
                            break;

                        case "/":
                            total = value1 / value2;
                            break;
                    }


                } else {
                    continue;
                }
            }
        }
    }
}



