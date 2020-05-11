//1.四則演算の実装。(ex)1 + 1)
import java.util.Scanner;

public class Main {
    public static <string> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out:
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String formula = line.replace(" ", "");
            System.out.println(formula);

            String operators [] = {"+","-","*","/"};
            for(String formula:operator){
             int operatorPosition = formula.indexOf(operator);
                if (operatorPosition != -1) {
                    System.out.println(operatorPosition); // 3
                } else {
                    System.out.println(operator + "は見つかりませんでした");
                }
            }
        }

    }
}