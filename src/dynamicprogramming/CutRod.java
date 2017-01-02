package dynamicprogramming;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Swati on 09-10-2016.
 */
public class CutRod {
    public static void main(String[] args) {
        int[] priceArray = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        int[] inputArray = new int[priceArray.length + 1];
        initializeInputArray(priceArray, inputArray);
        int[] revenueArray = new int[priceArray.length];
        int[] sizeArray = new int[priceArray.length];
        calculateMaximumRevenueAndSize(inputArray, revenueArray, sizeArray);
        String strRevenueArrayValues = "", strSizeArrayValues = "";
        printOutputValues(revenueArray, sizeArray, strRevenueArrayValues, strSizeArrayValues);
    }

    private static void printOutputValues(int[] revenueArray, int[] sizeArray, String strRevenueArrayValues, String strSizeArrayValues) {
        strRevenueArrayValues = String.valueOf(revenueArray[0]);
        strSizeArrayValues = String.valueOf(sizeArray[0]);
        for (int i = 1; i < revenueArray.length; i++) {
            strRevenueArrayValues = strRevenueArrayValues + " " + revenueArray[i];
            strSizeArrayValues = strSizeArrayValues + " " + sizeArray[i];
        }
        System.out.println(strRevenueArrayValues);
        System.out.println(strSizeArrayValues);
    }

    private static void initializeInputArray(int[] priceArray, int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            inputArray[i] = priceArray[i - 1];
        }
    }

    private static void calculateMaximumRevenueAndSize(int[] inputArray, int[] revenueArray, int[] sizeArray) {
        int maximumRevenue = Integer.MIN_VALUE;
        for (int i = 1; i < inputArray.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (maximumRevenue < inputArray[j] + inputArray[i - j]) {
                    maximumRevenue = inputArray[j] + inputArray[i - j];
                    sizeArray[i - 1] = j;
                }
            }
            revenueArray[i - 1] = maximumRevenue;
        }
    }


}
