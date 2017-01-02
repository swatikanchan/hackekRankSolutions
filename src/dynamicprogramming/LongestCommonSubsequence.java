package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Swati on 09-10-2016.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter first String: ");
        String firstString = scan.nextLine();
        System.out.print("Please enter second String: ");
        String secondString = scan.nextLine();

        char[] strFirstStringArray = firstString.toCharArray();
        char[] strSecondStringArray = secondString.toCharArray();
        int[][] intMatchArray = new int[strFirstStringArray.length + 1][strSecondStringArray.length + 1];
        String[][] strArrowToOutput = new String[strFirstStringArray.length + 1][strSecondStringArray.length + 1];
        String longestCommonSubsequence = "";

        computeStringMatchArrayValues(strFirstStringArray, strSecondStringArray, intMatchArray, strArrowToOutput);

        longestCommonSubsequence = computeLongestCommonSubsequence(strFirstStringArray, strSecondStringArray, longestCommonSubsequence, strArrowToOutput);

        System.out.print("Longest common subsequence is: ");
        System.out.println(new StringBuilder(longestCommonSubsequence).reverse());
    }

    private static String computeLongestCommonSubsequence(char[] strFirstStringArray, char[] strSecondStringArray, String longestCommonSubsequence, String[][] strArrowToOutput) {
        String str;
        int temp = strSecondStringArray.length;

        for (int rowIndex = strFirstStringArray.length; rowIndex > 0; rowIndex--) {

            for (int columnIndex = temp; columnIndex > 0; columnIndex--) {

                str = strArrowToOutput[rowIndex][columnIndex];

                switch (str) {
                    case "|":
                        columnIndex = 0;
                        break;
                    case "-":
                        break;
                    default:
                        longestCommonSubsequence = longestCommonSubsequence + strFirstStringArray[rowIndex - 1];
                        temp = columnIndex - 1;
                        columnIndex = 0;
                        break;
                }
            }
        }
        return longestCommonSubsequence;
    }

    private static void computeStringMatchArrayValues(char[] strFirstStringArray, char[] strSecondStringArray, int[][] intMatchArray, String[][] strArrowToOutput) {

        for (int rowIndex = 1; rowIndex <= strFirstStringArray.length; rowIndex++) {
            for (int columnIndex = 1; columnIndex <= strSecondStringArray.length; columnIndex++) {

                if (strFirstStringArray[rowIndex - 1] == strSecondStringArray[columnIndex - 1]) {
                    intMatchArray[rowIndex][columnIndex] = intMatchArray[rowIndex - 1][columnIndex - 1] + 1;
                    strArrowToOutput[rowIndex][columnIndex] = "\\";
                } else {
                    if (intMatchArray[rowIndex - 1][columnIndex] >= intMatchArray[rowIndex][columnIndex - 1]) {
                        intMatchArray[rowIndex][columnIndex] = intMatchArray[rowIndex - 1][columnIndex];
                        strArrowToOutput[rowIndex][columnIndex] = "|";
                    } else {
                        intMatchArray[rowIndex][columnIndex] = intMatchArray[rowIndex][columnIndex - 1];
                        strArrowToOutput[rowIndex][columnIndex] = "-";
                    }
                }
            }
        }

    }
    /*private static String computeLongestCommonSubsequenceOld(char[] strFirstStringArray, char[] strSecondStringArray, int[][] intMatchArray, String longestCommonSubsequence) {
        int temp=1;
        for(int rowIndex=1;rowIndex<=strFirstStringArray.length;rowIndex++) {
            for (int columnIndex = temp; columnIndex <= strSecondStringArray.length; columnIndex++) {
                if(intMatchArray[rowIndex][columnIndex]>intMatchArray[rowIndex][columnIndex-1])
                {
                    temp=columnIndex+1;
                    longestCommonSubsequence=longestCommonSubsequence+strFirstStringArray[rowIndex];
                    continue;
                }
            }
        }
        return longestCommonSubsequence;
    }*/
}
