import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;


public class Main {
    public static void main(String[] args) {

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

            /*if(formula.indexOf("/0") != -1){
                System.out.println("除算には0以外の整数を使用してください");
                System.out.print("式:");
                continue;
            }*/

            BigDecimal total ;

            int index1;

            int index = operatorsIndexOf(formula, 0);
            if (index == -1) {
                System.out.println("正しい式を入力してください");
                System.out.print("式:");
                continue;
            }

            if (firstOperatorsIndexOf(formula) != -1) {

                int firstOperatorIndex = firstOperatorsIndexOf(formula);

                String before = formula.substring(0, firstOperatorIndex);

                String after = formula.substring(firstOperatorIndex + 1);



                int beforeOperatorIndex = beforeOperatorsIndexOf(before);
                int afterOperatorIndex = operatorsIndexOf(after, 0);

                BigDecimal value1 ;
                BigDecimal value2 ;
                if (beforeOperatorIndex == -1) {

                    value1 = new BigDecimal(before);;
                } else {
                    value1 = new BigDecimal(before.substring(beforeOperatorIndex + 1));
                }
                if (afterOperatorIndex == -1) {
                    value2 = new BigDecimal(after);
                } else {

                    value2 = new BigDecimal(after.substring(0, afterOperatorIndex));
                }

                BigDecimal result = new BigDecimal(0);
                switch (formula.charAt(firstOperatorIndex)) {


                    case '*':
                        result = value1.multiply(value2);
                        break;


                    case '/':
                        if(value2.signum() == 0){
                            System.out.println("0以外の数字で入力してください");
                            System.out.print("式:");
                            continue;
                        }else {
                            result = value1.divide(value2,7,RoundingMode.DOWN);
                        }
                        break;
                }
                if (beforeOperatorIndex != -1 && afterOperatorIndex != -1) {
                    formula2 = before.substring(0, beforeOperatorIndex + 1) + result + after.substring(afterOperatorIndex);
                } else if (beforeOperatorIndex == -1 && afterOperatorIndex != -1) {

                    formula2 = result + after.substring(afterOperatorIndex);
                } else if (beforeOperatorIndex != -1 && afterOperatorIndex == -1) {
                    formula2 = before.substring(0, beforeOperatorIndex + 1) + result;
                }
                else{
                    formula2 = String.valueOf(result);
                }


                while (firstOperatorsIndexOf(formula2) != -1) {

                    int firstOperatorIndex2 = firstOperatorsIndexOf(formula2);

                    String before2 = formula2.substring(0, firstOperatorIndex2);

                    String after2 = formula2.substring(firstOperatorIndex2 + 1);


                    int beforeOperatorIndex2 = beforeOperatorsIndexOf(before2);

                    int afterOperatorIndex2 = operatorsIndexOf(after2, 0);


                    BigDecimal formula2Value1 ;
                    BigDecimal formula2Value2 ;
                    if (beforeOperatorIndex2 == -1) {

                        formula2Value1 = new BigDecimal(before2);
                    } else {
                        formula2Value1 = new BigDecimal(before2.substring(beforeOperatorIndex2 + 1));
                    }
                    if (afterOperatorIndex2 == -1) {

                        formula2Value2 = new BigDecimal((after2));
                    } else {
                        formula2Value2 = new BigDecimal(after2.substring(0, afterOperatorIndex2));
                    }


                    BigDecimal result2 = new BigDecimal(0);
                    switch (formula2.charAt(firstOperatorIndex2)) {

                        case '*':

                            result2 = formula2Value1.multiply(formula2Value2);
                            break;


                        case '/':
                            if(formula2Value2.signum()==0) {
                                System.out.println("0以外の数字を入力してください");
                                System.out.print("式:");
                                continue;
                            }else{
                                result2 = formula2Value1.divide(formula2Value2,7,RoundingMode.DOWN);

                            }
                            break;
                    }


                    if (beforeOperatorIndex2 != -1 && afterOperatorIndex2 != -1) {
                        formula2 = before2.substring(0, beforeOperatorIndex2 + 1) + result2 + after2.substring(afterOperatorIndex2);
                    } else if (beforeOperatorIndex2 == -1 && afterOperatorIndex2 != -1) {
                        formula2 = result2 + after2.substring(afterOperatorIndex2);
                    } else if (beforeOperatorIndex2 != -1 && afterOperatorIndex2 == -1) {
                        formula2 = before2.substring(0, beforeOperatorIndex2 + 1) + result2;
                    } else {
                        formula2 = String.valueOf(result2);
                    }
                }
            } else if (firstOperatorsIndexOf(formula2) == -1) {
                formula2 = formula;
            }

            if(operatorsIndexOf(formula2, 0) != -1) {
                index1 = operatorsIndexOf(formula2,0);
                total = new BigDecimal (formula2.substring(0, index1));
                int index2 = operatorsIndexOf(formula2, index1 + 1);
                while (index2 != -1) {
                    BigDecimal value2 = new BigDecimal(formula2.substring(index1 + 1, index2));
                    switch (formula2.charAt(index1)) {
                        case '+':
                            total = total.add(value2);
                            break;

                        case '-':
                            total = total.subtract(value2);
                            break;


                    }
                    index1 = index2;
                    index2 = operatorsIndexOf(formula2, index2 + 1);
                }
                BigDecimal value2 = new BigDecimal(formula2.substring(index1 + 1));
                switch (formula2.charAt(index1)) {

                    case '+':
                        total = total.add(value2);
                        break;

                    case '-':
                        total = total.subtract(value2);
                        break;


                }
            } else {
                total = new BigDecimal(formula2);
            }
            System.out.println(total.stripTrailingZeros());
            System.out.print("式:");
        }
    }

    public static int operatorsIndexOf (String f,int start){
        int operatorPlusIndex = f.indexOf("+",start);
        int operatorMinusIndex = f.indexOf("-",start);
        int operatorMultiplicationIndex = f.indexOf("*",start);
        int operatorDivisionIndex = f.indexOf("/",start);

        int index = operatorPlusIndex;

        if (index == -1 || (index > operatorMinusIndex && operatorMinusIndex != -1)) {
            index = operatorMinusIndex;
        }
        if (index == -1 || (index > operatorMultiplicationIndex && operatorMultiplicationIndex != -1)) {
            index = operatorMultiplicationIndex;
        }

        if (index == -1 || (index > operatorDivisionIndex && operatorDivisionIndex != -1)) {
            index = operatorDivisionIndex;
        }
        return index;
    }

    public static int firstOperatorsIndexOf (String formula){
        int operatorMultiplicationIndex = formula.indexOf("*");
        int operatorDivisionIndex = formula.indexOf("/");

        int firstIndex = operatorMultiplicationIndex;
        if (firstIndex == -1 || operatorMultiplicationIndex > operatorDivisionIndex && operatorDivisionIndex != -1) {
            firstIndex = operatorDivisionIndex;
        }
        return firstIndex;
    }
    public static int beforeOperatorsIndexOf (String b){
        int operatorPlusIndex = b.lastIndexOf("+");
        int operatorMinusIndex = b.lastIndexOf("-");
        int operatorMultiplicationIndex = b.lastIndexOf("*");
        int operatorDivisionIndex = b.lastIndexOf("/");

        int index = operatorPlusIndex;

        if (index == -1 || (index < operatorMinusIndex && operatorMinusIndex != -1)) {
            index = operatorMinusIndex;
        }
        if (index == -1 || (index < operatorMultiplicationIndex && operatorMultiplicationIndex != -1)) {
            index = operatorMultiplicationIndex;
        }

        if (index == -1 || (index < operatorDivisionIndex && operatorDivisionIndex != -1)) {
            index = operatorDivisionIndex;
        }
        return index;
    }

}