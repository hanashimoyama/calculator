//1.四則演算の実装。(ex)1 + 1 + 1)
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
            //String operators = "[+-*/]";
            int total = 0;
            int index1 = operatorsIndexOf(formula, 0);//演算子１
            if (index1 == -1) {
                System.out.println("正しい式を入力してください");
                System.out.print("式:");
                continue;
            }

            total = Integer.parseInt(formula.substring(0, index1));//合計をいれる値を作成
            //int priorityIndex = priorityOperators(formula,0);
            int index2 = operatorsIndexOf(formula, index1 + 1);//演算子２　index1+1を入れることで1つ目の演算子よりも後ろで検索する

            /*while (index2 != -1&&index1 !=1){
                int value2 = Integer.parseInt(formula.substring(index1 + 1,index2));
                int priorityIndex = formula.lastIndexOf(operators,index1);
                int priorityValue = Integer.parseInt(formula.substring(index1-1,priorityIndex));
                String operator1 = formula.substring(index1,index1+1);
                String operator2 = formula.substring(index2,index2+1);
                System.out.println("a");

                switch (formula.charAt(index1)){
                    case'+':
                }
                break;
            }*/

            while (index2 != -1) {
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
            //ループ処理をぬけて演算子がこれ以上無いときの処理
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
                        break;

                }
            System.out.println(total);
            System.out.print("式:");
               /*System.out.println("もう1度計算しますか？YESなら１を、NOなら２を押してください");
                while(sc.hasNextLine()){
                    String continuity = sc.nextLine();

                    if(continuity.equals("1")){
                        main(args);
                    }

                    if (continuity.equals("2")){
                        System.exit(0);
                    }

                    else {
                        System.out.println("1か2を入力してください");

                    }
                }*/


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

    /*public static int priorityOperators(String formula, int priority) {
        int operatorMultiplicationIndex = formula.indexOf("*", priority);
        int operatorDivisionIndex = formula.indexOf("/", priority);
        int priorityIndex= operatorMultiplicationIndex;

        if (priorityIndex == -1 || (priority > operatorDivisionIndex && operatorDivisionIndex != -1)) {
            priorityIndex = operatorDivisionIndex;
        }
        return  priorityIndex;
    }*/
}