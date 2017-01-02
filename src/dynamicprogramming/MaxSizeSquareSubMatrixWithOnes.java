package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Swati on 10-10-2016.
 */
public class MaxSizeSquareSubMatrixWithOnes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter dimensions of bit matrix: ");
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        int[][] bitArray = new int[rows][columns];
        System.out.println("Please enter array values");
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                bitArray[rowIndex][columnIndex] = scan.nextInt();
            }
        }
        int[][] sizeArray = new int[rows][columns];
        int maxSizeOfOnesArray = initializeSizeArray(rows, columns, bitArray, sizeArray);
        drawMaxSizeSquareSubMatrixWithOnes(maxSizeOfOnesArray);
    }

    private static void drawMaxSizeSquareSubMatrixWithOnes(int maxSizeOfOnesArray) {
        System.out.println("Maximum size of square sub array with all 1's is: "+maxSizeOfOnesArray);
        for(int i=0;i<maxSizeOfOnesArray;i++)
        {
            for(int j=0;j<maxSizeOfOnesArray;j++)
            {
                System.out.print("1");
            }
            System.out.println();
        }
    }

    private static int initializeSizeArray(int rows, int columns, int[][] bitArray, int[][] sizeArray) {
        int maxValue = 0;
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                if (rowIndex == 0 || columnIndex == 0) {
                    sizeArray[rowIndex][columnIndex] = bitArray[rowIndex][columnIndex];
                } else {
                    if (bitArray[rowIndex][columnIndex] == 0) {
                        sizeArray[rowIndex][columnIndex] = 0;
                    } else {
                        if (bitArray[rowIndex][columnIndex - 1] == 0 || bitArray[rowIndex - 1][columnIndex] == 0 ||
                                bitArray[rowIndex - 1][columnIndex - 1] == 0) {
                            sizeArray[rowIndex][columnIndex] = 1;
                        } else {
                            sizeArray[rowIndex][columnIndex] = findMinimum(sizeArray[rowIndex][columnIndex - 1],
                                    sizeArray[rowIndex - 1][columnIndex], sizeArray[rowIndex - 1][columnIndex - 1]) + 1;
                        }
                        if (maxValue < sizeArray[rowIndex][columnIndex]) {
                            maxValue = sizeArray[rowIndex][columnIndex];
                        }
                    }
                }
            }
        }
        return maxValue;
    }

    private static int findMinimum(int firstInteger, int secondInteger, int thirdInteger) {
        int min = firstInteger<secondInteger?(firstInteger<thirdInteger?firstInteger:thirdInteger):
                (secondInteger<thirdInteger?secondInteger:thirdInteger);
        return min;
    }
}
