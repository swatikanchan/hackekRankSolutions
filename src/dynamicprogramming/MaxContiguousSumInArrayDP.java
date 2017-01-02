package dynamicprogramming;

/**
 * Created by Swati on 10-10-2016.
 */
public class MaxContiguousSumInArrayDP {
    public static void main(String[] args) {
        int[] inputArray = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int sum = 0;
        sum = getSum(inputArray, sum);
        System.out.println(sum);
    }

    private static int getSum(int[] inputArray, int sum) {
        for(int i=inputArray.length-1;i>=0;i--)
        {
            if(inputArray[i]>0)
            {
                //sum = sum+inputArray[i]>inputArray[i] ? sum+inputArray[i]:inputArray[i];
                sum = sum+inputArray[i];
            }
            else
            {
                sum = sum+inputArray[i]>0 ? sum+inputArray[i]:0;
            }
        }
        return sum;
    }
}
