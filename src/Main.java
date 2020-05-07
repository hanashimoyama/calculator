//1.四則演算の実装。(ex)1 + 1)
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        out : while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String[] formula = line.split(" ");

            int total =0;

            if (formula.length < 3 || ((formula.length != 3) && (formula.length % 3 != 2))) {

                System.out.println("数値 演算子 数値 演算子 数値 … の順に最低3つの引数を指定してください");
                continue;

            } else {

                if (checkNum(formula[0])) {

                    total = Integer.parseInt(formula[0]);

                }
                for (int i = 0; i <= ((formula.length - 3) / 2); i++) {

                    if (checkOperator(formula[i * 2 + 1]) && checkNum(formula[i * 2 + 2])) {

                        switch (formula[i * 2 + 1]) {

                            case "+":
                                total = total + Integer.parseInt(formula[i * 2 + 2]);
                                break;

                            case "-":
                                total = total - Integer.parseInt(formula[i * 2 + 2]);
                                break;

                            case "*":
                                total = total * Integer.parseInt(formula[i * 2 + 2]);
                                break;

                            case "/":
                                total = total / Integer.parseInt(formula[i * 2 + 2]);
                                break;

                        }

                    } else {
                        System.out.println("数値 演算子 数値 演算子 数値 … の順に引数を指定してください");
                        continue out;
                    }

                }

                System.out.println("合計:" + total);
            }
        }

        sc.close();
    }

    private static boolean checkNum(String str) {

        try {

            Integer.parseInt(str);

        } catch (NumberFormatException e) {

            return false;

        }

        return true;

    }

    private static boolean checkOperator(String str) {

        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}

