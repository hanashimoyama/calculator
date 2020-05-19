//1.四則演算の実装。(ex)1 + 1 + 1)
import java.util.Scanner;

public class Main {
    public static <string> void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("式:");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String formula = line.replace(" ", "");
            int total = 0;

            int index1 = operatorsIndexOf(formula,0);//演算子１
            total = Integer.parseInt(formula.substring(0,index1));//合計をいれる値を作成
            int index2 = operatorsIndexOf(formula,index1+1);//演算子２　index1+1を入れることで1つ目の演算子よりも後ろで検索する

            /*String operators[] = {"+", "-", "*", "/"}; //数値の取得
            for (String search : operators) {
                int operatorPosition = formula.indexOf(search);
                if (operatorPosition != -1) {
                    String operator = formula.substring(operatorPosition, operatorPosition + 1);
                    String num1 = formula.substring(0, operatorPosition);
                    String num2 = formula.substring(operatorPosition + 1);
                    value1 = Integer.parseInt(num1);
                    value2 = Integer.parseInt(num2);
                    switch (operator) {

                        case "+":
                            total = value1 + value2;
                            break;

                        case "-":
                            total = value1 - value2;
                            break;

                        case "*":
                            total = value1 * value2;
                            break;

                        case "/":
                            total = value1 / value2;
                            break;
                    }


                } else {
                    continue;
                }
            }*/
        }
    }
    public static int operatorsIndexOf(String formula,int start){
        int operatorPlusIndex = formula.indexOf("+",start); //文字列にそれぞれの演算子があるかチェック
        int operatorMinusIndex = formula.indexOf("-",start);
        int operatorMultiplicationIndex = formula.indexOf("*",start);
        int operatorDivisionIndex = formula.indexOf("/",start);

        int index = operatorPlusIndex;//＋を基準にして一番近い演算子を検索してくる

        if(index==-1||(index>operatorMinusIndex && operatorMinusIndex != -1)){
            index = operatorMinusIndex;
        }
        if(index==-1||(index>operatorMultiplicationIndex &&operatorMultiplicationIndex != -1)){
            index = operatorMultiplicationIndex;
        }

        if (index==-1||(index>operatorDivisionIndex && operatorDivisionIndex != -1)){
            index = operatorDivisionIndex;
        }
        return  index;
    }
}





