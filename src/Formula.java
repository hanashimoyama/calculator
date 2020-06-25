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
            String total = "";

            String formula2 = formula;
            if (formula.equals("end")) {
                System.exit(0);
            }


            int index = Analysis.operatorsIndexOf(formula, 0);
            if (index == -1) {
                System.out.println("正しい式を入力してください");
                System.out.print("式:");
                continue;
            }
            if (Analysis.firstOperatorsIndexOf(formula) != -1){
                int firstOperatorIndex = Analysis.firstOperatorsIndexOf(formula);
                String[] formulas = Analysis.split(formula);
                String before = formulas[0];
                String after = formulas[1];

                int [] formulasIndex = Analysis.formulasIndex(before,after);
                int beforeOperatorIndex = formulasIndex[0];
                int afterOperatorIndex = formulasIndex[1];

                String[] numbers = Analysis.numbers(before,after,beforeOperatorIndex,afterOperatorIndex);
                String value1 = numbers[0];
                String value2 = numbers[1];
                String op = formula.substring(firstOperatorIndex,firstOperatorIndex+1);

                BigDecimal result = Calculation.calculating(value1,value2,op);

                formula2 = Analysis.newFormula(before,after,beforeOperatorIndex,afterOperatorIndex,result);

                while (Analysis.firstOperatorsIndexOf(formula2) != -1){
                    firstOperatorIndex = (Analysis.firstOperatorsIndexOf(formula2));
                    formulas = Analysis.split(formula2);
                    before = formulas[0];
                    after = formulas[1];

                    formulasIndex = Analysis.formulasIndex(before,after);
                    beforeOperatorIndex = formulasIndex[0];
                    afterOperatorIndex = formulasIndex[1];

                    numbers = Analysis.numbers(before,after,beforeOperatorIndex,afterOperatorIndex);
                    value1 = numbers[0];
                    value2 = numbers[1];
                    op = formula2.substring(firstOperatorIndex,firstOperatorIndex+1);

                    result = Calculation.calculating(value1,value2,op);

                    formula2 = Analysis.newFormula(before,after,beforeOperatorIndex,afterOperatorIndex,result);
                }
            }else if (Analysis.firstOperatorsIndexOf(formula2) == -1) {
                formula2 = formula;
            }if(Analysis.operatorsIndexOf(formula2, 0) != -1){

                 index1 = Analysis.operatorsIndexOf(formula2,0);
                int index2 = Analysis.operatorsIndexOf(formula2, index1 + 1);
                total = formula2.substring(0, index1);
                String op = formula2.substring(index1,index1+1);
                while (index2 != -1) {
                    String value2 = formula2.substring(index1 + 1, index2);
                    total = String.valueOf(Calculation.calculating(total, value2, op));
                    index1 = index2;
                    index2 = Analysis.operatorsIndexOf(formula2, index2 + 1);
                }
                 String value2 = formula2.substring(index1 + 1);
                 op = formula2.substring(index1,index1+1);
                total =(Calculation.calculating(total,value2,op)).toString();
            } else{
                total = formula2;
            }
            System.out.println(new BigDecimal(total).stripTrailingZeros());
            System.out.print("式:");
        }
    }
}
