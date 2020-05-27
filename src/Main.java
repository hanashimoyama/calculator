//1.四則演算の実装。(ex)1 + 1 + 1)
import com.sun.source.tree.ClassTree;

import java.util.Scanner;


public class Main {
    public static <string> void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("計算したい時:式を入力　終了したい時:endと入力");
        System.out.print("式:");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String formula = line.replace(" ", "");
            if (formula.equals("end")) {
                System.exit(0);
            }

            int total = 0;
            int index = operatorsIndexOf(formula, 0);//演算子1
            if (index == -1) {
                System.out.println("正しい式を入力してください");
                System.out.print("式:");
                continue;
            }


            if(operatorsIndexOf(formula,0) != -1) {
                int firstOperatorIndex = firstOperatorsIndexOf(formula, 0);
                String before = formula.substring(0, firstOperatorIndex);
                String after = formula.substring(firstOperatorIndex + 1);


                int beforeOperatorIndex = beforeOperatorsIndexOf(before);
                int afterOperatorIndex = operatorsIndexOf(after, 0);

                int value1 = Integer.parseInt(before.substring(beforeOperatorIndex + 1));
                int value2 = Integer.parseInt(after.substring(0, afterOperatorIndex));

                int result = 0;
                switch (formula.charAt(firstOperatorIndex)) {

                    case '*':
                        result = value1 * value2;
                        break;


                    case '/':
                        result = value1 / value2;
                        break;
                }

                String formula2 = before.substring(0, beforeOperatorIndex + 1) + result + after.substring(afterOperatorIndex);



                while(firstOperatorsIndexOf(formula2,0)!= -1){

                    int firstOperatorIndex2 = firstOperatorsIndexOf(formula2, 0);
                    String before2 = formula2.substring(0, firstOperatorIndex2);
                    String after2 = formula2.substring(firstOperatorIndex2 + 1);




                    int beforeOperatorIndex2 = beforeOperatorsIndexOf(before2);
                    int afterOperatorIndex2 = operatorsIndexOf(after2, 0);

                    int formula2Value2 = 0;
                    int formula2Value1 = 0;
                    if(beforeOperatorIndex2 == -1) {
                         formula2Value1 = Integer.parseInt(before2);
                    }else{
                        formula2Value1 = Integer.parseInt(before2.substring(beforeOperatorIndex2+1));
                    }
                    if (afterOperatorIndex2 ==-1){
                        formula2Value2 = Integer.parseInt((after2));
                    }else{
                        formula2Value2 = Integer.parseInt(after2.substring(0, afterOperatorIndex2));
                    }



                    int result2 = 0;
                    switch (formula2.charAt(firstOperatorIndex2)) {

                        case '*':
                            result2 = formula2Value1 * formula2Value2;
                            break;


                        case '/':
                            result2= formula2Value1 / formula2Value2;
                            break;
                    }


                    /*if(beforeOperatorIndex2 !=1&&afterOperatorIndex2 != -1){
                    formula2 = before2.substring(0, beforeOperatorIndex2 +1) + result2 + after2.substring(afterOperatorIndex2);
                    }else if(beforeOperatorIndex2 == -1 && afterOperatorIndex2 != -1){
                        formula2 = result2 + after2.substring(afterOperatorIndex2);
                    }else  if(beforeOperatorIndex2 != -1 && afterOperatorIndex2 == -1){
                        formula2 = before2.substring(0,beforeOperatorIndex+1) + result2;
                    }*/
                    System.out.println(formula2);
                }
            }








                /*int index1 = formula.indexOf(before);
                int index2 = formula.lastIndexOf(index);

                int value1 = Integer.parseInt(before.substring(index));
                int value2 = Integer.parseInt(after.substring(index2));*/


            //to/合計をいれる値を作成tal = Integer.parseInt(formula.substring(0, index1));/


            /*while (index1 !=1&&index2 != -1){
                int value2 = Integer.parseInt(formula.substring(index1 + 1,index2));
                int priorityIndex1 = formula.lastIndexOf(operators,index1);
                int priorityValue = Integer.parseInt(formula.substring(index1-1,priorityIndex));
                String operator1 = formula.substring(index1,index1+1);
                String operator2 = formula.substring(index2,index2+1);
                switch (formula.charAt(index1)){
                    case'+':
                        if(operator1=="+"){

                    }
                }
                break;
            }*/

            /*while (index2 != -1) {
                int value2 = Integer.parseInt(formula.substring(index1 + 1, index2)); //演算子がまだあるかチェックして見つかった時のループ処理
                switch (formula.charAt(index1)) {
                    case '+':
                        total = total + value2;
                        break;

                    case '-':
                        total = total - value2;
                        break;

                    case '*':
                        total = total * value2;
                        break;

                    case '/':
                        total = total / value2;
                        break;
                }
                index1 = index2;
                index2 = operatorsIndexOf(formula, index2 + 1);
            }

            int value2 = Integer.parseInt(formula.substring(index1 + 1));
            switch (formula.charAt(index1)) {
                case '+':
                    total = total + value2;
                    break;

                case '-':
                    total = total - value2;
                    break;

                case '*':
                    total = total * value2;
                    break;

                case '/':
                    total = total / value2;
                    break;

            }
            System.out.println(total);
            System.out.print("式:");

        }*/


        }


    }
    public static int operatorsIndexOf(String f,int start) {
        int operatorPlusIndex = f.indexOf("+"); //文字列にそれぞれの演算子があるかチェック
        int operatorMinusIndex = f.indexOf("-");
        int operatorMultiplicationIndex = f.indexOf("*");
        int operatorDivisionIndex = f.indexOf("/");

        int index = operatorPlusIndex;//＋を基準にして一番近い演算子を検索してくる

        if (index == -1 || (index > operatorMinusIndex && operatorMinusIndex != -1)) { // 1+2+3だとして　indexが-1だと -1>2&&2!=1でforceになっちゃう
            index = operatorMinusIndex;                                        //なので indexが-1の時も条件が通るようにする
        }
        if (index == -1 || (index > operatorMultiplicationIndex && operatorMultiplicationIndex != -1)) {
            index = operatorMultiplicationIndex;
        }

        if (index == -1 || (index > operatorDivisionIndex && operatorDivisionIndex != -1)) {
            index = operatorDivisionIndex;
        }
        return index;
    }

    public static int firstOperatorsIndexOf(String formula,int start){
        int operatorMultiplicationIndex = formula.indexOf("*",start);
        int operatorDivisionIndex = formula.indexOf("/",start);

        int firstIndex = operatorMultiplicationIndex;
        if(firstIndex == -1||operatorMultiplicationIndex>operatorDivisionIndex && operatorDivisionIndex !=-1){
            firstIndex = operatorDivisionIndex;
        }
        return firstIndex;
    }
    public static int beforeOperatorsIndexOf(String b) {
        int operatorPlusIndex =b.lastIndexOf("+");
        int operatorMinusIndex = b.lastIndexOf("-");
        int operatorMultiplicationIndex = b.lastIndexOf("*");
        int operatorDivisionIndex =b.lastIndexOf("/");

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




