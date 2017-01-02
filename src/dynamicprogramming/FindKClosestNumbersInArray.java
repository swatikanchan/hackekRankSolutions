package dynamicprogramming;

/**
 * Created by Swati on 11-10-2016.
 */
public class FindKClosestNumbersInArray {
    public static void main(String[] args) {
        int[] inputArray = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int searchElement = 35;
        int midLocation = findMidElement(inputArray,searchElement,0,inputArray.length-1);
    }

    private static int findMidElement(int[] inputArray, int searchElement, int startIndex, int endIndex) {
        if(inputArray[startIndex]==searchElement)
            return startIndex;
        if(startIndex<endIndex) {
            int midIndex = startIndex+(endIndex-startIndex)/2;
            if(searchElement==inputArray[midIndex])
                return midIndex;
            else if(searchElement<inputArray[midIndex])
            {
                return findMidElement(inputArray,searchElement,startIndex,midIndex);
            }
            else
            {
                return findMidElement(inputArray,searchElement,midIndex+1,endIndex);
            }
        }
        return -(startIndex+1);
    }
}
