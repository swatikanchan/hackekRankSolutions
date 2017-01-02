package dynamicprogramming;

/**
 * Created by Swati on 09-10-2016.
 */
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] matrixDimensionsArray = {30, 35, 15, 5, 10, 20, 25};
        int count = matrixDimensionsArray.length-1;
        int[][] optimalMultiplicationsArray = new int[count][count];
        int[][] optimalIndexArray = new int[count][count];
        initializeOutputArrayToDefaultValues(count, optimalMultiplicationsArray);
        int optimalMultiplication = Integer.MIN_VALUE;
        calculateOptimalMultiplications(count, optimalMultiplicationsArray, optimalIndexArray, matrixDimensionsArray);
        printOutput(count, optimalMultiplicationsArray, optimalIndexArray);
    }

    private static void initializeOutputArrayToDefaultValues(int n, int[][] optimalMultiplicationsArray) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j)
                    optimalMultiplicationsArray[i][j] = Integer.MAX_VALUE;
                else if (i == j)
                    optimalMultiplicationsArray[i][j] = 0;
            }
        }
    }

    private static void printOutput(int n, int[][] m, int[][] s) {
        System.out.println("Row Index  Column Index    Minimum Cost Matrix   Size Matrix");

        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int columnIndex = 0; columnIndex < n; columnIndex++) {

                if (rowIndex < columnIndex) {
                    System.out.println("------------------------------------------------------------");
                    System.out.println(rowIndex + "\t\t\t" + columnIndex + "\t\t\t\t" + m[rowIndex][columnIndex] + "\t\t\t\t\t" + s[rowIndex][columnIndex]);
                }
            }
        }
    }

    private static void calculateOptimalMultiplications(int n, int[][] optimalMultiplicationsArray, int[][] optimalIndexArray, int[] matrixDimensionsArray) {
        int optimalMultiplication;
        for (int chainLength = 2; chainLength <= n; chainLength++) {
            for (int initialIndex = 0; initialIndex < n - chainLength + 1; initialIndex++) {
                int endIndex = initialIndex + chainLength - 1;
                for (int midIndex = initialIndex; midIndex < endIndex; midIndex++) {
                    optimalMultiplication = optimalMultiplicationsArray[initialIndex][midIndex] + optimalMultiplicationsArray[midIndex + 1][endIndex]
                            + matrixDimensionsArray[initialIndex] * matrixDimensionsArray[midIndex + 1] * matrixDimensionsArray[endIndex + 1];
                    if (optimalMultiplication < optimalMultiplicationsArray[initialIndex][endIndex]) {
                        optimalMultiplicationsArray[initialIndex][endIndex] = optimalMultiplication;
                        optimalIndexArray[initialIndex][endIndex] = midIndex;
                    }
                }
            }
        }
    }
}
