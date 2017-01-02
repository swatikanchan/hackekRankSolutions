/**
 * Created by Swati on 03-10-2016.
 */

import java.util.Scanner;
import java.math.*;

public class ArrayRotationIndex {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int elementCount = scan.nextInt();
        int[] inputArray = new int[elementCount];
        for (int i = 0; i < elementCount; i++) {
            inputArray[i] = scan.nextInt();
        }
        scan.close();
        int rotationIndex = findRotationIndex(inputArray, 0, elementCount - 1);
       // int rotationIndex = findPivotIndex(inputArray, 0, elementCount);
        System.out.println(rotationIndex);


    }

    private static int findPivotIndex(int[] inputArray, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (inputArray[midIndex] > inputArray[midIndex + 1])
                return midIndex + 1;
            if (inputArray[startIndex] > inputArray[midIndex])
                return findPivotIndex(inputArray, startIndex, midIndex);
            else
                return findPivotIndex(inputArray, midIndex + 1, endIndex);
        }
        return Integer.MIN_VALUE;
    }

    public static int findRotationIndex(int[] array, int startIndex, int endIndex) {
        int midIndex = 0;
        if (startIndex < endIndex) {

                midIndex = startIndex + (endIndex - startIndex) / 2;
                if (array[midIndex] > array[midIndex + 1]) {
                    return midIndex+1;
                }
                else
                {
                    if(array[startIndex]>array[midIndex]) {
                        return findRotationIndex(array, startIndex, midIndex);
                    }
                    else {
                        return findRotationIndex(array, midIndex+1, endIndex);
                    }
                }

        }
            return midIndex;
    }
}
