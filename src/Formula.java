import java.math.BigDecimal;
import java.util.Scanner;

public class Formula {
    public static void formula(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("計算したい時:式を入力　終了したい時:endと入力");
        System.out.print("式:");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String formula = line.replace(" ", "");

            String formula2 = formula;
            if (formula.equals("end")) {
                System.exit(0);
            }
            BigDecimal total = new BigDecimal(0);

            int index1 = Analysis.operatorsIndexOf(formula, 0);

            int index = Analysis.operatorsIndexOf(formula, 0);
            if (index == -1) {
                System.out.println("正しい式を入力してください");
                System.out.print("式:");
                continue;
            }

        }
    }
}
