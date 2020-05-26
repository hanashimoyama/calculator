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
            int index= operatorsIndexOf(formula,0);//演算子1
            if (index == -1) {
                System.out.println("正しい式を入力してください");
                System.out.print("式:");
                continue;
            }
                String formula2 = formula;
                int firstOperatorIndex = firstOperatorsIndexOf(formula2, 0);
                String before = formula2.substring(0, firstOperatorIndex);
                String reverse = new StringBuilder(before).reverse().toString();
                String after = formula2.substring(firstOperatorIndex+1);

                int beforeOperatorIndex = operatorsIndexOf(reverse,0);
                int afterOperatorIndex = operatorsIndexOf(after,0);

                int value1 = Integer.parseInt(reverse.substring(0,beforeOperatorIndex));
                int value2 = Integer.parseInt(after.substring(0,afterOperatorIndex));
                









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
    /*public static int beforeOperatorsIndexOf(String reverse,int start) {
        int operatorPlusIndex =reverse.indexOf("+",start); //文字列にそれぞれの演算子があるかチェック
        int operatorMinusIndex = reverse.indexOf("-",start);
        int operatorMultiplicationIndex = reverse.indexOf("*",start);
        int operatorDivisionIndex =reverse.indexOf("/",start);

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

    public static int afterOperatorsIndexOf(String after,int start) {
        int operatorPlusIndex = after.indexOf("+",start); //文字列にそれぞれの演算子があるかチェック
        int operatorMinusIndex = after.indexOf("-",start);
        int operatorMultiplicationIndex = after.indexOf("*",start);
        int operatorDivisionIndex = after.indexOf("/",start);

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
    }*/
}




