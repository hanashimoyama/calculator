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

            int total = 0;
            int index= operatorsIndexOf(formula);//演算子1
            if (index == -1) {
                System.out.println("正しい式を入力してください");
                System.out.print("式:");
                continue;
            }


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
            //ループ処理をぬけて演算子がこれ以上無いときの処理
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



    public static int operatorsIndexOf(String formula) {
        int operatorPlusIndex = formula.indexOf("+"); //文字列にそれぞれの演算子があるかチェック
        int operatorMinusIndex = formula.indexOf("-");
        int operatorMultiplicationIndex = formula.indexOf("*");
        int operatorDivisionIndex = formula.indexOf("/");

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
}




