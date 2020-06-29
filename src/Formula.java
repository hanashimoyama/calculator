

import java.math.BigDecimal;
import java.util.Scanner;

public class Formula {
    public static void formula(){
        Scanner sc = new Scanner(System.in);
        System.out.println("計算したい時:式を入力　終了したい時:endと入力");
        System.out.print("式:");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String formula = line.replace(" ", "");
            int index1 = 0;
            String total ="";
            BigDecimal result = new BigDecimal(0) ;

            if (formula.equals("end")) {
                System.exit(0);
            }


            int index = Analysis.operatorsIndexOf(formula);
            if (index == -1) {
                System.out.println("正しい式を入力してください");
                System.out.print("式:");
                continue;
            }
            while (Analysis.operatorsIndexOf(formula) != -1){
                int firstOperatorIndex = Analysis.operatorsIndexOf(formula);
                String[] formulas = Analysis.split(formula);
                String before = formulas[0];
                String after = formulas[1];

                int [] formulasIndex = Analysis.formulasIndexes(before,after);
                int beforeOperatorIndex = formulasIndex[0];
                int afterOperatorIndex = formulasIndex[1];

                String[] numbers = Analysis.numbers(before,after,beforeOperatorIndex,afterOperatorIndex);
                String value1 = numbers[0];
                String value2 = numbers[1];
                String op = formula.substring(firstOperatorIndex,firstOperatorIndex+1);

                try{
                    result = Calculation.calculating(value1,value2,op);
                }catch (ArithmeticException ex){
                    System.out.println(ex.toString());
                    break;
                }
                formula = Analysis.newFormula(before,after,beforeOperatorIndex,afterOperatorIndex,result);

            }
                total = formula;
            if(Analysis.operatorsIndexOf(total) == -1) {
                System.out.println(new BigDecimal(total).stripTrailingZeros().toPlainString());

            }System.out.print("式:");
        }
    }

}