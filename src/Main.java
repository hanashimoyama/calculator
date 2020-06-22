import java.util.Scanner;


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

            if(formula.indexOf("/0") != -1){
                System.out.println("除算には0以外の整数を使用してください");
                System.out.print("式:");
                continue;
            }

            int total = 0;

            int index1 = operatorsIndexOf(formula, 0);

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

                int value1 = 0;
                int value2 = 0;
                if (beforeOperatorIndex == -1) {

                    value1 = Integer.parseInt(before);
                } else {
                    value1 = Integer.parseInt(before.substring(beforeOperatorIndex + 1));
                }
                if (afterOperatorIndex == -1) {
                    value2 = Integer.parseInt((after));
                } else {

                    value2 = Integer.parseInt(after.substring(0, afterOperatorIndex));
                }

                int result = 0;
                switch (formula.charAt(firstOperatorIndex)) {


                    case '*':
                        result = value1 * value2;
                        break;


                    case '/':
                        result = value1 / value2;
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


                    int formula2Value1 = 0;
                    int formula2Value2 = 0;
                    if (beforeOperatorIndex2 == -1) {

                        formula2Value1 = Integer.parseInt(before2);
                    } else {
                        formula2Value1 = Integer.parseInt(before2.substring(beforeOperatorIndex2 + 1));
                    }
                    if (afterOperatorIndex2 == -1) {

                        formula2Value2 = Integer.parseInt((after2));
                    } else {
                        formula2Value2 = Integer.parseInt(after2.substring(0, afterOperatorIndex2));
                    }


                    int result2 = 0;
                    switch (formula2.charAt(firstOperatorIndex2)) {

                        case '*':

                            result2 = formula2Value1 * formula2Value2;
                            break;


                        case '/':
                            result2 = formula2Value1 / formula2Value2;
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
                total = Integer.parseInt(formula2.substring(0, index1));
                int index2 = operatorsIndexOf(formula2, index1 + 1);
                while (index2 != -1) {
                    int value2 = Integer.parseInt(formula2.substring(index1 + 1, index2));
                    switch (formula2.charAt(index1)) {
                        case '+':
                            total = total + value2;
                            break;

                        case '-':
                            total = total - value2;
                            break;


                    }
                    index1 = index2;
                    index2 = operatorsIndexOf(formula2, index2 + 1);
                }
                int value2 = Integer.parseInt(formula2.substring(index1 + 1));
                switch (formula2.charAt(index1)) {

                    case '+':
                        total = total + value2;
                        break;

                    case '-':
                        total = total - value2;
                        break;


                }
            } else {
                total = Integer.parseInt(formula2);
            }
            System.out.println(total);
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