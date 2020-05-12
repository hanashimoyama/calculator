//1.四則演算の実装。(ex)1 + 1)
import java.util.Scanner;

public class Main {
    public static <string> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out:
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String formula = line.replace(" ", "");

            String operators [] = {"+","-","*","/"};
            for(String operator:operators){
             int operatorPosition = formula.indexOf(operator);
                if (operatorPosition != -1) {
                    System.out.println(operatorPosition); // 3
                } else {

                }
            }

        }

    }
}