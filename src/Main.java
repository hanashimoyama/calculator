//1.四則演算の実装。(ex)1 + 1 + 1)
import java.util.Scanner;
import java.util.Spliterator;

public class Main {
    public static <string> void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("式:");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String formula = line.replace(" ", "");
            int total = 0;

            int index1 = operatorsIndexOf(formula, 0);//演算子１
            if(index1 == -1){
               System.out.println("正しい式を入力してください");
               continue;
            }

            total = Integer.parseInt(formula.substring(0, index1));//合計をいれる値を作成
            int index2 = operatorsIndexOf(formula, index1 + 1);//演算子２　index1+1を入れることで1つ目の演算子よりも後ろで検索する

            while (index2 != -1) {
                int value2 = Integer.parseInt(formula.substring(index1 + 1, index2)); //演算子があるか検索して見つかった時の処理
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
                int value2 = Integer.parseInt(formula.substring(index1+1));
                switch (formula.charAt(index1)){

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
                }
                System.out.println(total);
        }
    }

    public static int operatorsIndexOf(String formula, int start) {
        int operatorPlusIndex = formula.indexOf("+", start); //文字列にそれぞれの演算子があるかチェック
        int operatorMinusIndex = formula.indexOf("-", start);
        int operatorMultiplicationIndex = formula.indexOf("*", start);
        int operatorDivisionIndex = formula.indexOf("/", start);

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
}