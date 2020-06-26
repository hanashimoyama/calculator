import java.math.BigDecimal;

public class Analysis {
    private String formula, before, after;
    private int Index;


    public static int operatorsIndexOf(String formula, int start) {
        int operatorPlusIndex = formula.indexOf("+", start);
        int operatorMinusIndex = formula.indexOf("-", start);
        int operatorMultiplicationIndex = formula.indexOf("*", start);
        int operatorDivisionIndex = formula.indexOf("/", start);

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

    public static int firstOperatorsIndexOf(String formula) {
        int operatorMultiplicationIndex = formula.indexOf("*");
        int operatorDivisionIndex = formula.indexOf("/");

        int firstIndex = operatorMultiplicationIndex;
        if (firstIndex == -1 || operatorMultiplicationIndex > operatorDivisionIndex && operatorDivisionIndex != -1) {
            firstIndex = operatorDivisionIndex;
        }
        return firstIndex;
    }

    public static int beforeOperatorsIndexOf(String formula) {
        int operatorPlusIndex = formula.lastIndexOf("+");
        int operatorMinusIndex = formula.lastIndexOf("-");
        int operatorMultiplicationIndex = formula.lastIndexOf("*");
        int operatorDivisionIndex = formula.lastIndexOf("/");

        int beforeIndex = operatorPlusIndex;

        if (beforeIndex == -1 || (beforeIndex < operatorMinusIndex && operatorMinusIndex != -1)) {
            beforeIndex = operatorMinusIndex;
        }
        if (beforeIndex == -1 || (beforeIndex < operatorMultiplicationIndex && operatorMultiplicationIndex != -1)) {
            beforeIndex = operatorMultiplicationIndex;
        }

        if (beforeIndex == -1 || (beforeIndex < operatorDivisionIndex && operatorDivisionIndex != -1)) {
            beforeIndex = operatorDivisionIndex;
        }
        return beforeIndex;
    }

    public static String[] split(String formula) {
        int firstOperatorIndex = (firstOperatorsIndexOf(formula));

        String formulas[] = new String[2];
        formulas[0] = formula.substring(0, firstOperatorIndex);
        formulas[1] = formula.substring(firstOperatorIndex + 1);

        return formulas;
    }

    public static int[] formulasIndex(String before, String after) {
        int formulasIndex[] = new int[2];
        formulasIndex[0] = beforeOperatorsIndexOf(before);
        formulasIndex[1] = operatorsIndexOf(after, 0);


        return formulasIndex;

    }

    public static String[] numbers(String before, String after, int beforeOperatorIndex, int afterOperatorIndex) {
        String numbers[] = new String[2];

        if (beforeOperatorIndex == -1) {
            numbers[0] = before;
        } else {
            numbers[0] = before.substring(beforeOperatorIndex + 1);
        }
        if (afterOperatorIndex == -1) {

            numbers[1] = after;
        } else {
            numbers[1] = after.substring(0, afterOperatorIndex);
        }
        return numbers;
    }

    public static String newFormula(String before, String after, int beforeOperatorIndex, int afterOperatorIndex, BigDecimal result){
        String formula2;
        if (beforeOperatorIndex != -1 && afterOperatorIndex != -1) {
            formula2 = before.substring(0, beforeOperatorIndex + 1) + result + after.substring(afterOperatorIndex);
        } else if (beforeOperatorIndex == -1 && afterOperatorIndex != -1) {
            formula2 = result + after.substring(afterOperatorIndex);
        } else if (beforeOperatorIndex != -1 && afterOperatorIndex == -1) {
            formula2 = before.substring(0, beforeOperatorIndex + 1) + result;
        } else{
            formula2 = result.toPlainString();
        }

        return formula2;
    }
}
