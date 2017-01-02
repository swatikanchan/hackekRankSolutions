package dynamicprogramming;

/**
 * Created by Swati on 12-10-2016.
 */
public class FindMinimumElementinCircullaryShiftedArray {
    public static void main(String[] args) {
        int[] inputArray = {27,29,35,42,5,15};
        int minElement = findMin(inputArray,0,inputArray.length-1);
        System.out.println(minElement);
    }

    private static int findMin(int[] inputArray, int startIndex, int endIndex) {
        if(startIndex<endIndex)
        {
            int middle = startIndex+(endIndex-startIndex)/2;
                if (inputArray[middle] < inputArray[middle - 1]) {
                    return inputArray[middle];
                } else if(inputArray[middle]>inputArray[endIndex])
                {
                    return findMin(inputArray,middle+1,endIndex);
            }
            else
                {
                    return findMin(inputArray,startIndex,middle);
                }
        }
        return inputArray[startIndex];
    }
}
