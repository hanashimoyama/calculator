//1.四則演算の実装。(ex)1 + 1)
import java.util.Scanner;

public class Main {
    public static <string> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out:
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String formula = line.replace(" ", "");

            String operators[] = {"+", "-", "*", "/"};
            for (String search : operators) {
                int operatorPosition = formula.indexOf(search);
                if (operatorPosition != -1) {
                    String operator = formula.substring(operatorPosition,operatorPosition +1);
                } else {

                }


            }

        }

    }
}