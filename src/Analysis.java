import java.math.BigDecimal;

public class Analysis {


    private static int[] operators(String formula) {
        int array[] = new int[4];

        array[0] = formula.indexOf("+");
        array[1] = formula.indexOf("-");
        array[2] = formula.indexOf("*");
        array[3] = formula.indexOf("/");


        return array;
    }

    public static int operatorsIndexOf(String formula) {
        int indexes[] = operators(formula);
        if (indexes[2] != -1 && indexes[3] != -1) {
            if (indexes[2] < indexes[3]) {
                return indexes[2];
            } else {
                return indexes[3];
            }
        } else if (indexes[2] != -1) {
            return indexes[2];
        } else if (indexes[3] != -1) {
            return indexes[3];
        } else {
            if (indexes[0] == -1) {
                return indexes[1];
            } else if (indexes[1] == -1) {
                return indexes[0];
            } else {
                if (indexes[0] < indexes[1]) {
                    return indexes[0];
                } else {
                    return indexes[1];
                }
            }
        }
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

    public static int afterOperatorsIndexOf(String formula) {
        int operatorPlusIndex = formula.indexOf("+");
        int operatorMinusIndex = formula.indexOf("-");
        int operatorMultiplicationIndex = formula.indexOf("*");
        int operatorDivisionIndex = formula.indexOf("/");

        int afterIndex = operatorPlusIndex;

        if (afterIndex == -1 || (afterIndex > operatorMinusIndex && operatorMinusIndex != -1)) {
            afterIndex = operatorMinusIndex;
        }
        if (afterIndex == -1 || (afterIndex > operatorMultiplicationIndex && operatorMultiplicationIndex != -1)) {
            afterIndex = operatorMultiplicationIndex;
        }

        if (afterIndex == -1 || (afterIndex > operatorDivisionIndex && operatorDivisionIndex != -1)) {
            afterIndex = operatorDivisionIndex;
        }
        return afterIndex;
    }

    public static String[] split(String formula) {
        int operatorIndex = (operatorsIndexOf(formula));

        String formulas[] = new String[2];
        formulas[0] = formula.substring(0, operatorIndex);
        formulas[1] = formula.substring(operatorIndex + 1);

        return formulas;
    }

    public static int[] formulasIndexes(String before, String after) {
        int formulasIndex[] = new int[2];
        formulasIndex[0] = beforeOperatorsIndexOf(before);
        formulasIndex[1] = afterOperatorsIndexOf(after);


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

    public static String newFormula(String before, String after, int beforeOperatorIndex, int afterOperatorIndex, BigDecimal result) {
        String formula;
        if (beforeOperatorIndex != -1 && afterOperatorIndex != -1) {
            formula = before.substring(0, beforeOperatorIndex + 1) + result + after.substring(afterOperatorIndex);
        } else if (beforeOperatorIndex == -1 && afterOperatorIndex != -1) {
            formula = result + after.substring(afterOperatorIndex);
        } else if (beforeOperatorIndex != -1 && afterOperatorIndex == -1) {
            formula = before.substring(0, beforeOperatorIndex + 1) + result;
        } else {
            formula = result.toPlainString();
        }

        return formula;
    }

}
