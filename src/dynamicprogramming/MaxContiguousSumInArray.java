package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Swati on 10-10-2016.
 */
public class MaxContiguousSumInArray {
    public static void main(String[] args) {
        int[] inputArray = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int highestSum = 0, sum = 0;
        highestSum = getHighestSum(inputArray, highestSum, sum);
        System.out.println(highestSum);
    }

    private static int getHighestSum(int[] inputArray, int highestSum, int sum) {
        for(int i=0;i<inputArray.length;i++)
        {
            sum = sum+inputArray[i]>0 ? sum+inputArray[i] : 0;
            if(highestSum<sum)
            {
                highestSum = sum;
            }
        }

        return highestSum;
    }


}
