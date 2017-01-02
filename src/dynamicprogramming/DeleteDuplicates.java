package dynamicprogramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Swati on 09-11-2016.
 * O(n) time and O(1) space solution.
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfElements = scan.nextInt();
        int[] numArray = new int[numOfElements];
        for(int i=0;i<numOfElements;i++)
        {
            numArray[i] = scan.nextInt();
        }
        numArray = Arrays.copyOf(deleteDuplicates(numArray),numOfElements);
        for(int i=0;i<numOfElements;i++) {
            System.out.println(numArray[i]);
        }
    }
    public static int[] deleteDuplicates(int[] inputArray)
    {
        int countZero=0;
        int sameElement = 0;
        for(int i=1;i<inputArray.length;i++)
        {
            if(inputArray[i-1]==inputArray[i])
            {
                sameElement++;
                countZero++;
            }
            else
            {
                if(sameElement>0) {
                    inputArray[i - sameElement] = inputArray[i];
                    sameElement = 1;
                }
            }
        }
        int j=1;
        while(countZero>0)
        {
            inputArray[inputArray.length-j]=0;
            j++;
            countZero--;
        }
        return inputArray;
    }
}
